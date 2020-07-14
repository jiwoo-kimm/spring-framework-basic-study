# 18강 | MyBatis 애플리케이션 작성 (2)

## Mapper

#### Mapper 인터페이스 사용하지 않았을 때<br>
: `SqlSession`에 문자열로 `네임스페이스+"."+SQL ID` 지정

```xml
<mapper namespace="userNS">
  <select id="selectUserById" parameterType="String">
```

```java
session.selectOne("userNS.selectUserById", userid);
```


#### Mapper 인터페이스 사용했을 때<br>
: 개발자가 작성한 `userMapper.메소드(인자)` 호출

```xml
<mapper namespace="myspring.user.dao.UserMapper">
  <select id="selectUserById" parameterType="String">
```

```java
session.selectOne(userMapper.selectUserById(userid));
```


## 다중 Mapper 설정

#### `MapperScannerConfigurer`
* 여러 개의 Mapper 인터페이스를 정의하는 것은 비효율적
* Mapper 인터페이스의 객체를 하나의 패키지에 모아 `MapperScannerConfigurer`에 등록
* Mapper가 아닌 인터페이스도 등록되지 않도록 `Marker` 인터페이스 & Annotation 사용
