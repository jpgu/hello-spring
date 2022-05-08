package hello.hellospring.service;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

@SpringBootTest
public class MemberServiceTest {
	
	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	
	
	/*
	@BeforeEach
	public void beforeEach() {
		
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
		
	}

	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	*/
	
	
	@Test
	public void ȸ������() {
		// given
		Member member = new Member();
		member.setName("better");
		
		// when
		Long saveId = memberService.join(member);
		
		// then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
		
		//throw new RuntimeException("not yet implemented");
	}
	
	
	@Test
	public void �ߺ�ȸ��_����() {
		
		//given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		
		assertThat(e.getMessage()).isEqualTo("�̹� �����ϴ� ȸ���Դϴ�");
		
		// when
//		memberService.join(member1);
//		try {
//			memberService.join(member2);
//			fail();
//		}
//		catch(IllegalStateException e) {
//			assertThat(e.getMessage()).isEqualTo("�̹� �����ϴ� ȸ���Դϴ�");
//			
//		}		
		
		// then		
	}
	

	@Test
	public void testFindMembers() {
		//throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testFindOne() {
		//throw new RuntimeException("not yet implemented");
	}

}
