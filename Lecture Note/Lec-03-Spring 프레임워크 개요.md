# 3강 | Spring 프레임워크 개요

## Spring Framework 개요

#### 1) Spring Framework
* JAVA 엔터프라이즈 개발을 위한 오픈소스 경량급 애플리케이션 프레임워크
* 장비 없이도 단순 웹컨테이너에서도 고급 기술을 사용할 수 있음
* Low level(보안, 인증, 트랜잭션 등) 보다는 비즈니스 로직 개발에 전념할 수 있음

#### 2) 전략
* `PSA` + `DI` + `AOP` + `POJO`
* 엔터프라이즈 개발의 복잡함을 해소

|전략|의미|설명|
|---|---|---|
|PSA(Portable Service Abstraction)|서비스 추상화|기술적으로 복잡한 Low level 구현과 사용을 인터페이스로 분리하여 제공|
|DI(Dependency Injection)|의존관계주입|객체, 클래스 간의 관계를 외부에서 컨테이너가 동적으로 설정|
|AOP(Aspect Oriented Programming)|관점지향 프로그래밍|기술 관련 코드를 분리해서 별도의 모듈로 관리|
|POJO(Plain Old Java Object)|일반적인 자바 오브젝트|특정 환경, 규약에 종속되지 않고 JVM만 있으면 작동하는 자바 객체|

#### 3) 특징
* 컨테이너 역할
* `DI` : xml, @Annotation
* `AOP` : Low level 모듈을 핵심 모듈과 분리
* `POJO` : 인터페이스를 구현하거나 클래스를 상속받지 않아도 됨
* 트랜잭선 처리를 위한 일관된 방법을 지원 : xml, @Annotation 설정만으로 관리
* 영속성과 관련된 다양한 API 지원 : ORM 프레임워크와 연계 유용

#### 4) 기능 요소
1. `Spring Core` : 기본 컨테이너 기능, BeanFacotry
2. `Spring AOP` : Aspect 개발의 기반
3. `Spring ORM` : ORM 프레임워크와의 연결고리
4. `Spring DAO` : 예외처리, IDBC, 트랜잭션 관리
5. `Spring Web` : 브라우저 기반 웹 어플리케이션 개발에 필요한 기능
6. `Spring Context` : BeanFactory 개념과 기능 확장
7. `Spring Web MVC` : 어플리케이션 로직과 웹 로직 분리
