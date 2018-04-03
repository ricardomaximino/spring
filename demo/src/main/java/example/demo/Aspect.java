package example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
	
	@Pointcut(value="execution(** example.demo..*(..))")
	public void pointCut(){
	}
	
	@Pointcut(value="execution(** example.demo.MyBean.theMethodAround(..))")
	public void pointCutAround(){
	}
	
	@Pointcut(value="execution(** example.demo.MyBean.theMethodArgument(int)) && args(myInt)")
	public void pointCutArgument(int myInt){
	}
	@Before(value="pointCut()")
	public void beforeMethod(){
		System.out.println("Before Method");
	}

	@After(value = "pointCut()")
	public void afterMethod(){
		System.out.println("After Method");
	}
	@AfterReturning(value="pointCut()")
	public void afterReturnMethod(){
		System.out.println("After Return Method");
	}
	@AfterThrowing(value="pointCut()")
	public void throwMethod(){
		System.out.println("Thrown Exception Method");
	}
	@Around(value = "pointCutAround()")
	public void aroundMethod(ProceedingJoinPoint pj){
		try{
			System.out.println("Around - Before");
			pj.proceed();
			System.out.println("Around - After");
		}catch(Throwable ex){
			System.out.println("Around - Thrown");
		}
	}
	
	@Before(value="pointCutArgument(myInt)")
	public void argumentMethod(int myInt){
		System.out.println("The argument is: " + myInt);
	}
}
