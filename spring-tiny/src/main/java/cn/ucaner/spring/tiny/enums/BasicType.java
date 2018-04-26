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

    Boolean("Boolean"), 
    Character("Character"), 
    String("String"), 
    Integer("Integer"),
    Byte("Byte"),
    Short("Short"),
    Long("Long"), 
    Float("Float"), 
    Double("Double");

    public String simpleTypeName;

    BasicType(String simpleTypeName) {
        this.simpleTypeName = simpleTypeName;
    }

}
