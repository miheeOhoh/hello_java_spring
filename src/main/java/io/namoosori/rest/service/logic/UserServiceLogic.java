package io.namoosori.rest.service.logic;

import io.namoosori.rest.entity.User;
import io.namoosori.rest.service.UserService;
import io.namoosori.rest.store.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceLogic implements UserService {

    private final UserStore userStore;

    // 어노테이션을 통한 주입
    // @Autowired
    // private UserStore userStore;
    // 구현체를 먼저 불러옴
    // userStore는 해당 인터페이스를 구현한 클래스에서 @Repository 어노테이션을 통해 bean으로 등록해주었다.

    // 생성자를 통한 주입
//    public UserServiceLogic(UserStore userStore) {
//        this.userStore = userStore;
//    }


    @Override
    public String register(User newUser) {
        return this.userStore.create(newUser);
    }

    @Override
    public void modify(User newUser) {
        this.userStore.update(newUser);
    }

    @Override
    public void remove(String id) {
        this.userStore.delete(id);
    }

    @Override
    public User find(String id) {
        return this.userStore.retrieve(id);
    }

    @Override
    public List<User> findAll() {
        return this.userStore.retrieveAll();
    }
}
