package com.application.spider;

import com.application.dao.csdnInfoDao;
import com.application.domain.csdnInfo;
import com.application.service.csdnService;
import com.application.service.impl.csdnServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/*
*
* 自定义Pipe来存数据
*
 */
@Component("pipeline")
public class csdnPipeLine implements Pipeline {
    private static csdnService csdnService;
    @Autowired
    public void setcsdnService(csdnService csdnService)
    {
        csdnPipeLine.csdnService=csdnService;
    }
    @Override
    public void process(ResultItems resultItems, Task task) {
        csdnService csdnService=new csdnServiceImpl();
        String title = resultItems.get("title").toString();
        String author = resultItems.get("author").toString();
        String detail = resultItems.get("detail").toString();
        String url = resultItems.get("url").toString();
        String daytime = resultItems.get("date").toString();
        csdnInfo csdnInfo=new csdnInfo(title,author,detail,url,daytime);
        csdnService.save(csdnInfo);
    }
}
