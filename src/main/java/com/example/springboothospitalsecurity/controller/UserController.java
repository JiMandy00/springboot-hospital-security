package com.example.springboothospitalsecurity.controller;


import com.example.springboothospitalsecurity.domain.Response;
import com.example.springboothospitalsecurity.domain.UserDto;
import com.example.springboothospitalsecurity.domain.UserJoinRequest;
import com.example.springboothospitalsecurity.domain.UserJoinResponse;
import com.example.springboothospitalsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest userJoinRequest) {
        UserDto userDto = userService.join(userJoinRequest);
        return Response.success(new UserJoinResponse(userDto.getUserName(),userDto.getEmail()));
    }
}

