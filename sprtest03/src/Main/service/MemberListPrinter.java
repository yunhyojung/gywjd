package Main.service;

import java.util.Collection;

import Main.DTO.MemberDAO;
import Main.DTO.MemberDTO;

public class MemberListPrinter {//service 페이지이기 때문에 의존객체 dao필요
	private MemberDAO memberDAO = new MemberDAO();
	
	//info도 있기 때문에 전체 정보 외에도 개인 정보를 가져 오기 위해 함께 만듦(service)
	private MemberPrinter printer = new MemberPrinter();
	
	//위의 의존객체 두개를 주입받음
	public MemberListPrinter(MemberDAO memberDAO, MemberPrinter printer) {
		this.memberDAO = memberDAO;
		this.printer = printer;
		
	}

	public void printAll() {
        //map에서 key를 제외하면 collection의 속성을 가져 올 수 있다!
		Collection<MemberDTO> lists = memberDAO.selectAll();
		System.out.println("총 회원 수는: " + lists.size()); 
		
		//lists를 size만큼 반복문 돌리기
		for(MemberDTO dto : lists) {
			printer.print(dto);
			
		}
	}
	

}