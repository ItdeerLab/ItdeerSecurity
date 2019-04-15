package cn.itdeer.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * Description :
 * PackageName : cn.itdeer.async
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/4/11/14:18
 */

@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;


    @RequestMapping("/order")
    public Callable<String> order() throws Exception{
        logger.info("主线程开始");
//        Thread.sleep(1000);


        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程开始");
                Thread.sleep(1000);
                logger.info("副线程结束");
                return "success";
            }
        };


        logger.info("主线程返回");


        return result;
    }


    @GetMapping("/dingdan")
    public DeferredResult<String> dingdan() throws InterruptedException {
        logger.info("主线程开始");

        String orderNum = RandomStringUtils.randomNumeric(8);
        mockQueue.setPaceOrder(orderNum);

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNum,result);


        logger.info("主线程返回");
        return result;
    }

}
