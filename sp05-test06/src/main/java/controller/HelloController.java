package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //적어줘야 컨트롤러로 인식함
public class HelloController { //doGet,doPost도 생략됨 
	
	//localhost:8080/sp04-test06/testhello 불러오기(url도 생략)
	@RequestMapping("/testHello")
	
	//Dispatcher 생략
	public String aaa(@RequestParam(value="name", defaultValue = "없어요") String name,//@RequestParam 쿼리스트링
		              @RequestParam(value="age", defaultValue = "10") int age,//쿼리는 스트링형태이나 변수타입을 설정하면 자동 형변환 해줌
		              Model model) { //setAttribute로 사용했던 것이 model
		model.addAttribute("test", name);
		
		return "hello";
		
	}

}
