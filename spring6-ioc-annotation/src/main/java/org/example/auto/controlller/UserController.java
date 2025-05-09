package org.example.auto.controlller;

import org.example.auto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
//注入servivce
//第一种方法，属性注入
//    @Autowired
//    private UserService userService;


//    第二种方法set注入
//    private UserService userService;
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }


    //    构造方法注入
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void add() {
        System.out.println("UserController ");
        userService.add();
    }

}
