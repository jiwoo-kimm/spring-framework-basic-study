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
//		modelAndView.addObject("userList", userList);	// "이름"을 꼭 정해 줘야만 jsp에서 객체를 찾을 수 있음
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
		// 원래 DB에서 값 끌어오는데 일단 임시로 값 넣어서 넘겨줌
		List<String> genderList = new ArrayList<String>();
		genderList.add("여");
		genderList.add("남");
		
		List<String> cityList = new ArrayList<String>();
		cityList.add("서울");
		cityList.add("부산");
		cityList.add("제주");
		cityList.add("전주");
		
		Map<String, List<String>> map = new HashMap<>();
		map.put("genderList", genderList);
		map.put("cityList", cityList);
		
		return new ModelAndView("userInsert", "map", map);
	}
	
	@RequestMapping("/insertUser.do")
	public String insertUser(@ModelAttribute UserVO user) {	// @ModelAttribute : 요청에 포함된 인자를 모델 객체로 바인딩
		if (user != null)
			userService.insertUser(user);
		return "redirect:/getUserList.do";	// 추가된 목록 재조회
	}
	
	@RequestMapping("/updateUserForm.do")
	public ModelAndView updateUserForm(@RequestParam String id) {
		
		UserVO user = userService.getUser(id);
		
		List<String> genderList = new ArrayList<String>();
		genderList.add("여");
		genderList.add("남");
		
		List<String> cityList = new ArrayList<String>();
		cityList.add("서울");
		cityList.add("부산");
		cityList.add("제주");
		cityList.add("전주");
		
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
		return "redirect:/getUserList.do";	// 변경된 목록 재조회
	}
	
	@RequestMapping("/deleteUser.do/{id}")
	public String deleteUser(@PathVariable String id) {	// @PathVariable : 인자를 URL 형식으로 받을 수 있음
		userService.deleteUser(id);
		return "redirect:/getUserList.do";	// 변경된 목록 재조회
	}
	
	@ExceptionHandler
	public String handleException(Exception e) {
		return "viewError";
	}
}
