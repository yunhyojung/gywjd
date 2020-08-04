package Main.service;

import Main.DTO.MemberDAO;
import Main.DTO.MemberDTO;

public class MemberInfoPrinter {
	private MemberDAO memberDAO = new MemberDAO();
	MemberPrinter printer = new MemberPrinter();
	
	//생성자 대신 setter사용
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
		
	}
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
		
	}

	public void printMemberInfo(String email) {
			MemberDTO dto = memberDAO.selectByEmail(email);
			if(dto == null) {
				System.out.println("데이터없음\n");
				return;
			}
			printer.print(dto);
		}
		
		
	}


