package com.atguigu.bean;

import java.util.HashMap;
import java.util.Map;

//Todo:后面回来再补，赶路要紧
public class AnnotationApplicationContext implements ApplicationContext {
    //创建一恶搞map集合，仿造bean对象
    private Map<Class, Object> beanFactory = new HashMap<>();

    //返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    //创建有参数构造,传递包路径,设置包扫描规则
    //当前包及其子包,哪个类有@Bean注解,把这个类通过反射乡实例化
    public AnnotationApplicationContext(String basePackage) {

    }

}
