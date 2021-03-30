package DesignPattern.StructurePattern.ProxyPattern;

import Basic1.controller.UserVo;

/**
 * Created by WenTaoKing on 2020/2/27
 * description:
 */
public class UserController implements IUserController{

    @Override
    public UserVo login(String telephone, String password) {
        //...省略其他属性和方法...
        System.out.println(telephone + "is login" + "password: "+password);
        return null;
    }

    @Override
    public UserVo register(String telephone, String password) {
        //...省略其他属性和方法...
        return null;
    }
}
