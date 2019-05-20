/**
@CreateTime: sunning2019年3月6日
@CreateUser: sunning 
@Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
*/

 package us.codecraft.webmagic.test;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author sunning
 * @date 2019/03/06
 */
 public class OschinaBlogPageProcesser implements PageProcessor {

     private Site site = Site.me().setDomain("my.oschina.net");

     @Override
     public void process(Page page) {
         List<String> links = page.getHtml().links().regex("http://my\\.oschina\\.net/flashsword/blog/\\d+").all();
         page.addTargetRequests(links);
         page.putField("title", page.getHtml().xpath("//div[@class='BlogEntity']/div[@class='BlogTitle']/h1").toString());
         page.putField("content", page.getHtml().$("div.content").toString());
         page.putField("tags",page.getHtml().xpath("//div[@class='BlogTags']/a/text()").all());
     }

     @Override
     public Site getSite() {
         return site;

     }

     public static void main(String[] args) {
         Spider.create(new OschinaBlogPageProcesser()).addUrl("http://my.oschina.net/flashsword/blog")
              .addPipeline(new ConsolePipeline()).run();
     }
 }