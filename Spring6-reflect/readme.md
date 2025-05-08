# Java反射

**Java反射机制是在运行状态中,对于任意一个类,都能够知道这个类的所有属性和方法;对于任意一个对象,都能够调用它的任意方法和属性;这种动态获取信息以及动态调用用对象方法的功能称为Java语言的反射机制。简单来说,反射机制指的是程序在运行时能够获取自身的信息。**

要想解剖一个类,必须先要\*获取到该类的Class对象\*\*。而剖析一个类或用反射解决具体的问题就是使用相关API&#x20;

(1) iava.lang.Class&#x20;

(2) iava.lang.reflect.

所以,==Class对象是反射的根源==

# 获取class多种方法

1.类名.class

2.对象.getclass

3.class.forName()

    Class ClassCar = Car.class;

    Class clazz = new Car().getClass();

    Class clazz2 = Class.forName("com.atguigu.reflect.Car");

# 获取构造方法

```java
@Test
 public void test02() throws Exception {
     Class clazz = Car.class;
     Constructor[] constructor = clazz.getConstructors();  //不可以获取私有方法
     Constructor[] constructors = clazz.getDeclaredConstructors();//可以获取私有犯法
     for (Constructor constructor1 : constructor) {
         System.out.println(constructor1);
     }
     for (Constructor constructor1 : constructors) {
         System.out.println(constructor1);
     }

        Class clazz = Car.class;

        // public方法可以
        Constructor c1 = clazz.getConstructor(String.class, String.class, int.class);
        Car car1 = (Car) c1.newInstance("夏利", "红色", 25);
        System.out.println(car1);

//        private方法可以
        Constructor c2 = clazz.getDeclaredConstructor(String.class, String.class, int.class);
        c2.setAccessible(true);
        Car car2 = (Car) c2.newInstance("夏利", "红色", 25);
        System.out.println(car2);

 }
```

# 获取属性

```java
    @Test
    public void test03() throws Exception {
        Class clazz = Car.class;
        Car car = (Car) clazz.getDeclaredConstructor().newInstance();
//        获取所有的pwublic属性
//        Field[]  fileds = clazz.getFields();
        Field[] fileds = clazz.getDeclaredFields();
        for (Field field : fileds) {
            if(field.getName().equals("name"))
            {
                field.setAccessible(true);
                field.set(car,"武林宏观");
                System.out.println(car);
            }
            System.out.println(field);
        }

    }
```

# 获取方法

```java
    @Test
    public void test04() throws Exception {
        Car car = new Car("夏利", "red", 25);
        Class clazz = car.getClass();
        Method[] methods = clazz.getMethods();

//        public 方法
        for (Method method : methods) {
//            System.out.println(method.getName());
            if (method.getName().equals("toString")) {
                String invoke = (String) method.invoke(car);
                System.out.println(invoke);
            }
        }

        Method[] methods1 = clazz.getDeclaredMethods();

//        private 方法
        for (Method method : methods1) {
//            System.out.println(method.getName());
            if (method.getName().equals("run")) {
                method.setAccessible(true);
                method.invoke(car);
            }
        }

```

