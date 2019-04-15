package cn.itdeer.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Description :
 * PackageName : cn.itdeer.async
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/4/15/16:47
 */

@Component
public class MockQueue {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String paceOrder;
    private String completeOrder;

    public String getPaceOrder() {
        return paceOrder;
    }

    public void setPaceOrder(String paceOrder){

        new Thread(() ->{
            logger.info("订单进入");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("订单完成");
            this.completeOrder = paceOrder;
        }).start();
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
