package cn.itdeer.validator;

import cn.itdeer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Description :
 * PackageName : cn.itdeer.validator
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/1/14/23:50
 */
public class MyConstraintValidator implements ConstraintValidator<MyValidator,String>{


    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyValidator constraintAnnotation) {
        System.out.println("校验初始化");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println("校验");

        System.out.println(helloService.getName("Itdeer"));

        return false;
    }
}
