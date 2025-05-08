# &#x20;Spring 定义

Spring IoC： Inverser of Control 控制反转

Spring AOP ：aspect Oriented Programming  面向切面编程

Spring framework

非侵入式，控制反转、面向切面，容器，组件化，一站式

# 根据id来获取bean

```java
ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
App app = (App) context.getBean("App");
System.out.println("根据id来说获取类型"+app);
```

# 根据类型来获取bean

根据类型获取bean的时候，要求IOC容器中指定类型的bean只能有一个

```java
//根据类型来获取bean对象
ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
App app2 = context.getBean(App.class);
System.out.println("2.根据类型来获取对象："+app2);
```

# &#x20;根据id和类型来说去bean

```java
ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
App app3 = context.getBean('App',App.class);
System.out.println("3.根据id和类型来获取bean"+app3);
```

如果组件类实现了接口，根据接口类型可以获取 bean 吗?
**==可以，前提是bean唯一==**
如果一个接口有多个实现类，这些实现类都配置了 bean，根据接口类型可以获取 bean 吗?
**==不行，因为bean不唯一==**


# &#x20;setter注入

```java
public String getBname() {
    return bname;
}

public String getAuthor() {
    return author;
}

public void setAuthor(String author) {
    this.author = author;
}
public void setBname(String bname) {
    this.bname = bname;
}

Book book =new Book("java","jason");

```

# bean注入

```java
<bean id="book" class="org.example.di.Book">
    <property name="author" value="jason"></property>
    <property name="bname" value="java"> </property>
</bean>
 ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
Book book = (Book) context.getBean("book");
System.out.println(book);
```

# &#x20;构造器注入

```java
    <bean id="bookcon" class="org.example.di.Book">
        <constructor-arg name="bname" value="java">    </constructor-arg>
       <constructor-arg name = "author" value ="jason"> </constructor-arg>

    </bean>

ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
Book book = (Book) context.getBean("bookcon");
System.out.println(book);
```

# &#x20; 特殊值处理

NULL值处理

```java
<property name="others">
    <null></null>
</property>
```

XML实体

```java
<property name="others" value ="&lt;&gt">
</property>
```

CDATA节

```java
<property name="others">
    <value![CDATA[a < b]]> </value>
</property>
```

# 特殊类型属性注入

## 1.对象类型属性注入

&#x20; 1.1 引入外部bean

```java
<!--  1 创建对象-->
<!--  2 在bean 标签中使用property 引入对象-->

<bean id="dept" class="org.example.di.Dept">
    <property name="bname" value="安保部"></property>

</bean>
<bean id="emp" class="org.example.di.Emp">
    <!--普通类型注入-->
    <property name="ename" value="lucky"></property>
    <property name="eage" value="50"></property>
    <!--对象类型注入-->
    <property name="dept" ref="dept"></property>

</bean>
```

1.2内部bean

```java
<!--  1 创建对象-->
<!--  2 在bean 标签中里面使用property 引入对象-->
<bean id="emp" class="org.example.di.Emp">
    <!--普通类型注入-->
    <property name="ename" value="lucky"></property>
    <property name="eage" value="50"></property>
    <!--对象类型注入-->
    <property name="dept" >
        <bean id="dept" class="org.example.di.Dept">
            <property name="bname" value="安保部"></property>
        </bean>
    </property>
```

1.3级联属性赋值

```java
<bean id="dept" class="org.example.di.Dept">
    <property name="bname" value="安保部"></property>

</bean>
<bean id="emp" class="org.example.di.Emp">
    <!--普通类型注入-->
    <property name="ename" value="lucky"></property>
    <property name="eage" value="50"></property>
    <!--对象类型注入-->
    <property name="dept" ref="dept"></property>
    <property name="dept.name" value="测试部"></property>

</bean>
```

## 2.数组类型注入

```java
<!--  注入数组类型-->
<bean id="dept" class="org.example.di.Dept">
    <property name="bname" value="安保部"></property>
</bean>
<bean id="emp" class="org.example.di.Emp">
    <!--普通类型注入-->
    <property name="ename" value="lucky"></property>
    <property name="eage" value="50"></property>
    <!--对象类型注入-->
    <property name="dept" ref="dept"></property>
    <!--注入数组类型属性-->
    <property name="loves"></property>
    <array>
        <value>吃饭</value>
        <value>睡觉</value>
        <value>敲代码</value>
    </array>

</bean>
```

## 对象数组的注入

```java
<bean id="empone" class="org.example.di.Emp">
    <!--普通类型注入-->
    <property name="ename" value="lucky"></property>
    <property name="eage" value="50"></property>
    <!--对象类型注入-->
    <property name="dept" ref="dept"></property>

</bean>
<bean id="emptwo" class="org.example.di.Emp">
    <!--普通类型注入-->
    <property name="ename" value="lucky"></property>
    <property name="eage" value="50"></property>
    <!--对象类型注入-->
    <property name="dept" ref="dept"></property>

</bean>

<!--  注入数组类型-->
<bean id="dept" class="org.example.di.Dept">
    <property name="bname" value="安保部"></property>
    <property name="emlist">
        <list>
            <ref bean="empone">  </ref>
            <ref bean="emptwo">  </ref>
        </list>

    </property>
</bean>
```

## &#x20;map集合类型属性的输入

```java
<property name="map" >
    <map>
        <entry key="10001" value-ref="dept"/>
    </map>
</property>
```

# &#x20;util 进阶util引入

```java
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
       http://www.springframework.org/schema/util
       http://www.springframework.org/schema/util/spring-util.xsd
       http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    <util:list id="lessonlist">
        <ref bean="App">   </ref>
        <ref bean="App">   </ref>
        <ref bean="App">   </ref>
    </util:list>
    <util:map id= "teacher"  >
        <entry key="10010" value-ref="teacher1"/>
        <entry key="10086" value-ref="teacher2"/>
        <entry key="10010" value-ref="teacher"/>
    </util:map  >



    <bean id="teacherone" class="org.example.di.Emp">
        <!--普通类型注入-->
        <property name="ename" value="lucky"></property>
        <property name="eage" value="50"></property>
        <!--list 哥map类型注入-->
        <property name="list" ref = "lessonlist" > </property>
        <property name="map" ref = "lessonlist" > </property>

```

# P命名空间注入

```java
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/beans/p"
       xsi:schemaLocation="
       http://www.springframework.org/schema/util
       http://www.springframework.org/schema/util/spring-util.xsd
       http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

<util:list id="lessonlist">
    <ref bean="App">   </ref>
    <ref bean="App">   </ref>
    <ref bean="App">   </ref>
</util:list>
<util:map id= "teacher"  >
    <entry key="10010" value-ref="teacher1"/>
    <entry key="10086" value-ref="teacher2"/>
    <entry key="10010" value-ref="teacher"/>
</util:map  >

<bean id="teacherone" class="org.example.di.Emp" p:sid="100" p:name ="mary" p:lesson="lessonlist" p:map="teacher">
</bean>
```

# 引入外部文件注入

1.引入数据库相关依赖

新建：jdbc.properties

2.创建外部属性 properties格式

```java
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/coontext"
       xmlns:p="http://www.springframework.org/schema/beans/p"
       xsi:schemaLocation="
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/util
       http://www.springframework.org/schema/util/spring-util.xsd
       http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
```

3创建spring配置文件，引入context空间

```java
<context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
```

