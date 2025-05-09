package com.atguigu.spring6.aop;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalculatorTest {

    private Logger logger = LoggerFactory.getLogger(CalculatorTest.class);

    @Test
    public void testAdd() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        com.atguigu.spring6.aop.Calculator calculator = ac.getBean(Calculator.class);
        int add = calculator.add(1, 1);
        System.out.println(add);
        logger.info("执行成功:" + add);
    }

}