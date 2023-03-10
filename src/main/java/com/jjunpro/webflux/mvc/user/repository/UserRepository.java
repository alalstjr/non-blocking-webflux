package com.jjunpro.webflux.mvc.user.repository;

import com.jjunpro.webflux.mvc.user.dto.UserDto;
import com.jjunpro.webflux.mvc.user.entity.User;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Flux<UserDto> findByUsername(String username);
}
