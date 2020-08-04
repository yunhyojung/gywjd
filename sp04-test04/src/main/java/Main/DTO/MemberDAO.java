package Main.DTO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDAO {
	private static long nextId = 0;
	private static Map<String, MemberDTO> map = new HashMap<String, MemberDTO>(); //HashMap은 Map을 상속받기 때문에 부모클래스를 통해 객체 생성 가능
	public void insert(MemberDTO dto) {
		dto.setId(++nextId);
		map.put(dto.getEmail(), dto);
	}
	public MemberDTO selectByEmail(String email) {
		
		return map.get(email); //MemberDTO는 map으로 부터 반환 받아옴(key가 email이기 때문에 ()에 넣어줌)
	}
	public Collection<MemberDTO> selectAll() {
		
		return map.values(); //map으로부터 key없이 value만 리턴해 list로 만듦
	}
	public void update(MemberDTO dto) {
        map.put(dto.getPassword(), dto); //map에 put을 해주면 key값을 통해 같은 값이 있으면 변경, 없으면 새로 삽입 해줌
	}

}
