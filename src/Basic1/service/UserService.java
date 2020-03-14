package Basic1.service;

import Basic1.repository.UserEntity;
import Basic1.repository.UserRepository;

public class UserService {
    private UserRepository userRepository; //通过构造函数或者IOC框架注入

    public UserBo getUserById(Long userId) {
//        UserEntity userEntity = userRepository.getUserById(userId);
//        UserBo userBo = [...convert userEntity to userBo...];
//        return userBo;
        return null;
    }

}
