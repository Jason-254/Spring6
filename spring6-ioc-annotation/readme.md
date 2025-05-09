# Spring注解

他是代码中你的一种特殊标记

格式@注解

1.引入依赖

默认文件

2.开启组件扫描

==基本扫描方法==

```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--开启组件扫描-->
    <context:component-scan base-package="org.example"> </context:component-scan>
</beans>

```

==排除扫描方法==

```java
    <!--开启组件扫描-->
    <context:component-scan base-package="org.example">
<!--        根据注解排除-->
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
<!--        根据类型排除-->
        <context:include-filter type="assignable" expression="org.example"/>
    </context:component-scan>
```

3.使用注解定义bean

4.依赖注入

@ Component（泛型）

@Reposiory(Dao层）

@Service(service层)

@Controller（conterol层）

# Autowired属性注入

## 属性注入

## set注入

## &#x20;构造方法注入

## 形参上注入

## \*\*==只有一个构造方法，无注==\*\*释

## Autowire和Quality 联合注入

```javascript
@Autowired
@Qualifier(value = "UserServiceImpl")
```

&#x20;

# Resource注入

\==@Resource(name="")不指定的话，默认使用属性名称==

根据类型进行注入

@Resource注解也可以完成属性注入。那它和@Autowired注解有什么区别?

&#x20;@Resource注解是JDK扩展包中的,也就是说属于JDK的一部分。**所以该注解是标准注解,更加具有通用性**。 (
JSR-250标准中制定的注解类型。JSR是Java规范提案。)

&#x20;==@Autowired注解是Spring框架自己的。==&#x20;

@==Resource注解默认根据名称装配byName,未指定name时,使用属性名作为name。通过name找不到 的话会自动启动通过类型byType装配。==

&#x20;@==Autowired注解默认根据类型装配byType,如果想根据名称装配,需要配合@Qualifier注解一起用。==&#x20;

&#x20;@==Resource注解用在属性上、setter方法上。==

&#x20;@Autowired注解用在属性上、setter方法上、构造方法上、构造方法参数上。

&#x20;@Resource注解属于JDK扩展包,所以不在jDK当中,需要额外引入以下依赖:【如果是JDK8的话不需要额外引入
依赖。高于JDK11或低于JDK8需要引入以下依赖。】
