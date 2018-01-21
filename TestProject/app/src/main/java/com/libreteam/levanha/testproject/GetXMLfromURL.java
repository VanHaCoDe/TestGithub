package com.libreteam.levanha.testproject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import retrofit2.http.HTTP;

/**
 * Created by Admin on 8/23/2017.
 */

public class GetXMLfromURL {
    private String getXmlFromUrl(String urlString) {
        String xml = null;
        try {
            // defaultHttpClient lấy toàn bộ dữ liệu trong http đổ vào 1 chuỗi String
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(urlString);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            xml = EntityUtils.toString(httpEntity, HTTP.UTF_8);
            // set UTF-8 cho ra chữ unikey
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // return XML
        return xml;
    }
}
