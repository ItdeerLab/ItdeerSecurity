package cn.itdeer.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

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
    private String username;
    @JsonView(UserDetailView.class)
    private String password;
}
