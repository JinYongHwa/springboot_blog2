package kr.ac.mjc.blog.dto;

import kr.ac.mjc.blog.domain.User;

public class UserRequest {
    private String email;
    private String password;

    public User toEntity(){
        User user=new User();
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
