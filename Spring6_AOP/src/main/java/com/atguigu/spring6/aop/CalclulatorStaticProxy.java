package com.atguigu.spring6.aop;


public class CalclulatorStaticProxy implements Calculator {
    private Calculator calculator;

    public CalclulatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int a, int b) {

        System.out.println("[日志]add方法开始了,参数是:" + a + "," + b);
        int addResult = calculator.add(a, b);
        System.out.println("[日志] add 方法结束是:" + addResult);
        return addResult;

    }

    @Override
    public int sub(int a, int b) {
        System.out.println("[日志]add方法开始了,参数是:" + a + "," + b);
        int addResult = calculator.sub(a, b);
        System.out.println("[日志] add 方法结束是:" + addResult);
        return addResult;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("[日志]add方法开始了,参数是:" + a + "," + b);
        int addResult = calculator.mul(a, b);
        System.out.println("[日志] add 方法结束是:" + addResult);
        return addResult;

    }

    @Override
    public int div(int a, int b) {
        System.out.println("[日志]add方法开始了,参数是:" + a + "," + b);
        int addResult = calculator.div(a, b);
        System.out.println("[日志] add 方法结束是:" + addResult);
        return addResult;

    }

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        CalclulatorStaticProxy calclulatorStaticProxy = new CalclulatorStaticProxy(calculator);
        calclulatorStaticProxy.add(1, 2);
        calclulatorStaticProxy.sub(1, 2);
    }
}
