package com.jjunpro.iot.member.repository;

import com.jjunpro.iot.member.dto.MemberDto;
import com.jjunpro.iot.member.entity.Member;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MemberRepository extends ReactiveMongoRepository<Member, String> {

    Flux<MemberDto> findByAgeBetween(Range<Double> ageRange);
}
