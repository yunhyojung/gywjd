package Main.service;

import Main.DTO.MemberDAO;
import Main.DTO.MemberDTO;

public class MemberInfoPrinter {
	private MemberDAO memberDAO = new MemberDAO();

	public void printMemberInfo(String email) {
		MemberPrinter printer = new MemberPrinter();
			MemberDTO dto = memberDAO.selectByEmail(email);
			if(dto == null) {
				System.out.println("데이터없음\n");
				return;
			}
			printer.print(dto);
		}
		
		
	}


