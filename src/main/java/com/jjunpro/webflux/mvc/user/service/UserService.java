package com.jjunpro.webflux.mvc.user.service;

import com.jjunpro.webflux.mvc.user.dto.UserDto;
import com.jjunpro.webflux.mvc.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Flux<UserDto> getUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    public Mono<UserDto> saveUser(Mono<UserDto> userDtoMono) {
        return userDtoMono.map(UserDto::dtoToEntity)
            .flatMap(this.userRepository::insert)
            .map(UserDto::entityToDto);
    }
}
