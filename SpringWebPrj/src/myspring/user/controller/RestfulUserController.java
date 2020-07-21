package myspring.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;
import myspring.user.vo.UserVOXML;

@Controller
public class RestfulUserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public Map getUserList() {
		List<UserVO> userList = userService.getUserList();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", Boolean.TRUE);
		result.put("data", userList);
		return result;
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map getUser(@PathVariable String id) {
		UserVO user = userService.getUser(id);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", Boolean.TRUE);
		result.put("data", user);
		return result;
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST, headers = { "Content-type=application/json" })	// 입력으로 json값이 들어온다는 header 설정 추가
	@ResponseBody
	public Map insertUser(@RequestBody UserVO user) {
		if (user != null) {
			userService.insertUser(user);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", Boolean.TRUE);
		return result;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	@ResponseBody
	public Map updateUser(@RequestBody UserVO user) {
		if (user != null) {
			userService.updateUser(user);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", Boolean.TRUE);
		return result;
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, headers = { "Content-type=application/json" })
	@ResponseBody
	public Map deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", Boolean.TRUE);
		return result;
	}
	
	@RequestMapping(value="/usersXml",
			method=RequestMethod.GET)
	@ResponseBody
	public UserVOXML getUserListXml() {
		List<UserVO> list = userService.getUserList();
		UserVOXML xml = new UserVOXML("success", list);
		return xml;
	}
}
