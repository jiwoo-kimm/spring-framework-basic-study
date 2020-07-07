# 1강 | Framework 개념

## SW 재사용 방안들
#### 1) Copy & Paste
* 단순 소스 복붙
* 수정 시 모든 위치에 있는 소스를 수정해야 함
#### 2) Method
* Method Signature 수정
* 결합도(Coupling) 문제 존재
#### 3) Class
* 상속받은 클래스는 부모 클래스의 메소드 사용
* JDK 메소드가 변경되더라도 실제 호출 메소드 인터페이스가 변하지 않으면 영향 X
* 시그니쳐 변경 시 자식 클래스에 영향갈 수 있음
#### 4) AOP (Aspect Oriented Programming)
* OOP를 서포트해주는 개념
* 위빙(Weaving) 작업을 통해 핵심모듈 사이에 필요한 횡단관심모듈이 작동하도록 함
<br>

## 디자인 패턴과 프레임워크의 관련성
#### 1) 디자인패턴
* 재사용하기 좋은 형태로 특정 규약을 묶어 정리한 것
* 요구사항 변경에 대한 소스 변경을 최소화
* 범용적, 직관적 코딩 스타일 

#### 2) 프레임워크
* 비기능적 요구사항을 만족하는 구조와 기능을 안정적으로 실행하도록 제어해주는 라이브러리의 모음
* 어플리케이션의 공통적 하부 구조를 제공
* 비기능적 요소들을 초기 개발 단계마다 구현해야 하는 비효율성을 최소화
* 발견되는 문제를 해결하기 위한 특화된 솔루션 제공

#### 3) 관련성
* 프레임워크는 디자인 패턴을 핵심적인 특징 삼아 내부적으로 구현
* 프레임워크 기반 코드를 확장하여 사용함으로서 그 프레임워크에서 사용된 패턴을 적용할 수 있음
<br>

## 프레임워크의 구성요소와 종류
#### 1) IoC (Inversion of Control)
* 인스턴스 생명주기 관리를 개발자가 아닌 컨테이너가 대신 해주는 것
* Spring : The Spring Container에서 Beans 관리
cf.> `프레임워크 --호출--> 유저코드`, `유저코드 --호출--> 라이브러리`

#### 2) Class Library
* 특정 부분의 기술적 구현을 라이브러리 형태로 제공

#### 3) Design Pattern
* 디자인패턴 + 라이브러리 = 프레임워크

#### 4) 종류

|기능|종류|
|---|---|
|**웹(MVC)**|**Spring MVC**, Struts2, Webwork, PlayFramework|
|**OR(Object-Relational) 매핑**|**MyBatis**, Hibernate, JPA, Spring JDBC|
|**AOP**|**Spring AOP**, AspectJ, JBoss AOP|
|**DI**|**Spring DI**, Google Guice|
|**Build, Library 관리**|**Maven**, Gradle, Ant + Ivy|
|**단위 테스트**|**jUnit**, TestNG, Cactus|
|**Javascript**|**jQuery**, AngularJS, Node.js|
