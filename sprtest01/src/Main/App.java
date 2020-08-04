package Main;

import java.util.Scanner;

import Main.DTO.RegisterRequest;
import Main.service.MemberListPrinter;
import Main.service.MemberRegisterService;

public class App { //자바로 회원관리하는 방법 알아보기(실제로 사용하지는 않음)-dependencies
	
     public static void main(String[] args) { //main메소드 : ***컨트롤러 부분이라 생각하면 됨***
    	 //jsp에서 컨트롤러에 있던 부분들이 의존객체가 된다 생각하면 됨
			
    	Scanner sc = new Scanner(System.in); //밑에 넘어갈 값 스캐너로 받기
    	
    	while(true) { //while이 없으면 하나만 실행
		System.out.println("명령어를 입력하세요: ");
		String command = sc.nextLine();
		if(command.startsWith("new")) { //포함되는 글자로 찾기(startsWith로 스플릿을 하지 않아도 됨)
			String [] arg = command.split(" "); //**
			
			//App a = new App(); *
			//if(arg.length != 5) a.printHelp();
			
			if(arg.length != 5) { //밑의 이메일, 이름...값이 5개인데 이를 충족시키지 않으면 다시 작성하도록 printHelp 호출
				printHelp();
				System.out.println();
				continue;//틀리면 다시 명령어 입력으로 돌아가기
			}
			  
			//의존객체(클래스 안에 있는 객체:App 안에 있는 RegisterRequest) - dependency object
			RegisterRequest req = new RegisterRequest(); //현재 객체에 받아 온 값 저장하기 위해 스플릿(**)->배열로 처리 됨
			req.setEmail(arg[1]);
			req.setName(arg[2]);
			req.setPassword(arg[3]);
			req.setConfirmPassword(arg[4]);
			Boolean bl = req.isPasswordEqualConfirmPassword();
			if(!bl) {//false일 경우 실행이 안되기 때문에 true로 바꿔 줌(if문은 참이라는 가정에만 실행됨)
				System.out.println("비밀번호가 일치하지 않습니다.");
				continue;
			}
			
			MemberRegisterService mrs = new MemberRegisterService(); //의존객체(dependency object)
			mrs.regist(req);
			
		}else if(command.startsWith("change")) { 
		
		}else if(command.equals("list")) { 
			MemberListPrinter listPrint = new MemberListPrinter(); //의존객체 만듦
			listPrint.printAll();
		
		}else if(command.startsWith("info")) { 
		
		}else if(command.equals("exit")) { 
            System.exit(0);
		
		}
    	}
    }
     
//     public void printHelp() { static이 없을 경우 *에 객체 생성을 따로 시켜야 함
     public static void printHelp() {
		System.out.println();
		System.out.println("명령어 사용법: ");
		System.out.println("new 이메일 이름 암호 암호확인"); //url이라 생각(앞의 키워드들을 이용해 값 가져오기/쿼리스트링)
		System.out.println("change 이메일 현재비번 변경 비번");
		System.out.println("list");
		System.out.println("info 이메일");
		System.out.println("프로그램 종료는 exit");
    	 
    	 
    }
     
}
