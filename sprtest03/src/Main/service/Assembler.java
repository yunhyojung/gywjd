package Main.service;

import Main.DTO.MemberDAO;

public class Assembler { //객체 조립기에 의존객체 모두 모아 놓기 (각 서비스페이지에 있던 것들을 모아 옴)
	private MemberDAO memberDAO; 
	private MemberPrinter printer; 
	private MemberRegisterService memberRegisterService; 
	private MemberListPrinter memberListPrinter; 
	private MemberInfoPrinter memberInfoPrinter; 
	private ChangePasswordService changePasswordService; 
	
	public Assembler() {
       this.memberDAO = new MemberDAO(); //1
       this.printer = new MemberPrinter(); //2
       this.memberRegisterService = new MemberRegisterService(memberDAO);  //3
       this.memberListPrinter = new MemberListPrinter(memberDAO, printer); //4
       this.memberInfoPrinter = new MemberInfoPrinter(); //5
       this.changePasswordService = new ChangePasswordService(); //6
       
	}
	//3,4는 객체를 주입해 초기화가 되었기 때문에 반환 됨
	//5,6은 객체 주입이 안되었기 때문에 주입을  하고 난 뒤 반환
	
	//객체를 반환해야 주입할 수 있기 때문에 반환받기
	public MemberDAO getMemberDAO() {
		return memberDAO;
	}

	public MemberPrinter getPrinter() {
		return printer;
	}
	
	public MemberRegisterService getMemberRegisterService() {
		return memberRegisterService;
	}
	
	public MemberListPrinter getMemberListPrinter() {
		return memberListPrinter;
	}
	
	public MemberInfoPrinter getMemberInfoPrinter() {
		memberInfoPrinter.setMemberDAO(memberDAO); //setter 사용으로 주입값이 없어 초기화가 안됐기 때문에 초기화를 시켜줌
		memberInfoPrinter.setPrinter(printer);//주입값이 없어 초기화가 안됐기 때문에 초기화를 시켜줌
		return memberInfoPrinter;
	}
	
	public ChangePasswordService getChangePasswordService() {
		changePasswordService.setMemberDAO(memberDAO); //setter 사용으로 주입값이 없어 초기화가 안됐기 때문에 초기화를 시켜줌
		return changePasswordService;
	}
	
	

}
