package myspring.di.xml.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import myspring.di.xml.Hello;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanSpringTest {
	
	@Autowired
	private ApplicationContext context;
	
	@Test @Ignore
	public void bean1() {
		Hello hello = (Hello) context.getBean("hello");
		Hello hello2 = context.getBean("hello", Hello.class);
		
		assertSame(hello, hello2);
	}
	
	@Test
	public void test1() {
		Hello hello = (Hello)context.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());
		
		Hello hello2 = (Hello)context.getBean("hello2");
		assertEquals(3, hello2.getNames().size());
		List<String> list = hello2.getNames();
		for (String value : list) {
			System.out.println(value);
		}
	}
}