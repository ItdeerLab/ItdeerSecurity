package cn.itdeer.web;

import cn.itdeer.dto.User;
import cn.itdeer.dto.UserQueryCondition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 * PackageName : cn.itdeer.web
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/1/9/23:24
 */

@RestController
public class UserController {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public List<User> query(UserQueryCondition userQueryCondition){
        System.out.println(userQueryCondition.toString());
        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());

        return list;
    }

}
