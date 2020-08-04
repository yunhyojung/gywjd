package Main.DTO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CachedMemberDAO {
	private static long nextId = 0;
	private static Map<String, MemberDTO> map = new HashMap<String, MemberDTO>(); //HashMap은 Map을 상속받기 때문에 부모클래스를 통해 객체 생성 가능
	public void insert(MemberDTO dto) {
		dto.setId(++nextId);
		map.put(dto.getEmail(), dto);
	}
	public MemberDTO selectByEmail(String email) {
		
		return map.get(email); 
	}
	public Collection<MemberDTO> selectAll() {
		
		return map.values(); 
	}
	public MemberDTO update(MemberDTO dto) {
        return map.put(dto.getPassword(), dto); 
	}

}
