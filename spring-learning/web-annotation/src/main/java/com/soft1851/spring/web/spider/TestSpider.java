package com.soft1851.spring.web.spider;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * @author CRQ
 */
public class TestSpider {
    public static void main(String[] args) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()){
            HttpGet get = new HttpGet("http://juejin.im/topics");
            try (CloseableHttpResponse response1 = httpClient.execute(get)){
                System.out.println(response1.getStatusLine());
              //  HttpEntity entity1 = response1.getEntity();
               // EntityUtils.consume(entity1);
            }
        }
    }
}
