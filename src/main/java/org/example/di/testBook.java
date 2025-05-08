package org.example.di;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testBook {
    @Test
    public void test() {
//        System.out.println(book);
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        Book book = (Book) context.getBean("book");
//        System.out.println(book);
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Book book = (Book) context.getBean("bookcon");
        System.out.println(book);
//        DruidDataSource datasouce = new DruidDataSource()
    }
}
