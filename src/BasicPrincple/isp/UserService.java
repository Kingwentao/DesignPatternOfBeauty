package BasicPrincple.isp;

/**
 * author: WentaoKing
 * created on: 2019/12/14
 * description:
 * <p>
 * ISP : Clients should not be forced to depend upon interfaces that they do not use
 * there are interface means :
 * 1. A group of api collection interface
 * 2. A single interface or function
 * 3. OOP interface
 * The design of function need feature single
 */
interface UserService {
    boolean register(String cellphone, String password);

    boolean login(String cellphone, String password);

  //  UserInfo getUserInfoById(long id);

  //  UserInfo getUserInfoByCellphone(String cellphone);
}
