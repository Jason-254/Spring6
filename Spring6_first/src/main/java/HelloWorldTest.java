import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
    private Logger logger = LoggerFactory.getLogger(HelloWorldTest.class);

    @Test
    public void testHelloWorld() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloworld = (HelloWorld) ac.getBean("helloWorld");
        helloworld.sayHello();
        logger.info("执行成功");
    }


//    @Test
//    public void testDIBySet() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-di.xml");
//        Student studentOne = ac.getBean("studentOne", Student.class);
//        System.out.println(studentOne);
//    }

    @Test
    public void testDIByConstructor() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-di.xml");
        Student studentOne = ac.getBean("studentTwo", Student.class);
        System.out.println(studentOne);
    }

}