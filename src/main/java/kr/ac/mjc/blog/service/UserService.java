package kr.ac.mjc.blog.service;

import kr.ac.mjc.blog.domain.User;
import kr.ac.mjc.blog.dto.UserRequest;
import kr.ac.mjc.blog.dto.UserResponse;
import kr.ac.mjc.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserResponse join(UserRequest request){
        User checkUser=userRepository.findByEmail(request.getEmail());

        UserResponse response=new UserResponse();
        if(checkUser!=null){    //이미 가입된 이메일이 있을경우
            response.setSuccess(false);
            response.setMessage("이미 가입된 이메일 입니다");
            return response;
        }
        //이메일로 가입된 사용자가 없는경우
        User joinUser=userRepository.save(request.toEntity());
        response.setSuccess(true);
        response.setMessage("회원 가입이 완료되었습니다");
        response.setUser(joinUser);
        return response;
    }

    public UserResponse login(UserRequest request){
        User checkUser=userRepository.findByEmailAndPassword(request.getEmail()
                ,request.getPassword());

        UserResponse response=new UserResponse();
        if(checkUser==null){    //아이디 또는 패스워드가 틀린경우
            response.setSuccess(false);
            response.setMessage("아이디 또는 패스워드가 틀립니다");
            return response;
        }
        //로그인이 성공한경우
        response.setSuccess(true);
        response.setMessage("로그인 성공");
        response.setUser(checkUser);
        return response;
    }


}
