package com.jjunpro.iot.member.dto;

import com.jjunpro.iot.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    private String id;
    private String name;
    private int    age;

    public static MemberDto entityToDto(Member member) {
        MemberDto memberDto = new MemberDto();
        BeanUtils.copyProperties(member, memberDto);

        return memberDto;
    }

    public static Member dtoToEntity(MemberDto memberDto) {
        Member member = new Member();
        BeanUtils.copyProperties(memberDto, member);

        return member;
    }
}
