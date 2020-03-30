package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Topic;
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

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author CRQ
 */
public class JunJinSpider {
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

//    public static List<Topic> getTopics() throws IOException {
//        List<Topic> topics = new ArrayList<>();
//        String url = "https://short-msg-ms.juejin.im/v1/topicList?uid=5e7ef34ef265da7974530c61&device_id=1585378126741&token=eyJhY2Nlc3NfdG9rZW4iOiJkV29PYlRkVzM5Q1B3N05qIiwicmVmcmVzaF90b2tlbiI6Im8xMEVkUHlScEJMWnlWaDAiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&sortType=hot&page=0&pageSize=100";
//        HttpGet get = new HttpGet(url);
//        HttpClientContext context = HttpClientContext.create();
//        CloseableHttpResponse response = null;
//        try {
//            response = httpClient.execute(get, context);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//       // System.out.println(response.getStatusLine());
//
//        //如果请求成功，则获取网页源码
//        if (response.getStatusLine().getStatusCode() == SUCCESS) {
//            //获取相应对象实体
//            HttpEntity entity = response.getEntity();
//            String res = null;
//            try {
//                res = EntityUtils.toString(entity, "UTF-8");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//           // System.out.println(res);
//
//    //        Document document = Jsoup.parse(res);
////            Elements elements = document.select("topic-item");
////            for (Element element : elements) {
////                Elements iconEle = element.select("a>div");
////                Elements contentEle = element.select(".content a");
////
////                System.out.println(iconEle.attr("data-src"));
////                System.out.println(contentEle.html());
////            }
//
//
//            JSONObject jsonObject = JSONObject.parseObject(res);
//            JSONArray list = jsonObject.getJSONObject("d").getJSONArray("list");
//            list.forEach(o ->{
//                JSONObject json = JSONObject.parseObject(o.toString());
//                Topic topic = Topic.builder()
//                        .id(json.getString("objectId"))
//                        .topicName(json.getString("title"))
//                        .topicIcon(json.getString("icon"))
//                        .description(json.getString("description"))
//                        .msgCount(json.getInteger("msgsCount"))
//                        .followersCount(json.getInteger("followersCount"))
//                        .followed(json.getBoolean("followed"))
//                        .build();
//                topics.add(topic);
//
//            });
//        }else {
//            System.out.println("请求失败");
//        }
//        try {
//            response.close();
//            httpClient.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        return topics;
//    }
public static List<Topic> getTopics(){
    List<Topic> topics = new ArrayList<>();
    //目标地址
    String url = "https://short-msg-ms.juejin.im/v1/topicList?uid=5dc985d9f265da4d2b350fa9&device_id=1585185008570&token=eyJhY2Nlc3NfdG9rZW4iOiJpNlBwdHI1SE91dldtZmcyIiwicmVmcmVzaF90b2tlbiI6IjNTRjk2NEJLbE5VZ3o1azgiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&sortType=hot&page=0&pageSize=100";
    //创建get对象
    HttpGet get = new HttpGet(url);
    //创建context对象
    HttpClientContext context = HttpClientContext.create();
    //创建response对象
    CloseableHttpResponse response = null;
    try {
        response = httpClient.execute(get,context);
    } catch (IOException e) {
        e.printStackTrace();
    }
    // 测试输出状态行
    // System.out.println(response.getStatusLine());

    //如果请求成功，则获取网页源码
    if(response.getStatusLine().getStatusCode() == SUCCESS){
        //获取相应对象实体，并转换成UTF-8字符串
        HttpEntity entity = response.getEntity();
        String res = null;
        try {
            res = EntityUtils.toString(entity,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = JSONObject.parseObject(res);
        JSONArray list = jsonObject.getJSONObject("d").getJSONArray("list");
        list.forEach(o ->{
            JSONObject json = JSONObject.parseObject(o.toString());
            Topic topic = Topic.builder()
                    .id(json.getString("objectId"))
                    .topicName(json.getString("title"))
                    .topicIcon(json.getString("icon"))
                    .description(json.getString("description"))
                    .msgCount(json.getInteger("msgsCount"))
                    .followersCount(json.getInteger("followersCount"))
                    .followed(json.getBoolean("followed"))
                    .build();
            System.out.println(topic);
            topics.add(topic);
        });
    }else {
        System.out.println("请求失败");
    }
    try {
        response.close();
        httpClient.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return topics;
}

    public static void main(String[] args) throws IOException{
       System.out.println(getTopics());
    }
}
