package sp04.sp04_test05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sp04.sp04_test05.DTO.MemberDAO;
import sp04.sp04_test05.DTO.MemberDTO;
@Service //추가(서비스 클래스 파일)
public class ChangePasswordService {
	@Autowired //추가(의존객체 자동주입 받겠다는 뜻)
	
	private MemberDAO memberDAO; //위의 추가로 인해 멤버필드만 있으면 됨(생성자 불필요)
	

	public void changePassword(String email, String oldPw, String newPw) {
		MemberDTO dto = memberDAO.selectByEmail(email);
		if(dto == null) {
			System.out.println("이메일이 존재하지 않습니다.");
			return;
			
		}
		dto.changePassword(oldPw, newPw); //MemberDTO에서의 비번 비교 메소드
		memberDAO.update(dto);
		
	}

}
