package myspring.di.xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanTest {
	public static void main(String[] args) {
		
		// IoC Container
		ApplicationContext context = new GenericXmlApplicationContext("config/beans.xml");
		
		// Hello Bean
		Hello hello = (Hello) context.getBean("hello");
		System.out.println(hello.sayHello());
		hello.print();
		
		// StringPrinter Bean
		Printer printer = context.getBean("printer", Printer.class);
		System.out.println(printer.toString());
		
		// Singletone (하나의 Bean만 생성해서 관리함)
		Hello hello2 = context.getBean("hello", Hello.class);
		System.out.println(hello == hello2);
	}
}
