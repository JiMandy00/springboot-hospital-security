package com.example.springboothospitalsecurity.service;

import com.example.hospitalsecurity.domain.User;
import com.example.hospitalsecurity.domain.UserDto;
import com.example.hospitalsecurity.domain.UserJoinRequest;
import com.example.hospitalsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto join(UserJoinRequest request) {
        // 비즈니스 로직 - 회원 가입
        // 회원 userName(id) 중복 Check
        // 중복이면 회원가입 x --> Exception(예외)발생
        // 중복이면 회원가입 x --> Exception(예외)발생

        // 있으면 에러처리
        userRepository.findByUserName(request.getUserName())
                .ifPresent(user -> new RuntimeException("해당 UserName이 중복 됩니다."));

        // 회원가입 .save()
        User savedUser = userRepository.save(request.toEntity());
        return UserDto.builder()
                .id(savedUser.getId())
                .userName(savedUser.getUserName())
                .email(savedUser.getEmailAddress())
                .build();
    }
}


