package cn.itdeer.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Description :
 * PackageName : cn.itdeer.async
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/4/15/16:52
 */
@Component
public class DeferredResultHolder {

    private Map<String,DeferredResult<String>> map = new HashMap<String,DeferredResult<String>>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }
}
