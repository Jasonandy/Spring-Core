package cn.ucaner.analyze.aop.factory;

/**
* @Package：cn.ucaner.analyze.aop.factory   
* @ClassName：Car   
* @Description：   <p> 定义接口 - Car </p>
* @Author： -    
* @CreatTime：2018年5月15日 下午3:19:17   
* @Modify By：   
* @ModifyTime：  2018年5月15日
* @Modify marker：   
* @version    V1.0
 */
public interface Car {

	/**
	 * 开车
	 */
    void driveCar();

    /**
     * 售车
     */
    void saleCar();
    
    /**
     * @Description: For cglib proxy 
     * @param echo
     */
    String echo(String echo);
}
