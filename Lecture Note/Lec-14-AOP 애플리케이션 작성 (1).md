# 14강 | AOP 애플리케이션 작성 (1)

## Advice 종류

* Around Advice : Joinpoint 앞과 뒤에서 실행
* Before Advice : Joinpoint 앞에서 실행
* After Returning Advice : Joinpoint 메소드 호출 정상 종료 후 실행
* After Throwing Advice : exception 이후 실행

## PointCut 표현식

* 문법<br>

`execution(접근제한자 리턴타입 패키지.클래스.메소드이름(파라미터타입|"..", ...) [throws 예외이름])`

* 예시<br>

`execution(* aspects.trace.demo.*.*(..))`<br>
: 접근제한자 생략 / 패키지의 모든 클래스, 모든 메소드를 인자 상관없이 적용

`execution(* myspring.user.service..*.(..))`<br>
: 접근제한자 생략 / 패키지의 모든 서브 패키지의 모든 클래스, 모든 메소드를 인자 상관없이 적용

`execution(* *..Target.*(..))`<br>
: 접근제한자 생략 / 패키지 상관 없이 모든 Target 클래스에 적용
