package cn.ucaner.spring.tiny.enums;

/**
* @Package：cn.ucaner.spring.tiny.enums   
* @ClassName：BasicType   
* @Description：   <p> BasicType </p>
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public enum BasicType {

    Boolean("Boolean"), //布尔
    Character("Character"), //字符
    String("String"), //字符串
    Integer("Integer"),//整型
    Byte("Byte"),//字节
    Short("Short"),//短型
    Long("Long"), //长
    Float("Float"), //浮点
    Double("Double");//双精度

    public String simpleTypeName;//类型名

    BasicType(String simpleTypeName) {
        this.simpleTypeName = simpleTypeName;
    }

}
