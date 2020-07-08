# 5강 | IoC 컨테이너와 DI

## IoC
컴포넌트 의존관계 결정, 설정, 생명주기를 해결하기 위한 디자인 패턴

#### DI (Dependecny Injection)
* Bean간의 의존관계를 컨테이너가 자동으로 연결
* Spring, PicoContainer

#### DL (Dependency Lookup)
* Bean에 접근하기 위해 컨테이너가 제공하는 API를 이용하여 Bean을 검색
* Spring, EJB

## DI
빈 설정(XML, Annotation) 정보를 바탕으로 컨테이너가 자동으로 클래스 간 의존관계 연결

#### 유형
1) Setter Injection : Setter 메소드를 통해 의존성 입력
2) Constructor Injection : 클래스 생성자에 필요한 의존성 입력
3) Method Injection : 일반 메소드에서 의존성 입력

#### 클래스 호출방식
![DI_01](https://github.com/jiwoo-kimm/spring-framework-basic-study/blob/master/Images/Lec05_DI_01.png)

## Spring DI 컨테이너
