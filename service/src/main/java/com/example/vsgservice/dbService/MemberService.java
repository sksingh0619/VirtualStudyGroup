package com.example.vsgservice.dbService;

import com.example.vsgservice.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public Member getMember(String memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isPresent()) {
            return member.get();
        }
        return null;
    }

    public Member createMember(Member member){
       return memberRepository.save(member);
    }

    public List<Member> getMembers(){
        return memberRepository.findAll();
    }
}