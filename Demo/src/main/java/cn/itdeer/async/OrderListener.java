package cn.itdeer.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Description :
 * PackageName : cn.itdeer.async
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/4/15/17:03
 */

@Component
public class OrderListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        new Thread(() ->{
            while (true){

                if(StringUtils.isNotBlank(mockQueue.getCompleteOrder())){
                    String orderNum = mockQueue.getCompleteOrder();
                    logger.info("返回订单处理结果：" + orderNum);
                    deferredResultHolder.getMap().get(orderNum).setResult("pace order success");
                    mockQueue.setCompleteOrder(null);
                }else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();



    }
}
