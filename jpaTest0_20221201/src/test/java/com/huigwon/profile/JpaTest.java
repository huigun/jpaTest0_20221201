package com.huigwon.profile;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.huigwon.profile.dto.MemberDto;
import com.huigwon.profile.repository.MemberRepository;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class JpaTest {
	
	@Autowired
	MemberRepository memberRepository;
	
//	@Test
//	@DisplayName("이름 검색 테스트")
//	public void searchName() {
//		
//		List<MemberDto> dtos = memberRepository.findByNameContaining("휘");
//		
//		for(MemberDto memberDto : dtos) {
//			System.out.println(memberDto.toString());
//			
//		}
//	}
	
//	@Test
//	@DisplayName("회원 삭제 테스트")
//	public void deleteMember() {
//		Long hak = (long) 2;
//		
//		MemberDto memberDto = memberRepository.findByHakbun(hak);
//		
//		memberRepository.delete(memberDto);
//		
//		List<MemberDto> memberDtos = memberRepository.findAll();
//		
//		for(MemberDto Dto : memberDtos) {
//			System.out.println(Dto.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("회원 삭제 테스트")
//	public void deleteMember() {
//		Long hak = (long) 3;
//		
//		MemberDto memberDto = memberRepository.findByHakbun(hak);
//		
//		memberRepository.deleteById(hak);
//		
//		List<MemberDto> memberDtos = memberRepository.findAll();
//		
//		for(MemberDto Dto : memberDtos) {
//			System.out.println(Dto.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("특정 회원 검색 테스트")
//	public void searchMember() {
//		
//		List<MemberDto> memberDtos = memberRepository.findByNameLike("%건3%");
//		
//		for(MemberDto Dto : memberDtos) {
//			System.out.println(Dto.toString());
//	}
//}
	
	@Test
	@DisplayName("회원 정보 수정 테스트")
	public void deleteMember() {
		
		Optional<MemberDto> memberDto = memberRepository.findById(3L);
		
		assertTrue(memberDto.isPresent());
		
		MemberDto dto = memberDto.get();
		
		dto.setName("이순신"); // 이름 수정
		
		memberRepository.save(dto);
		
		List<MemberDto> memberDtos = memberRepository.findAll();
		for(MemberDto Dto : memberDtos) {
			System.out.println(Dto.toString());	
		
		}memberRepository.deleteByName("안휘건33");

	}
	
}
