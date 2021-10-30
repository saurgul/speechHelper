package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class Main {

	//Default spring setup 
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		 System.out.println("Hello World");
		// loading the definitions from the given XML file
/*		ApplicationContext context = new ClassPathXmlApplicationContext("./resources/applicationContext.xml");
 
		HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");
		String message = service.sayHello();
		System.out.println(message);
 
		//set a new name
		service.setName("Spring");
		message = service.sayHello();
		System.out.println(message); */
	}

}
