package myspring.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import myspring.di.xml.Hello;

@Controller
public class HelloController {
	
	@Autowired
	Hello helloBean;

	@RequestMapping("/hello.do")
	public String hello(Model model) {	// Spring이 알아서 Model 객체 주입
		String msg = helloBean.sayHello();
		model.addAttribute("greet", msg);	// 수행 결과 전달
		return "hello";	// 결과 띄울 페이지 리턴
						// viewResolver 설정 전에는 .jsp 다 붙여줘야 작동함
	}
}
