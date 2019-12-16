package Basic1.controller;

import Basic1.service.UserBo;
import Basic1.service.UserService;

public class UserController {
    private UserService userService; //通过构造函数或者IOC框架注入

    public UserVo getUserById(Long userId) {
//        UserBo userBo = userService.getUser(userId);
//        UserVo userVo = [...convert userBo to userVo...];
//        return userVo;
        return null;
    }
}
