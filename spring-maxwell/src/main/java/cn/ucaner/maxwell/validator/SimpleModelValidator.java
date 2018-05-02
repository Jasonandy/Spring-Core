package cn.ucaner.maxwell.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cn.ucaner.maxwell.model.SimpleModel;


/**
 * 自定义Spring校验器.
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
