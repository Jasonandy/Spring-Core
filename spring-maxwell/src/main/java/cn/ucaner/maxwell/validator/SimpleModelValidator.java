package cn.ucaner.maxwell.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cn.ucaner.maxwell.model.SimpleModel;

/**
* @Package：cn.ucaner.maxwell.validator   
* @ClassName：SimpleModelValidator   
* @Description：   <p> 自定义Spring校验器. </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:46:54   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
public class SimpleModelValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return (clazz == SimpleModel.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SimpleModel simpleModel = (SimpleModel) target;
        Integer age = simpleModel.getAge();
        if (age == null || age < 1 || age > 200) {
            errors.reject("100", "年龄不合法");
        }
    }

}
