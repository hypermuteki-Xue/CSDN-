package com.application;

import com.application.dao.csdnInfoDao;
import com.application.domain.csdnInfo;
import com.application.service.csdnService;
import com.application.spider.csdnPageProcessor;
import com.application.spider.csdnPipeLine;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

@SpringBootApplication
public class SpringbootSpiderApplication implements CommandLineRunner {
    @Autowired
    private csdnService csdnService;
    public static void main(String[] args) {
        SpringApplication.run(SpringbootSpiderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        QueueScheduler scheduler=new QueueScheduler();
        //指定队列使用布隆过滤器去重
        scheduler.setDuplicateRemover(new BloomFilterDuplicateRemover(10000000));
        Spider.create(new csdnPageProcessor()).addUrl("https://blog.csdn.net/").addPipeline(new csdnPipeLine()).thread(3).setScheduler(scheduler).start();
    }
}
