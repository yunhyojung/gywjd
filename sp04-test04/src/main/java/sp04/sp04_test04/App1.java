package sp04.sp04_test04;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import Main.DTO.MemberDAO;
import Main.DTO.RegisterRequest;
import Main.service.ChangePasswordService;
import Main.service.MemberInfoPrinter;
import Main.service.MemberListPrinter;
import Main.service.MemberPrinter;
import Main.service.MemberRegisterService;

public class App1 { //자바로 회원관리하는 방법 알아보기(실제로 사용하지는 않음)-dependencies
	private static GenericXmlApplicationContext ctx;
	
	
     public static void main(String[] args) { //main메소드 : ***컨트롤러 부분이라 생각하면 됨***
    	 ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");//assembler대신 사용
    	 //classpath: src밑에 있는 resources임(아예 정의가 되어 있는 내용)
    	 
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
			//----------위는 dto이기 때문에 고치지 않음
			req.setEmail(arg[1]);
			req.setName(arg[2]);
			req.setPassword(arg[3]);
			req.setConfirmPassword(arg[4]);
			Boolean bl = req.isPasswordEqualConfirmPassword();
			if(!bl) {//false일 경우 실행이 안되기 때문에 true로 바꿔 줌(if문은 참이라는 가정에만 실행됨)
				System.out.println("비밀번호가 일치하지 않습니다.");
				continue;
			}
			
//			MemberRegisterService mrs = new MemberRegisterService(memberDAO); //의존객체(dependency object)
			MemberRegisterService mrs = ctx.getBean("memberRegisterService", MemberRegisterService.class); //appCtx에 있는 id값
			mrs.regist(req);
			
		}else if(command.startsWith("change")) { 
			   String [] arg = command.split(" ");
			   if(arg.length != 4) {
				   printHelp();
				   continue;
			   }
			   ChangePasswordService changePwSvc = ctx.getBean("changePasswordService", ChangePasswordService.class);
			   
			   changePwSvc.changePassword(arg[1],arg[2],arg[3]);
			
		}else if(command.equals("list")) { 
			MemberListPrinter listPrint = ctx.getBean("memberListPrinter", MemberListPrinter.class);
			listPrint.printAll();
		
		}else if(command.startsWith("info")) { 
		   String [] arg = command.split(" ");
		   if(arg.length != 2) {
			   printHelp();
			   continue;
		   }
			MemberInfoPrinter infoPrinter = ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);
			infoPrinter.printMemberInfo(arg[1]);
			
		}else if(command.equals("exit")) { 
			System.out.println("프로그램이 종료되었습니다.");
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
