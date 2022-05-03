package com.example.newdemo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberMapper memberMapper;

	@PostMapping("")
	public int post(@RequestBody Member member) {
		System.out.println("post");
		System.out.println("company toString()");
		return 1;
	}

	@GetMapping("")
	//public List<Member>getAll() {
	public List<Member> getAll() {
		System.out.println("getAll");
		return memberMapper.getMemberList();
	}

	/*
	@GetMapping("/{id}")
	public Member getById(@PathVariable("id") int id) {
		System.out.println("getById");
		System.out.print("id : ");
		System.out.println(id);
		return "";
	}
	*/
}
