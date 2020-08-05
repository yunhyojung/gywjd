package sp04.sp04_test05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sp04.sp04_test05.DTO.MemberDAO;
import sp04.sp04_test05.DTO.MemberDTO;
@Service //알아서 setter생성(getter만 생성하면 됨) -> 밑에서 setter를 삭제해도 되는 이유
public class MemberInfoPrinter {
	@Autowired//필드 마다 주입 (setter를 통한 의존객체 주입)
	//컴파일된 클래스파일에는 setter가 존재함
	
    //@Autowired 대신 사용 
	//@Resource(name = "memberDAO") //의존객체가 어떤 이름을 가지고 있는지 표현
	private MemberDAO memberDAO = new MemberDAO();
	@Autowired//필드 마다 주입
	@Qualifier("sysout") //멤버 필드에 @Qualifier를 쓰는 경우
	MemberPrinter printer = new MemberPrinter();
	//setter 삭제
	


	public void printMemberInfo(String email) {
			MemberDTO dto = memberDAO.selectByEmail(email);
			if(dto == null) {
				System.out.println("데이터없음\n");
				return;
			}
			printer.print(dto);
		}
		
		
	}









