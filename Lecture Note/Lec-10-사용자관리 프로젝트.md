# 10강 | 사용자관리 프로젝트

## 사용자 관리 프로젝트 아키텍쳐
### 계층화(Layering) + Domain Model Class
`Presentation Layer` <--`Interface`--> `Service Layer` <--`Interface`--> `Data Access Layer`<br>

#### 1) Presentation Layer (`@Controller`)
* 웹 브라우저 클라이언트의 요청 및 응답 처리
* 상위계층에서 발생하는 Exception 처리
* 최종 UI 표현을 위한 도메인 모델 사용
* 최종 UI로부터의 입력 데이터 유효성 검증
* 비즈니스 로직과 최종 UI를 분리하는 컨트롤러

#### 2) Service Layer (`@Service`)
* 비즈니스 로직 처리
* 트랜잭션 처리
* 두 계층 사이의 인터페이스 제공을 통한 어플리케이션 유연성 증가

#### 3) Data Access Layer (`@Repository`)
* 데이터 액세스 로직 객체화
* 데이터 조회, 등록, 수정, 삭제
* ORB 프레임워크를 주로 사용

#### 4) Domain Model Class
* 데이터베이스 엔티티와 비슷한 개념
* VO(Value Object), DTO(Data Transfer Object)
* 구성 : private 멤버변수 + getter & setter


## 사용자 관리 프로젝트 클래스 설계
![클래스설계](https://github.com/jiwoo-kimm/spring-framework-basic-study/blob/master/Images/Lec10_01.png)

#### 1) Presentation Layer
- `UserController` 클래스
  * JSP가 `UserController`를 통해 서비스 계층의 `UserService` 사용
  * 서비스 계층의 `UserService` 인터페이스를 구현한 객체를 `@Autowired`로 주입

#### 2) Service Layer
- `UserService` 인터페이스
  * 서비스 계층에 속한 상위 인터페이스

- `UserServiceImpl` 클래스
 * `UserService` 구현 클래스
 * 복잡한 업무 로직 구현
 * 데이터 액세스 계층의 `UserDao` 인터페이스를 구현한 객체를 `@Autowired`로 주입

#### 3) Data Access Layer
- `UserDao` 인터페이스
  * 데이터 액세스 계층에 속한 상위 인터페이스
  
- `UserDaoImplJDBC` 클래스
  * 데이터 액세스 로직 구현
  * SpringJDBC : DataSource 주입
  * MyBatis : SqlSession 주입
