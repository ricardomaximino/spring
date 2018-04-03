package example.demo;

import org.springframework.stereotype.Component;

@Component
public class MyBean {
	
	public String theMethod(int i){
		System.out.println("The Method");
		if(i == 10){
			throw new RuntimeException("The int argument is 10");
		}
		return "the Method Returning - " + i;
	}
	
	public String theMethodAround(int i){
		System.out.println("The Method Around");
		if(i == 10){
			throw new RuntimeException("The int argument is 10");
		}
		return "the Around Method Returning - " + i;
	}

	public String theMethodArgument(int i){
		System.out.println("The Method Argument");
		if(i == 10){
			throw new RuntimeException("The int argument is 10");
		}
		return "the Argument Method Returning - " + i;
	}
}
