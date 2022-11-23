package com.application.service.impl;

import com.application.dao.csdnInfoDao;
import com.application.domain.csdnInfo;
import com.application.service.csdnService;
import com.application.spider.csdnPageProcessor;
import com.application.spider.csdnPipeLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

@Service
public class csdnServiceImpl implements csdnService {
    private static csdnInfoDao csdnInfoDao;
    @Autowired
    public void setcsdnInfoDao(csdnInfoDao csdnInfoDao)
    {csdnServiceImpl.csdnInfoDao=csdnInfoDao;}
    @Override
    public void save(csdnInfo csdnInfo) {
        csdnInfoDao.InsertBlog(csdnInfo);
    }
}
