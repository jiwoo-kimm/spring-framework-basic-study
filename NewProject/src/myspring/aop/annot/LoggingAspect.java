package myspring.aop.annot;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	@Before("execution(public * myspring..*(..))")
	public void before(JoinPoint joinPoint) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@Before [ " + signatureString + " ] 전처리 수행");

		for (Object arg : joinPoint.getArgs()) {
			System.out.println("@Before [ " + signatureString + " ] Arguments " + arg);
		}
	}

	// @AfterReturning(포인트컷, 리턴값 침조 객체명)
	@AfterReturning(pointcut="execution(public * myspring.user.service.*.*(..))", returning="ret")
	public void after(JoinPoint joinPoint, Object ret) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@AfterReturning [ " + signatureString + " ] 후처리 수행");
		System.out.println("@AfterReturning [ " + signatureString + " ] Return = " + ret);
	}
	
	// @AfterThrowing(포인트컷, 예외 참조 객체명)
	@AfterThrowing(pointcut = "execution(* *..UserService*.*(..))", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@AfterThrowing [ " + signatureString + " ] 수행 중 예외발생");
		System.out.println("@AfterThrowing [ " + signatureString + " ] Exception = " + ex.getMessage());
	}
	
	@After("execution(* *..*.*User(..))")
	public void afterFinally(JoinPoint joinPoint) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@After [ " + signatureString + " ] 메소드 실행 완료");		
	}
}
