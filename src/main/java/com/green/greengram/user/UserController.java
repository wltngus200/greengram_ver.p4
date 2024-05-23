package com.green.greengram.user;

import com.green.greengram.common.ResultDto;
import com.green.greengram.user.model.SignInUserReq;
import com.green.greengram.user.model.SignUpUserReq;
import com.green.greengram.user.model.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("api/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("sign-up")
    @Operation(summary="USER SIGN-UP", description = "회원 가입")
    public ResultDto<Integer> signUpUser(@RequestPart(required = false) MultipartFile mf, @RequestPart SignUpUserReq p){
        int result=service.signUpUser(mf, p);

        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("( •̀ ω •́ )✧ 어서오라굿")
                .resultData(result)
                .build();
    }

    @PostMapping("sign-in")
    @Operation(summary="USER LOG-IN", description = "유저 로그인")
    public ResultDto<User> signInUser(@RequestBody SignInUserReq p){
        User result=service.findUserByUserId(p);
        return ResultDto.<User>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("━((*′д｀)爻(′д｀*))━!!!!")
                .resultData(result)
                .build();
    }
}
