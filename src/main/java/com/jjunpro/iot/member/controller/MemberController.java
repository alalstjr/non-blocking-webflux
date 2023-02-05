package com.jjunpro.iot.member.controller;

import com.jjunpro.iot.member.dto.MemberDto;
import com.jjunpro.iot.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public Flux<MemberDto> getMembers() {
        return this.memberService.getMembers();
    }

    @GetMapping("/{id}")
    public Mono<MemberDto> getMember(@PathVariable String id) {
        return this.memberService.getMember(id);
    }

    @GetMapping("/range")
    public Flux<MemberDto> getMember(@RequestParam double min, @RequestParam double max) {
        return this.memberService.getMemberInAge(min, max);
    }

    @PostMapping
    public Mono<MemberDto> saveMember(@RequestBody Mono<MemberDto> memberDtoMono) {
        return this.memberService.saveMember(memberDtoMono);
    }

    @PutMapping("/{id}")
    public Mono<MemberDto> updateMember(@RequestBody Mono<MemberDto> memberDtoMono, @PathVariable String id) {
        return this.memberService.updateMember(memberDtoMono, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteMember(@PathVariable String id) {
        return this.memberService.deleteMember(id);
    }
}
