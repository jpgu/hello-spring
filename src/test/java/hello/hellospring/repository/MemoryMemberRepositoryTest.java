package hello.hellospring.repository;

import java.util.List;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import hello.hellospring.domain.Member;

class MemoryMemberRepositoryTest {
	
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach
	public void afterEach() {
		
		repository.clearStore();
		
	}
	
	@Test
	public void save(){
		
		Member member = new Member();		
		member.setName("spring");
		
		repository.save(member);
		
		Member result = repository.findById(member.getId()).get();
		
		//System.out.println("result => "  + (member == result));
		
		Assertions.assertEquals(member,  result);
		
	}
	
	
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring5");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring6");
		repository.save(member2);
		
		Member result = repository.findByName("spring6").get();
		
		Assertions.assertEquals(member2,  result);
	}
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		List<Member> result = repository.findAll();
		
		Assertions.assertEquals(result.size(),  2);
		
	}
	

}
