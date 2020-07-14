package myspring.user.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.dao.UserDao;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class UserClient {
	@Autowired
	ApplicationContext context;
	@Autowired
	UserService service;

	@Test
	public void daoTest() {
		UserDao dao = context.getBean("userDao", UserDao.class);
		
//		UserVO newUser = new UserVO("dochi", "도치", "남", "제주");
//		dao.insert(newUser);
				
		List<UserVO> list = dao.readAll();
		for (UserVO userVO : list) {
			System.out.println(userVO);
		}
	}
	
	@Test
	@Ignore
	public void configTest() {
		SqlSession session = context.getBean("sqlSession", SqlSession.class);
		System.out.println(session.getClass().getName());
		
		UserVO vo = session.selectOne("userNS.selectUserById","gildong");
		System.out.println(vo);
	}
	
	@Test
	@Ignore
	public void dataSourceTest() {
		DataSource ds = (DataSource) context.getBean("dataSource");
		try {
			System.out.println(ds.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void getUserTestXML() {
		UserService service = context.getBean(UserService.class);
		UserVO user = service.getUser("gildong");
		System.out.println(user);
		assertEquals("홍길동2", user.getName());
	}
	
	@Test
	@Ignore
	public void getUserTestAnnot() {
		UserVO user = service.getUser("gildong");
		System.out.println(user);
		assertEquals("홍길동", user.getName());
	}

	@Test
	@Ignore
	public void insertUserTest() {
		service.insertUser(new UserVO("bori", "보리", "여", "서울"));

		for (UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}
	
	@Test
	@Ignore
	public void updateUserTest() {
		service.updateUser(new UserVO("gildong", "홍길동", "여", "대전"));

		UserVO user = service.getUser("gildong");
		System.out.println(user);
	}

	@Test
	@Ignore
	public void deleteUserTest() {
		service.deleteUser("dooly");

		for (UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}

}
