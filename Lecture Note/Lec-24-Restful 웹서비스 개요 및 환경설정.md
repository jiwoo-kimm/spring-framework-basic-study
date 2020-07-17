# 24강 | RESTful 웹서비스 개요 및 환경설정

## RESTful 웹서비스

### Open API
프로그래밍에서 사용할 수 있는 개방되어 있는 상태의 인터페이스

### RESTful
* REpresentational Safe Transfer : HTTP URI + HTTP Method
* HTTP URI : 자원(Resource) 명시
* HTTP Method : 자원 제어 명령

|HTTP Method|CRUD|
|---|---|
|GET|Create, Insert|
|POST|Read, Select|
|PUT|Update, Create|
|DELETE|Delete|

## JSON

### JSON
* JavaScript Object Notation
* 경량 데이터 교환 방식으로 기존의 XML 대체
* 대부분 프로그래밍 언어에서 JSON 포맷 핸들링 라이브러리 제공
* `Jackson` : Java용 라이브러리

### Pair 형식

1. name-value (object, hashtable, struct)
```Javascript
{
  "firstName": "Jiwoo"
  "lastName": "Kim"
  "url": "http://github.com/jiwoo-kimm"
}
```

2. 값들의 순서화된 list (array, list)
```Javascript
{
  "firstName": "Jiwoo"
  "lastName": "Kim"
  "url": "http://github.com/jiwoo-kimm"
  "hobby": ["puzzles", "swimming"]
}
```

## XML

### XML
* eXtensible Markup Language
* 데이터 저장, 전달, 교환 언어
* HTML과 비교

||XML|HTML|
|---|---|---|
|__Focus__|Data 전달|Data 표현|
|__Tag__|사용자 정의 가능|미리 정의된 Tag만 사용 가능|

### Tree 구조
* `root`에서 시작해서 `leaves`로 뻗어 나가는 구조
* 문자 인코딩 정의하는 `prolog` 필수
* 임의의 `tag`로 데이터 정의
```XML
<? xml version="1.0" encoding="UTF-8"?>
<customer>
  <name>김지우</name>
  <addr>서울</addr>
</customer>
```
