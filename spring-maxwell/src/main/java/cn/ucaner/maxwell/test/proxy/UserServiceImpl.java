package cn.ucaner.maxwell.test.proxy;

/**
* @Package：cn.ucaner.maxwell.test.proxy   
* @ClassName：UserServiceImpl   
* @Description：   <p> {@link UserService}实现 </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:46:30   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class UserServiceImpl implements UserService {

    @Override
    public void printName() {
        System.out.println("Name is XXX");
        printAge();
    }

    @Override
    public void printAge() {
        System.out.println("Age: " + 18);
    }

}
