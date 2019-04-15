package cn.itdeer.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description :
 * PackageName : cn.itdeer.dto
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/1/9/23:43
 */

@Data
public class UserQueryCondition {

    @ApiModelProperty(value = "用户名称")
    private String username;

    @ApiModelProperty(value = "用户年龄起始值")
    private int age;
    @ApiModelProperty(value = "用户年龄结束值")
    private int ageTo;
    private String xxx;

}
