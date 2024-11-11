package com.example.demo.service;

import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    private Long id = 0L;

    public String addUser(User user) { // 유저추가

        if (userExist(user)) {
            return "이미 존재하는 이메일입니다.";
        }

        ++id;
        user.setId(id);
        users.add(user);
        return user.getEmail();
    }

    //이메일 중복확인
    private boolean userExist(User user) {
        return  getAllUsers().stream()
                .anyMatch(a -> a.getEmail().equals(user.getEmail()));
    }

    public List<User> getAllUsers() { // 모든유저 조회
        return users;
    }

    public String deleteUser(Long id) { // 유저삭제
        User findUser = getFindUser(id);
        users.remove(findUser);
        return findUser.getEmail();
    }

    public String updateUserEmail(Long id, String newEmail) { // 유저이메일 변경
        User findUser = getFindUser(id);

        if (findUser != null) {
            findUser.updateEmail(newEmail);
        }

        return findUser.getEmail();

    }

    public User getFindUser(Long id) { // 해당 유저 조회
        User findUser = users.stream()
                .filter(a -> a.getId() == id)
                .findFirst().orElseThrow();
        return findUser;
    }

    public int getUserCount() {
        return users.size();
    }


}
