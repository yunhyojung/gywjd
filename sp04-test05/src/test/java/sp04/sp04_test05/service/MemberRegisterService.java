package sp04.sp04_test05.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sp04.sp04_test05.DTO.MemberDAO;
import sp04.sp04_test05.DTO.MemberDTO;
import sp04.sp04_test05.DTO.RegisterRequest;
@Service
public class MemberRegisterService { // DAO가 서비스임
	@Autowired
	private MemberDAO memberDAO; 
	

//	public void setMemberDAO() {
//		memberDAO = new MemberDAO();
//	}
	
	
	//DAO를 처리하기 위한 메소드 
	public void regist(RegisterRequest req) {//view로부터 날아온 RegisterRequest값 받기
//		MemberDTO dto = new MemberDTO();//받아 온 값 DTO에 저장(하는 방식은 jsp때와 비슷하나 view만 달라짐)->db에 접근하기 위함(RegisterRequest은 DTOx)
		//위 대신  MemberDAO 받아 옴(DTO를 의존객체로 만들지 않기 위해 : dependency사용하지 않기 위해)
		MemberDTO dto = memberDAO.selectByEmail(req.getEmail()); //selectByEmail메소드를 활용해 값을 가져 옴
		if(dto == null) {
			dto = new MemberDTO(); //dto가 null일 경우 다시 받아 옴
			//무조건 필요할 때만 의존객체 , 필요하거나 안필요하면 의존객체 아님 => 위의 경우는 null일 한정된 경우에만 사용되기 때문에 의존객체가 아님
			
			dto.setEmail(req.getEmail());
			dto.setName(req.getName());
			dto.setPassword(req.getPassword());
			dto.setRegisterDate(new Date());
			
			memberDAO.insert(dto); //dao에  dto저장
			System.out.println("사용자 등록이 완료되었습니다.");
		}else {
			System.out.println("중복 사용자입니다.");
		}
	}


}
