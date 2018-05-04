package cn.ucaner.maxwell.controller;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.ucaner.maxwell.model.SimpleModel;

/**
* @Package：cn.ucaner.maxwell.controller   
* @ClassName：SimpleController   
* @Description：   <p> 简单的Spring {@link org.springframework.stereotype.Controller} </p>
* @Author： - Jason    
* @CreatTime：2018年5月4日 上午10:44:16   
* @Modify By：   
* @ModifyTime：  2018年5月4日
* @Modify marker：   
* @version    V1.0
 */
@Controller
public class SimpleController {

    private Validator validator;

    @InitBinder
    public void initBinder(DataBinder dataBinder) {
        //dataBinder.setValidator(new SimpleModelValidator());
        //dataBinder.addValidators(new SimpleModelValidator());
    }

    @PostConstruct
    public void initValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @RequestMapping("/echo")
    public String echo(@RequestParam("name") String name, Model model, HttpServletRequest request) throws InterruptedException {
        model.addAttribute("echo", "hello " + name);
        return "echo";
    }

    @RequestMapping(value = "/echoAgain", method = RequestMethod.POST)
    public String echo(@RequestBody SimpleModel simpleModel, BindingResult bindingResult, Model model) {

        Set<ConstraintViolation<SimpleModel>> result = validator.validate(simpleModel);
        for (ConstraintViolation<SimpleModel> r : result) {
            System.out.println("错误消息: " + r.getMessage());
        }

        String hello;
        if (bindingResult.hasErrors()) {
            hello = "Ops, error!";
        } else {
            hello = "hello " + simpleModel.getName() + ", your age is " + simpleModel.getAge() + ".";
        }
        model.addAttribute("echo", hello);
        System.out.println(simpleModel);
        return "echo";
    }

}
