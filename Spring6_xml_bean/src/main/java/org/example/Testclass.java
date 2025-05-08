package org.example;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testclass {
    @Test
    // 根据id来获取类型
    public void TestClassObject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        App app1 = (App) context.getBean("App");
        System.out.println("1.根据id来说获取类型"+app1);
//        app1.add();

        //根据类型来获取bean对象
        App app2 = context.getBean(App.class);
        System.out.println("2.根据类型来获取对象："+app2);

        //根据id和类型来说去bean
        App app3 = context.getBean("App",App.class);
        System.out.println("3.根据id和类型来获取bean"+app3);

    }


    @Test
    //反射创建对象
    public void TestClassObject2() throws  Exception{
        Class class1 = Class.forName("org.example.App");
        App app = (App) class1.getDeclaredConstructor().newInstance();
        System.out.println(app);
        app.add();
    }

}
