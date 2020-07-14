# 16강 | MyBatis 개요

## MyBatis
자바 오브젝트 SQL문 간 자동 매핑 ORM 프레임워크

#### 특징
* 쉬운 접근성과 코드의 간결함
* SQL문과 프로그래밍 코드의 분리
* 다양한 프로그래밍 언어 지원

## MyBatis-Spring

#### 주요 컴포넌트
![Lec16_01.png](https://github.com/jiwoo-kimm/spring-framework-basic-study/blob/master/Images/Lec16_01.png)<br>

![Lec16_03.png](https://github.com/jiwoo-kimm/spring-framework-basic-study/blob/master/Images/Lec16_03.png)<br>

* `SqlMapConfig.xml` : DB 접속정보, Mapping 파일, SQL문 경로 등 고정된 환경정보 설정
* `SqlSessionFacotryBuilder` : config를 바탕으로 `SqlSessionFacotry` 생성
* `SqlSessionFacotry` : `SqlSession` 생성
* `SqlSession` : 핵심역할(SQL 실행, 트랜잭션 관리). Thread마다 필요에 따라 생성
* `mapping file(SQL문).xml` : SQL과 ORM Mapping 설정

#### 사용방법
* MyBatis 설정파일 (`sqlMapConfig.xml`) : VO 객체 정보 저장
* `SqlSessionFactoryBean` : Bean 등록 필요. `SqlSessionFactory` 생성
* `SqlSessionTemplate` : Bean 등록 필요. `SqlSession` 인터페이스 구현
* `mapping file(SQL문).xml` : SQL과 ORM Mapping 설정
