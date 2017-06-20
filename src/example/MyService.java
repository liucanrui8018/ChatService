package example;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebService()
public class MyService {

    private static String CODE = null;




    @WebMethod
    public String createNeteaseId(String accid, String name, String token) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "https://api.netease.im/nimserver/user/create.action";
        HttpPost httpPost = new HttpPost(url);

        String appKey = "5a628343091bc917cc5b2c1375b48406";
        String appSecret = "02399282f3c0";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, CODE, curTime);//参考 计算CheckSum的java代码

        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", CODE);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("accid", accid));
        nvps.add(new BasicNameValuePair("name", name));
        nvps.add(new BasicNameValuePair("token", token));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        // 打印执行结果
        String result = EntityUtils.toString(response.getEntity(), "utf-8");

        // 打印执行结果
        System.out.println(result);
        return result;
    }
//
//    @WebMethod
//    public String createInData(String accid, String name, String token) throws Exception {
//
//
//    }



    @WebMethod
    public String update(String accid, String token) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "https://api.netease.im/nimserver/user/update.action";
        HttpPost httpPost = new HttpPost(url);

        String appKey = "5a628343091bc917cc5b2c1375b48406";
        String appSecret = "02399282f3c0";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, CODE, curTime);//参考 计算CheckSum的java代码

        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", CODE);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("accid", accid));
        nvps.add(new BasicNameValuePair("token", token));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        // 打印执行结果

        String result = EntityUtils.toString(response.getEntity(), "utf-8");

        // 打印执行结果
        System.out.println(result);
        return result;
    }

    @WebMethod
    public String refreshToken(String accid) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String url = "https://api.netease.im/nimserver/user/refreshToken.action";
        HttpPost httpPost = new HttpPost(url);

        String appKey = "5a628343091bc917cc5b2c1375b48406";
        String appSecret = "02399282f3c0";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, CODE, curTime);//参考 计算CheckSum的java代码

        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", CODE);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("accid", accid));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        // 打印执行结果

        String result = EntityUtils.toString(response.getEntity(), "utf-8");

        // 打印执行结果
        System.out.println(result);
        return result;
    }


    @WebMethod
    public String block(String accid, String needkick) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String url = "https://api.netease.im/nimserver/user/block.action";
        HttpPost httpPost = new HttpPost(url);

        String appKey = "5a628343091bc917cc5b2c1375b48406";
        String appSecret = "02399282f3c0";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, CODE, curTime);//参考 计算CheckSum的java代码

        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", CODE);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("accid", accid));
        nvps.add(new BasicNameValuePair("needkick", needkick));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        // 打印执行结果

        String result = EntityUtils.toString(response.getEntity(), "utf-8");

        // 打印执行结果
        System.out.println(result);
        return result;
    }

    @WebMethod
    public String unblock(String accid) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String url = "https://api.netease.im/nimserver/user/unblock.action";
        HttpPost httpPost = new HttpPost(url);

        String appKey = "5a628343091bc917cc5b2c1375b48406";
        String appSecret = "02399282f3c0";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, CODE, curTime);//参考 计算CheckSum的java代码

        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", CODE);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("accid", accid));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        // 打印执行结果

        String result = EntityUtils.toString(response.getEntity(), "utf-8");

        // 打印执行结果
        System.out.println(result);
        return result;
    }




    public static void main(String[] argv) {
        Object implementor = new MyService();
        String address = "http://localhost:9000/MyService";
        Endpoint.publish(address, implementor);
    }
}
