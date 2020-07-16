package myspring.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUserList.do")
	public ModelAndView getUserList() {
		List<UserVO> userList = userService.getUserList();
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("userList", userList);	// "�̸�"�� �� ���� ��߸� jsp���� ��ü�� ã�� �� ����
//		modelAndView.setViewName("userList");
		return new ModelAndView("userList", "userList", userList);	// (viewName, modelName, modelObject)
	}
	
	@RequestMapping("/getUser.do")
	public ModelAndView getUser(@RequestParam String id) {
		UserVO user = userService.getUser(id);
		return new ModelAndView("userInfo", "user", user);
	}
	
	@RequestMapping("/insertUserForm.do")
	public ModelAndView insertUserForm() {
		// ���� DB���� �� ������µ� �ϴ� �ӽ÷� �� �־ �Ѱ���
		List<String> genderList = new ArrayList<String>();
		genderList.add("��");
		genderList.add("��");
		
		List<String> cityList = new ArrayList<String>();
		cityList.add("����");
		cityList.add("�λ�");
		cityList.add("����");
		cityList.add("����");
		
		Map<String, List<String>> map = new HashMap<>();
		map.put("genderList", genderList);
		map.put("cityList", cityList);
		
		return new ModelAndView("userInsert", "map", map);
	}
	
	@RequestMapping("/insertUser.do")
	public String insertUser(@ModelAttribute UserVO user) {	// @ModelAttribute : ��û�� ���Ե� ���ڸ� �� ��ü�� ���ε�
		if (user != null)
			userService.insertUser(user);
		return "redirect:/getUserList.do";	// �߰��� ��� ����ȸ
	}
	
	@RequestMapping("/updateUserForm.do")
	public ModelAndView updateUserForm(@RequestParam String id) {
		
		UserVO user = userService.getUser(id);
		
		List<String> genderList = new ArrayList<String>();
		genderList.add("��");
		genderList.add("��");
		
		List<String> cityList = new ArrayList<String>();
		cityList.add("����");
		cityList.add("�λ�");
		cityList.add("����");
		cityList.add("����");
		
		Map<String, Object> map = new HashMap<>();
		map.put("genderList", genderList);
		map.put("cityList", cityList);
		map.put("user", user);
		
		return new ModelAndView("userUpdate", "map", map);
	}
	
	@RequestMapping("/updateUser.do")
	public String updateUser(@ModelAttribute UserVO user) {
		if (user != null)
			userService.updateUser(user);
		return "redirect:/getUserList.do";	// ����� ��� ����ȸ
	}
	
	@RequestMapping("/deleteUser.do/{id}")
	public String deleteUser(@PathVariable String id) {	// @PathVariable : ���ڸ� URL �������� ���� �� ����
		userService.deleteUser(id);
		return "redirect:/getUserList.do";	// ����� ��� ����ȸ
	}
	
	@ExceptionHandler
	public String handleException(Exception e) {
		return "viewError";
	}
}
