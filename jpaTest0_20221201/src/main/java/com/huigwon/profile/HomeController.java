package com.huigwon.profile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huigwon.profile.dto.MemberDto;
import com.huigwon.profile.repository.MemberRepository;

@Controller
public class HomeController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@RequestMapping(value="/join")
	public String join() {
		
		return "join";
	}
	
	@RequestMapping(value="/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String grade = request.getParameter("grade");
		String etc = request.getParameter("etc");
		
		MemberDto dto = new MemberDto();
		dto.setAge(Integer.parseInt(age));
		dto.setEtc(etc);
		dto.setGrade(Integer.parseInt(grade));
		dto.setName(name);
		
		MemberDto mdto = memberRepository.save(dto);
		model.addAttribute("mDto", mdto);
		return "joinOk";
	}
	
//	@RequestMapping(value="/searchOk")
//	public String searchOk(HttpServletRequest request, Model model) {
//			String searchId = request.getParameter("searchId");
//			List<MemberDto> memberDtos = memberRepository.findByName(searchId);
//			for(MemberDto memberDto : memberDtos) {
//				System.out.println(memberDto.toString());
//			}
//				model.addAttribute("searchDtos", memberDtos);
//		return "searchResult";
//	}
	
	@RequestMapping(value="/search")
	public String search() {

		return "search";
	}
	
	@RequestMapping(value="/allmember")
	public String allmember(Model model) {
		
		
		
		List<MemberDto> memberDtos = memberRepository.findAll(Sort.by(Sort.Direction.DESC, "hakbun"));
		

		List<MemberDto> memberDtos2 = memberRepository.findAllByOrderByHakbunDesc();
		
		model.addAttribute("allmember", memberDtos2);
		
		return "allmember";
	}
	
	@RequestMapping(value="memberor")
	public String memberor() {
				
		List<MemberDto> memberDtos = memberRepository.findByNameAndHakbun("안휘건", (long) 2)	;
		
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		}
		
		
		return "memberor";
	}
	
	@RequestMapping(value="lessthan")
	public String lessthan() {
		
		List<MemberDto> memberDtos = memberRepository.findByAgeLessThan(21);
		
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		}
		
		return "";
	}
	
	@RequestMapping(value="between")
	public String between() {
		
		List<MemberDto> memberDtos = memberRepository.findByAgeBetween(11, 15);
		
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		}
		
		return "";
	}
	
	@RequestMapping(value="like")
	public String like() {
		
		List<MemberDto> memberDtos = memberRepository.findByNameContaining("휘건");
		
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		}
		
		return "";
	}
}
