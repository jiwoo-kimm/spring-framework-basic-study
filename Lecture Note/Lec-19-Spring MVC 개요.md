# 19강 | Spring MVC 개요

## MVC 패턴
Business logic과 Presentation logic을 분리하기 위한 아키텍쳐 패턴

### Model
: 어플리케이션의 정보 (데이터, Business logic)
* DB와 연동하여 데이터 관리, 트랜잭션 처리
* DAO, Service 클래스

### View
: 사용자에게 제공할 화면 (Presentation logic)
* Model이 처리한 데이터와 작업 결과를 바탕으로 사용자에게 출력할 화면 생성
* HTML, CSS, Java Script 등으로 웹 UI 작성

### Controller
: Model과 View 사이의 상호 작용 관리
* 클라이언트의 요청 처리를 위해 Model 호출
* 전달을 위한 데이터 가공
* 결과를 View에게 전달
* Servelet, JSP 등으로 작성

### 모델2 아키텍쳐
* 모델1 아키텍쳐 : JSP Controller. 코드가 복잡해진다는 단점
* 모델2 아키텍쳐 : Servelet Controller. 최근 많이 사용

![Lec19_01.png](https://github.com/jiwoo-kimm/spring-framework-basic-study/blob/master/Images/Lec19_01.png)
1. 웹 브라우저가 보낸 요청을 웹 서버가 받고 `Servelet Container`(ex. Tomcat Server)에 넘겨준다. `Servelet Container`는 URL을 확인하여 그 요청을 처리할 `Servelet`을 찾아 실행한다.
2. `Servelet`은 실제 업무를 처리할 `Model` 자바 객체(`EJB` or `POJO`)의 메소드를 호출한다. 데이터 처리가 필요하다면 데이터를 가공하여 `VO 객체`를 생성하고 메소드 파라미터로 넘긴다.
3. `Model` 객체는 파라미터 `VO 객체`를 DB에 저장하거나, 질의 결과를 불러와서 `VO 객체` 형태로 변환한다.
4. `Servelet`은 반환 받은 값을 `JSP`에 전달한다.
5. `JSP`는 `Servelet`으로부터 전달받은 값 객체를 참조하여 출력용 결과 화면을 만들어 `Servelet`에 반환한다.
6. 웹 브라우저는 서버(`Servelet`)로부터 받은 응답 내용을 화면에 출력한다.

### Front Controller 패턴 아키텍쳐
* 클라이언트가 보낸 요청을 받아 중앙 집중적으로 관리하여 공통적인 작업을 먼저 수행
* 세부 Controller에게 적절한 작업 위임

## Spring MVC 개념

### 특징
* `Servelet` 기반의 웹 개발을 위한 MVC 프레임워크 제공
* 모델2 아키텍쳐와 Front Controller 패턴을 프레임워크 차원에서 제공
* Spring 기반의 트랜잭션 처리나 DI, AOP 등을 쉽게 사용

### 주요 구성 요소

#### `DispatcherServelet`
* 맨 앞단에서 클라이언트의 모든 요청을 처리하는 Front Controller 역할 수행
* Exception 역시 일괄 방식으로 처리
* `web.xml`에 개발자가 직접 설정

#### `HandlerMapping`
* URL과 요청 정보를 기준으로 어떤 Handler 객체를 매핑할지 결정
* `DispatcherServelet`은 하나 이상의 `HandlerMapping`을 가질 수 있음

#### `Controller`
* 요청을 처리한 뒤, `Model`을 호출하고, 그 결과를 `DispatcherServelet`에게 전달
* 개발자가 직접 작성

#### `ModelAndView`
* `Controller`가 처리한 데이터 및 화면에 대한 정보를 보유한 객체
* 개발자가 직접 작성

#### `View`
* `Controller` 처리 결과 화면에 대한 정보를 보유한 객체
* 개발자가 직접 작성

#### `ViewResolver`
* `Controller`가 리턴한 `View` 이름을 기반으로 `Controller` 처리 결과를 생성할 `View` 결정

### 요청 처리 과정
![Lec19_02.png](https://github.com/jiwoo-kimm/spring-framework-basic-study/blob/master/Images/Lec19_02.png)

1. Request를 `DispatcherServelet`에 전달
2. `HandlerMapping`을 사용하여 Request를 처리할 `Controller` 획득
3. `Controller` 객체를 이용하여 Request 처리
4. Request 처리 결과와 `View` 페이지 정보를 담은 `ModelAndView` 객체 반환
5. `ViewResolver`로부터 응답 결과를 생성할 `View` 객체 획득
6. 클라이언트에게 전달할 응답 생성


## Spring MVC 기반 웹 어플리케이션 개발

1. `DispatcherServelet`을 `web.xml`에 설정
2. `Controller` 작성
    * `@Controller`, `@RequestMapping("URL")`
3. `Controller`를 Bean으로 등록
4. `JSP`를 이용한 `View` 코드 작성
5. 웹 브라우저 상에서 `JSP` 실행

