package cn.ucaner.hashmap;

import com.google.common.base.Objects;

/**
* @Package：cn.ucaner.hashmap   
* @ClassName：HashKey   
* @Description：   <p> HashKey </p>
* @Author： - tq   
* @CreatTime：2016/10/15 0015  
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public class HashKey {
	
    private String key;

    public HashKey(){}

    public HashKey(String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashKey hashKey = (HashKey) o;
        return Objects.equal(key, hashKey.key);
    }

    @Override
    public int hashCode() {
        return 2;
    }
}
