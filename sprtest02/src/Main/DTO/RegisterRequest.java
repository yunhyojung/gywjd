package Main.DTO;

public class RegisterRequest { //저장할 값(이름,암호 등..) 받기 위해 클래스 생성
	private String email;
	private String name;
	private String password;
	private String confirmPassword;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

//	private Boolean confirmPassword;
	
//	public Boolean getConfirmPassword() { Boolean의 getter는 반환이 is로 됨
//		return confirmPassword;
//	}
//	public void setConfirmPassword(Boolean confirmPassword) {
//		this.confirmPassword = confirmPassword;
//	}
//	public boolean isIs() {
//		return is;
//	}
//	public void setIs(boolean is) {
//		this.is = is;
//	}


	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public boolean isPasswordEqualConfirmPassword() { //정보가 맞는지 틀린지 확인하기 위한 메소드(boolean형은 is로 반환)
		return password.equals(confirmPassword); //현재 비번과 확인 비번 비교를 통해 t/f 반환
	}
	

}
