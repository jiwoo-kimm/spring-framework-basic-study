package myspring.di.xml.test;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;

public class HelloBeanJunitTest {
	
	private ApplicationContext context;
	
	@Before
	public void init() {
		context = new GenericXmlApplicationContext("config/beans.xml");
	}
	
	@Test
	public void bean1() {
		Hello hello = (Hello) context.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());
	}
	
	@Test
	public void bean2() {
		Hello hello = (Hello) context.getBean("hello");
		Hello hello2 = context.getBean("hello", Hello.class);
		
		assertSame(hello, hello2);
	}
}
