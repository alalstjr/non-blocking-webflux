package com.jjunpro.iot.member.service;

import com.jjunpro.iot.member.dto.MemberDto;
import com.jjunpro.iot.member.repository.MemberRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MemberService  {

    private final MemberRepository memberRepository;

    public Flux<MemberDto> getMembers() {
        return this.memberRepository.findAll().map(MemberDto::entityToDto);
    }

    public Mono<MemberDto> getMember(String id) {
        return this.memberRepository.findById(id).map(MemberDto::entityToDto);
    }

    public Flux<MemberDto> getMemberInAge(double min, double max) {
        return this.memberRepository.findByAgeBetween(Range.closed(min, max));
    }

    public Mono<MemberDto> saveMember(Mono<MemberDto> memberDtoMono) {
        return memberDtoMono.map(MemberDto::dtoToEntity)
            .flatMap(this.memberRepository::insert)
            .map(MemberDto::entityToDto);
    }

    public Mono<MemberDto> updateMember(Mono<MemberDto> memberDtoMono, String id) {
        return this.memberRepository.findById(id)
                                    .flatMap(
                                        member -> memberDtoMono.map(MemberDto::dtoToEntity)
                                                               .doOnNext(e -> e.setId(id))
                                    )
                                    .flatMap(this.memberRepository::save)
                                    .map(MemberDto::entityToDto);
    }

    public Mono<Void> deleteMember(String id) {
        return this.memberRepository.deleteById(id);
    }
}
