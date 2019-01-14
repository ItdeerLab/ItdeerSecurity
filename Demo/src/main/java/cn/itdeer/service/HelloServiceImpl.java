package cn.itdeer.service;

import org.springframework.stereotype.Service;

/**
 * Description :
 * PackageName : cn.itdeer.service
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/1/14/23:52
 */

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String getName(String name) {
        return "Hello " + name;
    }
}
