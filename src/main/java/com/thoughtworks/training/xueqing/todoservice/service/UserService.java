package com.thoughtworks.training.xueqing.todoservice.service;

import com.thoughtworks.training.xueqing.todoservice.model.User;
import com.thoughtworks.training.xueqing.todoservice.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Value("${secretkey}")
    private String secretKey;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        return userRepository.findOne(id);
    }

    public User findByName(String name) {
        return userRepository.findOneByName(name);
    }

    public User save(User user) {
    //加密密码
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());

        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }

    public boolean verify(String name, String password) {
        Optional<User> user = userRepository.findByNameEquals(name);
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        //验证密码是否正确
        boolean matches = encoder
                .matches(password,user.get().getPassword());
        return matches;
    }

    public String generateToken(Integer id,String name){

        HashMap<String,Object> claims = new HashMap<>();
        System.out.println("generateToken:id="+id+";name="+name);
//        claims.put("cardId",id);
        claims.put("cardId",id);
        claims.put("name",name);
        //生成token并返回
        String token = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS512,secretKey.getBytes())
                .compact();
        return token;
    }

    public User getUserByToken(String token) {
        String name = (String) Jwts.parser()
                        .setSigningKey(secretKey.getBytes())
                        .parseClaimsJws(token).getBody().get("name");
        User user = userRepository.findOneByName(name);
        System.out.println(user.getId()+";"+user.getName());
        System.out.println("user service get user by token");
        return user;
    }
}
