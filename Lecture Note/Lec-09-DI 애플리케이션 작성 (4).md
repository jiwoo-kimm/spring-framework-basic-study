# 9강 | DI 애플리케이션 작성 (4)

## Bean 등록 메타정보 구성 전략
#### 1) Only XML
* 모든 Bean을 명시적으로 XML에 등록
* 운영 중 사용하기 좋은 전략
* Bean이 많아지면 관리가 번거로움
* 설정파일 동시 수정 시 충돌 발생
* 적절한 setter, constructor가 코드 내에 반드시 존재해야 함

#### 2) XML + Bean Scanning
* Bean 클래스에 Annotation 부여하면 자동으로 Bean Scanning
* 개발 중 사용하기 좋은 전략
* XML 문서 생성과 관리 필요 X
* Bean의 목록, 의존관계 등을 한 눈에 파악할 수 없음

## Bean Annotation
#### 1) Bean 등록
* `@Component` : 일반적인 타입으로, `<bean>` 태그와 동일
* `@Repository` : Persistence Layer, File, DB 등 영속성을 가지는 클래스
* `@Service` : Service Layer, 비즈니스 로직을 가진 클래스
* `@Controller` : Presentation Layer, 웹 요청과 응답 처리 클래스

#### 2) Bean 의존관계 주입
`<context:component-scan base-package="" />`
: 이 패키지 Annotation Scan 하는 태그

1. `@Autowired`
* Type으로 연결
* Property, Setter, Constructor, 일반 Method에 적용 가능
* `<property>`, `<constructor-arg>` 태그와 동일

2. `@Resource`
* Name으로 연결
* Property, Setter에 적용 가능

3. `@Value`
* 단순한 값 주입
* `@Value("Spring")` == `<property .. value="Spring" />`

4. `@Qualifier`
* `@Autowired`와 같이 사용
* 같은 타입의 여러 Bean 중 특정 Bean을 찾기 위해 사용
