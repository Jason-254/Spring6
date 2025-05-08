package com.atguigu.spring6.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private Object target;//目标对象

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //* Proxy.newProxyInstance()方法
    //有三个参数
    //第一个参数:ClassLoader:加载动态生成代理类的类加载器
    //第二个参数:Class[]interfaces:目录对象实现的所有接口的class类型数组
    //第三个参数:InvocationHandler
    public Object getProxy() {

        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            //            第一个参数
//            第二个参数 Method method:正在执行的方法
//            第三个参数 Object[] args:执行方法参数
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("[动态代理][日志]..." + method.getName() + "参数：" + Arrays.toString(args));
                //执行目标对象方法
                Object returnValue = method.invoke(target, args);
                System.out.println("[动态代理][日志]..." + method.getName() + "结果：" + returnValue);
                return returnValue;
            }
        };

        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
