/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.xsoup.xevaluator.ElementOperator;

import java.io.*;
import java.util.stream.IntStream;

/**
 * @author mr.24
 * @version Id: CSRCSpider, v 1.0 2018/12/2 下午5:53 Exp $$
 */
public class CSRCSpider implements PageProcessor {

    // 重试、超时数据
    private Site site = Site.me()
            .setRetryTimes(3)
            .setSleepTime(1000)
            .addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")
            ;

    @Override
    public void process(Page page) {

        // ^[0-9]{6}/[a-z]{1}[0-9]{8}_[0-9]{6}.[a-z]{4}
        //page.putField("div", page.getUrl().regex("^[0-9]{6}/[a-z]{1}[0-9]{8}_[0-9]{6}.[a-z]{4}").toString());
        String[] pageUrl = new String[25];

        pageUrl[0] = "http://www.csrc.gov.cn/pub/newsite/fxjgb/scgkfxfkyj/index.html";
        IntStream.range(1, pageUrl.length).forEachOrdered(i -> pageUrl[i] = "http://www.csrc.gov.cn/pub/newsite/fxjgb/scgkfxfkyj/index_" + i + ".html");

        for (String str : pageUrl) {
            // 将所有的页面加入
            page.addTargetRequest(str);
        }

        String[] xPaths = new String[20];
        for(int i = 1; i <= 20; i++) {
            xPaths[i - 1] = "//*[@id=\"myul\"]/li[" + i + "]";
            page.putField("div", page.getHtml().xpath(xPaths[i - 1]).toString());

        }

        //page.putField("div", page.getUrl().regex("[0-9]{6}/[a-z]{1}[0-9]{8}_[0-9]{6}.[a-z]{4}").toString());
        page.putField("div", page.getUrl().regex("^[0-9]{6}/[a-z]{1}[0-9]{8}_[0-9]{6}.[a-z]{4}").toString());

        //Pattern pattern = Pattern.compile("<a.*?href=.*?<\/a>";
        //page.putField("div", page.getUrl().regex("<a.*?href=.*?<\/a>").toString());
        //page.putField("div", page.getHtml().xpath("//*[@id=\"myul\"]/li[1]").toString());

        // //*[@id="myul"]/li[1]
        //*[@id="myul"]/li[19]
        //*[@id="myul"]/li[20]/a
        //*[@id="myul"]/li[20]/a
        //*[@id="myul"]/li[20]
        if (page.getResultItems().get("div") != null) {
            System.out.println(page.getResultItems().toString());

            String path = "/Users/mr.24/fzw/codeTrunk/ThinkingInJava/src/main/java/spider/url.txt";
            BufferedWriter out = null;
            try {
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                out.write(page.getResultItems().get("div") + "\r\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }

        //List<String> detailUrls = page.getUrl().regex("http://www.csrc.gov.cn/pub/newsite/fxjgb/scgkfxfkyj/[0-9]{6}/.*").all();

//        for (String list : detailUrls) {
//            String path = "/Users/mr.24/fzw/codeTrunk/ThinkingInJava/src/main/java/spider/url.txt";
//            BufferedWriter out = null;
//            try {
//                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true)));
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            try {
//                out.write(list + "\r\n");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new CSRCSpider())
                .addUrl("http://www.csrc.gov.cn/pub/newsite/fxjgb/scgkfxfkyj/index.html")
                //.addPipeline(new JsonFilePipeline("/Users/mr.24/fzw/codeTrunk/ThinkingInJava/src/main/java/spider"))
                .thread(5)
                .run();
    }
}
