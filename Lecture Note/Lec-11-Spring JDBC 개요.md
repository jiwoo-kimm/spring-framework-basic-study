# 11강 | Spring JDBC 개요

## 데이터 액세스

#### 1) DAO 패턴
* 비즈니스 로직과 데이터 액세스 로직을 분리
* 서비스 계층에 영향을 주지 않고 데이터 액세스 기술 변경 가능

#### 2) Connection Pooling DataSource
* 미리 DB 컨넥션을 Pool에 준비해두고, 요청할 때마다 하나씩 할당 후 반환하는 기법
* Spring : DataSource를 Bean으로 등록

#### 3) Spring DataSource 구현 클래스
1. 테스트 환경
* `SimpleDriverDataSource`
  - 가장 단순한 테스트용
  - `getConnection()`마다 DB 컨넥션 새로 생성 (Pooling X)
* `SingleConnectionDriverDataSource`
  - 순차적으로 진행되는 통합 테스트용
  - 매번 DB 컨넥션 새로 생성하지 않아 좀 더 빠름
 
2. 오픈소스
* `Apache Commons DBCP`
  - 가장 유명한 오픈소스 DB 컨넥션 풀 라이브러리
* `c3p0 JDBC/DataSource Resource Pool`
  - JDBC 3.0
  - Connection & Statement 풀 라이브러리
* 모두 Setter 메소드를 통해 Spring Bean 등록 가능

## Spring JDBC

#### 1) JDBC (Java Database Connectivity)
* 자바 상의 데이터 액세스 기술의 근간
* 별도의 학습 없이 개발 가능
* 중복된 코드 반복 사용 및 자원 관리 버그 등의 문제

#### 2) Spring JDBC
* 기존 JDBC + 단점 극복 + 간결한 형태의 API 사용법 + 편리한 기능
* DB 컨넥션을 가져오는 DataSource를 Bean으로 등록해서 사용
* 주요 기능
  - Connection 열기 & 닫기
  - Statement 준비 & 닫기
  - Statement 실행
  - ResultSet Loop 처리
  - Exception 처리 & 반환
  - Transaction 처리

## JdbcTemplate
Spring JDBC 클래스 중 모든 기능을 최대한 활용할 수 있는 유연한 클래스

#### 1) 주요 기능
* `실행` : DB 데이터 변경이 일어나는 쿼리 수행
* `조회` : Select 데이터 조회
* `배치` : 여러 개의 쿼리를 한 번에 수행

#### 2) 객체 생성
```java
public class ExampleDAOJdbc{
  JdbcTemplate jdbcTemplate;

  @Autowired
  public void setDataSource(DataSource dataSource){
    jdbcTemplate = new JdbcTemplate(dataSource);
  }
}
```

#### 3) 주요 메소드

1. `update()`

```java
int update(String sql, [SQL parameter])
```

2. `queryForObject()`

```java
<T> T queryForObject(String sql, [SQL parameter], RowMaper<T> rm)
```
- 단일 Row 리턴
- T : VO 객체 타입
- RowMapper<T> rm : 실행 결과를 VO 객체로 매핑
    
3. `query()`

```java
<T> List<T> query(String sql, [SQL parameter], RowMapper<T> rm)
```

- 여러 Row 리턴
- VO 객체를 포함하고 있는 List 형태 리턴
