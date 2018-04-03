package example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(DemoApplication.class).run(args);
        for(String s : ctx.getBeanDefinitionNames()){
            System.out.println(s);
        }	
        MyBean b = (MyBean) ctx.getBean("myBean");
        System.out.println("------------------ For Before - After - AfterReturning - AfterThrowing");
        b.theMethod(1);
        System.out.println("------------------ For Before - After - AfterReturning - AfterThrowing");
        System.out.println("------------------ For Around");
        b.theMethodAround(5);
        System.out.println("------------------ For Around");
        System.out.println("------------------ For Argument");
        b.theMethodArgument(6);
        System.out.println("------------------ For Argument");
        
        System.err.println("------------------ Exceptions");
        System.out.println();
        
        System.out.println("------------------ For Before - After - AfterReturning - AfterThrowing");
        try{b.theMethod(10);}catch (Exception e) {}
        System.out.println("------------------ For Before - After - AfterReturning - AfterThrowing");
        System.out.println("------------------ For Around");
        try{b.theMethodAround(10);}catch (Exception e) {}
        System.out.println("------------------ For Around");
        System.out.println("------------------ For Argument");
        try{b.theMethodArgument(10);}catch(Exception e){}
        System.out.println("------------------ For Argument");
        
	}
}
