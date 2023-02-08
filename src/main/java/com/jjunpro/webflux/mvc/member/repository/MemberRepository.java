package com.jjunpro.webflux.mvc.member.repository;

import com.jjunpro.webflux.mvc.member.dto.MemberDto;
import com.jjunpro.webflux.mvc.member.entity.Member;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MemberRepository extends ReactiveMongoRepository<Member, String> {

    Flux<MemberDto> findByAgeBetween(Range<Double> ageRange);
}
