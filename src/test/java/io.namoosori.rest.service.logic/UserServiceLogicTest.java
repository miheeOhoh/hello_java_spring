package io.namoosori.rest.service.logic;

import io.namoosori.rest.entity.User;
import io.namoosori.rest.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceLogicTest {

    @Autowired
    private UserService userService;

    private User kim;
    private User park;

    @BeforeEach
    public void startUp(){
        this.kim = new User("kim", "kimm@naver.com");
        this.park = new User("park", "park@nvaer.com");
        this.userService.register(kim);
        this.userService.register(park);
    }

    @Test
    public void registerTest(){
        User sample = User.sample();

        assertThat(this.userService.register(sample)).isEqualTo(sample.getId());
        assertThat(this.userService.findAll().size()).isEqualTo(3);
    }

    @Test
    public void find() {
        assertThat(this.userService.find(kim.getId())).isNotNull();
        assertThat(this.userService.find(kim.getId()).getEmail()).isEqualTo(kim.getEmail());
    }

    @AfterEach
    public void cleanUp(){
        this.userService.remove(kim.getId());
        this.userService.remove(park.getId());
    }
}
