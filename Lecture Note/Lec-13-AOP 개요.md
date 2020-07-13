# 13강 | AOP 개요

## AOP
* 핵심기능과 부가기능 분리
* Aspect라는 독특한 모듈 형태로 설계

#### Aspect
`Advice` + `Pointcut`

#### 용어
* `Target` : 핵심기능 모듈으로, 부가기능 부여 대상
* `Advice` : 부가기능 모듈
* `Join Point` : `Target` 객체가 구현한 모든 메소드
* `Pointcut` : `Target`의 메소드를 선별하는 정규표현식
* `Aspect` : AOP 기본 모듈
* `Advisor` : `Advice` + `Pointcut` only for Spring AOP
* `Weaving` : `Join Point`에 `Advice`를 삽입하는 과정

## Spring AOP

#### 특징
* Proxy 기반 AOP 지원한다
* Proxy가 호출을 가로챈다
    - 전처리 어드바이스 : 부가기능 수행 후 핵심기능 호출
    - 후처리 어드바이스 : 핵심기능 호출 후 부가기능 수행
* 동적 Proxy 기반이라 메소드 Join Point만 지원한다

#### 구현방식
* XML 기반의 POJO 클래스를 이용한 구현
    - `Advice` 클래스 작성
    - XML 설정파일에 `<aop:config>`으로 `Aspect` 설정
    - `Advice`, `Pointcut` 설정 : XML 설정파일
* `@Aspect` annotation을 이용한 구현
    - `Asepct` 클래스 작성 후 `@Aspect` annotation
    - `Advice` 구현 메소드, `Pointcut` 클래스 내 포함
    - XML 설정파일에 `<aop:aspectj-autoproxy />` 설정
