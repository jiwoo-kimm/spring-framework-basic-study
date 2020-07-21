# 28강 | RESTful 웹서비스 어플리케이션 작성 (4)

## XML 응답을 주는 RESTful 웹서비스

### JAXB
Java Architecture for XML Binding
* 직렬화(Marshalling) : Java 객체 -> XML 변환
* 역직렬화(Unmarshaliling) : Java 객체 <- XML 변환
* 주요 Annotation<br>
  - `@XMLRootElement` : XML의 Root Element 이름 정의 / 클래스에 사용<br>
  - `@XMLElement` : XML Element 이름 정의 / 변수에 사용<br>
* 구현 절차
  - `@XMLRootElement`, `@XMLElement` 선언한 `UserVOXML` 클래스 작성
  - `RestfulController` 클래스에 `@RequestMapping`, `@ResponseBody` 선언한 `getUserListXml()` 메소드 작성
  - `Postman` 툴을 통해 메소드 테스트
  - `jQuery` 기반 `Ajax` 통신하는 `userList_Xml.html` 작성
  
