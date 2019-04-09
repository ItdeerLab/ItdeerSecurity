package cn.itdeer.web;

import cn.itdeer.dto.User;
import cn.itdeer.dto.UserQueryCondition;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
@RequestMapping("/user")
public class UserController {


    @PostMapping
    public User create(@RequestBody @Valid User user, BindingResult error){

        if(error.hasErrors()){
            error.getAllErrors().stream().forEach(err -> System.out.println(err.getDefaultMessage()));
        }


        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getId());
        System.out.println(user.getBirthday());

        user.setId(1);
        return user;
    }


    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition userQueryCondition, @PageableDefault(page = 12,size = 20,sort = "username:desc") Pageable pageable){


        System.out.println(ReflectionToStringBuilder.toString(userQueryCondition, ToStringStyle.MULTI_LINE_STYLE));

        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getSort());
        System.out.println(pageable.getOffset());

        System.out.println(userQueryCondition.toString());
        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());

        return list;
    }


    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id){
        System.out.println("ID:" + id);

//        throw new RuntimeException("aaaaa");
        System.out.println("方法体处理.....");

        User user = new User();
        user.setUsername("tom");
        return user;
    }


    @PutMapping("/{id:\\d+}")
    public User update(@RequestBody @Valid User user, BindingResult errors){

        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError)error;
                System.out.println(fieldError.getField());
                System.out.println(error.getDefaultMessage());
            });
        }


        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable int id){
        System.out.println(id);
    }

}
