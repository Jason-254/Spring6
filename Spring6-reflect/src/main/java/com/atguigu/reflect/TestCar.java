package com.atguigu.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCar {
    //   获取class多种方法
    @Test
    public void test01() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1.
        Class ClassCar = Car.class;

        Class clazz = new Car().getClass();

        Class clazz2 = Class.forName("com.atguigu.reflect.Car");

//        实例化
        Car objects = (Car) clazz2.getDeclaredConstructor().newInstance();

        System.out.println(objects);
    }

    //    获取构造方法
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

    //    获取属性
    @Test
    public void test03() throws Exception {
        Class clazz = Car.class;
        Car car = (Car) clazz.getDeclaredConstructor().newInstance();
//        获取所有的pwublic属性
//        Field[]  fileds = clazz.getFields();
        Field[] fileds = clazz.getDeclaredFields();
        for (Field field : fileds) {
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(car, "武林宏观");
                System.out.println(car);
            }
            System.out.println(field);
        }

    }

    //
//
//    获取方法
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

    }
}
