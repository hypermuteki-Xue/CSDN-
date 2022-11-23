package com.application.spider;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

import java.util.Date;
import java.util.regex.Pattern;

public class csdnPageProcessor implements PageProcessor {
    public static final String Blog ="https://blog.csdn.net/.+/article/details/.+";
    public static final String authorPage="https://blog.csdn.net/\\w+$";
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().all());
        if (Pattern.matches(Blog, page.getUrl().toString())) {
            //获得标题
            page.putField("title", page.getHtml().xpath("//title/text()").toString());
            //获得作者
            page.putField("author", page.getHtml().xpath("//*[@id=\"uid\"]/span/text()").toString());
            //获得描述信息
            page.putField("detail", page.getHtml().xpath("//*[@name=\"description\"]/@content").toString());
            //获得Url
            page.putField("url", page.getUrl().toString());
            //获得时间
            page.putField("date", new Date());
        }
        if (page.getResultItems().get("title") == null) {
            // 如果是列表页，跳过此页，pipeline不进行后续处理
            page.setSkip(true);
        }
    }
    @Override
    public Site getSite() {
        return Site.me().setRetryTimes(8).setSleepTime(500);
    }
}
