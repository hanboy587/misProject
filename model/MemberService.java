package com.example.newdemo.model;

//import com.example.newdemo.model.Member;
//import com.example.newdemo.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<Member> getMemberList() {
        return memberMapper.getMemberList();
    }

    public Member getMember(int id) {
        return memberMapper.getMember(id);
    }

    public int createMember(Member member) {
        return memberMapper.createMember(member);
    }

    public int updateMember(Member member) {
        return memberMapper.updateMember(member);
    }

    public int deleteMember(int id) {
        return memberMapper.deleteMember(id);
    }
}
