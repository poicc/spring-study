package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Rank;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.net.ssl.SSLContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CRQ
 */
public class BiLiBiLiSpider {
    private static  final  Integer SUCCESS = 200;
    private static CloseableHttpClient httpClient;
    static {
        try {
            SSLContext sslContext = SSLContextBuilder.create().
                    useProtocol(SSLConnectionSocketFactory.SSL).loadTrustMaterial((x, y) -> true).build();
            RequestConfig config = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(5000).build();
            httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).setSSLContext(sslContext).setSSLHostnameVerifier((x, y) -> true).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static  List<Rank> getRanks(){
        List<Rank> ranks = new ArrayList<>();
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36";
        String url = "https://www.bilibili.com/ranking?spm_id_from=333.851.b_7072696d61727950616765546162.3";
        try {
            Thread.sleep(2000);
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("User-Agent",userAgent);
            HttpClientContext context = HttpClientContext.create();
            CloseableHttpResponse response = httpClient.execute(httpGet,context);
           // System.out.println(response.getStatusLine());

            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode ==SUCCESS){
                HttpEntity entity = response.getEntity();
                if(entity !=null){
                    String res = EntityUtils.toString(entity);
                    //System.out.println(res);
                    Document document = Jsoup.parse(res);
                    Elements scripts = document.getElementsByTag("script");
                    String wholeData = scripts.get(5).html();
                    String data = wholeData.substring(wholeData.indexOf("rankList")+10,wholeData.indexOf("rankRouteParams")-2);
                   //System.out.println(data);
                    JSONArray jsonArray = JSONArray.parseArray(data);
                    jsonArray.forEach(o ->{
                        JSONObject json = JSONObject.parseObject(o.toString());
                        Rank rank = Rank.builder()
                                .title(json.getString("title"))
                                .author(json.getString("author"))
                                .pic(json.getString("pic"))
                                .duration(json.getString("duration"))
                                .build();
                                ranks.add(rank);
                    });

//                    Elements elements = document.getElementsByClass("rank-item");
//                    for(Element element :elements){
//                        String num = element.child(0).text();
//                       // System.out.println(num);
//                        Element contextEle = element.child(1);
//                        String title = contextEle.select(".title").text();
//                       // System.out.println(contextEle.select(".title").text());
//                        Elements img = contextEle.select(".lazy-img img");
//                        //System.out.println(img);
//                        String cover = img.attr("src");
//                        Rank rank = Rank.builder().id(Integer.parseInt(num)).cover(cover).title(title).build();
//                        ranks.add(rank);
//                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ranks;
    }

    public static void main(String[] args) {
        for(Rank rank : getRanks()){
            System.out.println(rank);
        }

    }
}
