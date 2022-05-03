package com.example.newdemo.model;

//import com.example.mappertut.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {
    Member getMember(int id);

	/*
	@Select("SELECT * FROM member")
	@Results(id="CompanyMap", value = {
		@Result(property = "id", column = "id"),
		@Result(property = "name", column = "name")
	})
	*/
    List<Member> getMemberList();

    int createMember(Member member);

    int updateMember(Member member);

    int deleteMember(int id);
}
