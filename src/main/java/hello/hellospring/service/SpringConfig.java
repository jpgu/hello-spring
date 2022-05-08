package hello.hellospring.service;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

@Configuration
public class SpringConfig {
	
	/*
	// JDBC 사용 case 
	private DataSource dataSource;   	
	
	@Autowired
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	@Bean
	public MemberRepository memberRepository() {
		return new JdbcTemplateMemberRepository(dataSource);
	}	
	*/
	
	
	
	/*
	// JPA 사용 case
	
	private EntityManager em;      // JPA 사용 case
	
	@Autowired
	public SpringConfig(EntityManager em) {
		this.em = em;
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new JpaMemberRepository(em);
	}	

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository()); 
	}
	*/
	
	
	// Spring 데이터 JPA 사용 case
	
	private final MemberRepository memberRepository;
	
	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository); 
	}
	
		
}
