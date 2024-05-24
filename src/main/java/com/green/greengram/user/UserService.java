package com.green.greengram.user;

import com.green.greengram.common.CustomFileUtils;
import com.green.greengram.user.model.SignInUserReq;
import com.green.greengram.user.model.SignUpUserReq;
import com.green.greengram.user.model.User;
import com.green.greengram.user.model.UserSignInRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final CustomFileUtils utils;

    @Transactional
    public int signUpUser(MultipartFile mf, SignUpUserReq p){
        log.info("{}", p);
        //암호화
        String hashedPass=BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());
        p.setUpw(hashedPass);
        String picName=utils.makeRandomName(mf);
        p.setPic(picName);
        int result=mapper.signUpUser(p);

        log.info("{}", p);


        //사진처리
        String path=String.format("user/%d", p.getUserId());
        String target=String.format("%s/%s", path, picName);
        try{
            utils.makeFolders(path);
            utils.transferTo(mf, target);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("(╯▽╰ ) 어라라");
        }
        return result;

    }

    UserSignInRes findUserByUserId(SignInUserReq p){
        User user=mapper.findUserByUserId(p);
        if(user==null){throw new RuntimeException("(o゜▽゜)o 누구세요?");}
        if(!BCrypt.checkpw(p.getUpw(), user.getUpw())){throw new RuntimeException("(っ °Д °;)っ 그거 아니야");}

        return UserSignInRes.builder()
                .nm(user.getNm())
                .userId(user.getUserId())
                .pic(user.getPic())
                .build();
    }
}
