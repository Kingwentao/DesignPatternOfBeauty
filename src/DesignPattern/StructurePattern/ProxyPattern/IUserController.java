package DesignPattern.StructurePattern.ProxyPattern;

import Basic1.controller.UserVo;

/**
 * Created by WenTaoKing on 2020/2/27
 * description: 用户行为的接口
 */
public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}
