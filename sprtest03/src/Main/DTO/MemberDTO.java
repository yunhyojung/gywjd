package Main.DTO;

import java.util.Date;

public class MemberDTO {
	private long id;
	private String email;
	private String password;
	private String name;
	private Date registerDate;
	public long getId() {
		return id;
	}
	public void setId(long nextId) {
		this.id = nextId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	//패스워드 변경 시 패스워드 값 확인할 메소드 추가
	public void changePassword(String oldPw, String newPw) { //현 비번과 새 비번 비교
		if(password.equals(oldPw)) {
			this.password = newPw; //this를 적어 주는 것이 좋음
		}else {
			System.out.println("현재 비밀번호가 틀립니다.");
		}
		
	}

}
