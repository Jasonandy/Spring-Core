package cn.ucaner.analyze.aop.bean;

/**
* @Package：cn.ucaner.analyze.aop.bean   
* @ClassName：Chinese   
* @Description：   <p> Chinese 接口 </p>
* @Author： - Jason   
* @CreatTime：2018年5月15日 下午2:34:08   
* @Modify By：   
* @ModifyTime：  2018年5月15日
* @Modify marker：   
* @version    V1.0
 */
public interface Chinese {
	
    // 实现 Person 接口的 sayHello() 方法
   String sayHello(String name);

    // 定义一个 eat() 方法
   void eat(String food);
}
