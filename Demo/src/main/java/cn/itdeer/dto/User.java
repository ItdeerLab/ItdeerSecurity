package cn.itdeer.dto;

import cn.itdeer.validator.MyValidator;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Description :
 * PackageName : cn.itdeer.dto
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/1/9/23:34
 */

@Data
public class User {

    public interface UserSimpleView {}
    public interface UserDetailView extends UserSimpleView{}


    @JsonView(UserSimpleView.class)
    private int id;
    @JsonView(UserSimpleView.class)
    @Past(message = "生日只能是过去的时间")
    private Date birthday;

    @JsonView(UserSimpleView.class)
    @MyValidator(message = "用户名不能为空")
    private String username;
    @JsonView(UserDetailView.class)
    @NotBlank(message = "密码不能为空")
    private String password;
}
