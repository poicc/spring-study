package com.soft1851.spring.web.spider;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import javax.net.ssl.SSLContext;
import java.util.List;

/**
 * @author CRQ
 */
public class JingDongSpider {
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
    /**
     * @throws Exception
     */
    public static void getItems() throws Exception{
        WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.waitForBackgroundJavaScript(600*1000);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        HtmlPage page = webClient.getPage("https://list.jd.com/list.html?cat=9987,653,655");
        List<HtmlDivision> divs = page.getByXPath("//*[@id=\"plist\"]/ul/li[1]/div/div[1]/a");
        for(HtmlDivision div:divs){
            DomNodeList<DomNode> childs = div.getChildNodes();
            String name = "";
            String price = "";
            String comments = "";
            for(DomNode dn:childs){
                NamedNodeMap map = dn.getAttributes();
                Node node = map.getNamedItem("class");
                if(node !=null){
                    String value = node.getNodeValue();
                    if(value.contains("p-name")){
                        name = dn.asText();
                    }else if(value.contains("p-price")){
                        price = dn.asText();
                    }else if(value.contains("p-commit")){
                        comments = dn.asText();
                    }
                }
            }
            System.out.println(name + "//"+price+"//"+comments);
        }
    }

    public static void main(String[] args) throws Exception {
        getItems();
    }
}
