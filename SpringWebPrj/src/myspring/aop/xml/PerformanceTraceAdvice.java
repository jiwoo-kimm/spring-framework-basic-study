package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// Target Method
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + "����");
		
		// Target Method ȣ�� ��
		long start = System.currentTimeMillis();
		
		// Target Method ȣ��
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
		// Target Method ȣ�� ��
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + "����");
			System.out.println(signatureString + " ���� �ð� : " + (finish - start) + "ms");
		}
	}
}
