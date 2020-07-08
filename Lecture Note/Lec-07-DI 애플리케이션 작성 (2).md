# 7강 | DI 애플리케이션 작성 (2)

## jUnit

#### 특징
* TDD
* Assert 메소드로 테스트 케이스의 수행 결과 판별
ex) assertEquals(예상값, 실제값)
* Annotation으로 간단한 테스트 코드 작성 지원

#### Annotation
1) `@Test` : 테스트 수행 / 각각 메소드는 독립적인 객체로 시행
2) `@Ignore` : 테스트 실행하지 않음
3) `@Before` : `@Test` 전에 반드시 실행
4) `@After` : `@Test` 후에 실행
5) `@BeforeClass` : `@Test`보다 먼저 한 번만 수행
6) `@AfterClass` : `@Test`보다 나중에 한 번만 수행

#### Assert 메소드
`org.junit.Assert` : 테스트 결과 확인을 위한 클래스
1) `assertEquals(a,b)` : 두 객체의 값 비교
2) `assertArrayEquals(a,b)` : 두 배열 객체의 값 비교
3) `assertSame(a,b)` : 두 객체의 레퍼런스 비교
4) `assertTrue(a)` : 조건 A가 참인가
5) `assertNotNull(a)` : 조건 A가 null이 아닌가
