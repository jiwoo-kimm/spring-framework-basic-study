# 21강 | Spring MVC 웹애플리케이션 작성 (1)

## EL & JSTL
JSP에서 스크립팅 태그 없이 간단히 작성

### EL (Expression Language)
* `{}`, `$`, 도트연산자
* 4가지 Scope(page, request, session, application) 객체 접근하여 출력 처리
* null 객체일 경우 아무 내용도 표시하지 않을 뿐 exception 발생하지 않음
* 비교 예시<br>
`<%=request.getParameter("name")%>` -> `${param.name}`<br>
`<% String value = (String)request.getAttribute("greet"); out.println(value); %>` -> `${greet}`<br>
`<% UserVO user = (UserVO)request.getAttribute("user"); out.println(user); %>` -> `${user}`<br>
`<% UserVO user = (UserVO)request.getAttribute("user"); out.println(user.getName()); %>` -> `${user.name}`<br>
`<% UserVO user = (UserVO)session.getAttribute("user"); out.println(user.getName()); %>` -> `${sessionScope.user.name}`<br>


### JSTL (Java Standard Tag Library)
* 반복, 조건, 데이터관리, XML조작, DBA 등을 구현해 놓은 Custom Tag Library 모음
* EL를 사용하여 표현
* JSP 내장 객체(Implicit Object)에 쉽게 접근 가능

|라이브러리|기능|URL식별자|접두어|
|---|---|---|---|
|__Core__|변수선언, 조건/제어/반복문 등 일반 프로그래밍 언어에서 제공하는 기능|http://java.sun.com/jsp/jstl/core|C|
|__Formatting__|숫자, 날짜, 시간 포맷팅 & 다국어 지원 기능|http://java.sun.com/jsp/jstl/fmt|fmt|
|__Function__|문자열 처리 함수|http://java.sun.com/jsp/jstl/functions|fn|
|__Database__|데이터 입력/수정/삭제/조회|http://java.sun.com/jsp/jstl/sql|sql|
|__xml__|xml 문서 처리|http://java.sun.com/jsp/jstl/xml|x|
