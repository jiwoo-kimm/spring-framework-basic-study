package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// Target Method
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + "시작");
		
		// Target Method 호출 전
		long start = System.currentTimeMillis();
		
		// Target Method 호출
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
		// Target Method 호출 후
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + "종료");
			System.out.println(signatureString + " 실행 시간 : " + (finish - start) + "ms");
		}
	}
}
