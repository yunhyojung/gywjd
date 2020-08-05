package sp04.sp04_test05.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sp04.sp04_test05.DTO.MemberDAO;
import sp04.sp04_test05.DTO.MemberDTO;
@Service
public class MemberListPrinter {//service 페이지이기 때문에 의존객체 dao필요
	private MemberDAO memberDAO = new MemberDAO();
	
	//info도 있기 때문에 전체 정보 외에도 개인 정보를 가져 오기 위해 함께 만듦(service)
	private MemberPrinter printer = new MemberPrinter();
	
	@Autowired //생성자 위에 @Autowired넣어도 됨
	public MemberListPrinter(MemberDAO memberDAO, @Qualifier("sysout") MemberPrinter printer) { //선택한 @Qualifier(value)를 사용하겠다는 뜻
		this.memberDAO = memberDAO; 
		this.printer = printer; // 싱글톤이 아니기 때문에 어떤 것을 사용해야할지 모름 -> 어떤 것을 받을지 적어줘야 함
		
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