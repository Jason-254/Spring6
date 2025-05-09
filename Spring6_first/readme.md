# Spring 是如何创建对象的呢？原理是什么

```java
// dom4j解析beans.xml文件，从中获取class属性值，类的全类名
// 通过反射机制调用无参数构造方法创建对象
Class clazz = Class.forName("com.atguigu.spring6.bean.HelloWorld");
//Object obj = clazz.newInstance();
Object object = clazz.getDeclaredConstructor().newInstance();
```

### 3.1、IoC 容器

#### 3.1.1、控制反转（IoC）

- 控制反转是一种思想。
- 控制反转是为了降低程序耦合度，提高程序扩展力。
- 控制反转，反转的是什么？

-
    - **将对象的创建权利交出去，交给第三方容器负责。**
    - 将对象和对象之间关系的维护权交出去，交给第三方容器负责。

- 控制反转这种思想如何实现呢？

-
    - DI（Dependency Injection）：依赖注入

#### 3.1.2、依赖注入

DI（Dependency Injection）：依赖注入，依赖注入实现了控制反转的思想。

**依赖注入：**

- **指 Spring 创建对象的过程中，将对象依赖属性通过配置进行注入**

