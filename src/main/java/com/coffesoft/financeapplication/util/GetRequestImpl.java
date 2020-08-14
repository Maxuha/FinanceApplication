package com.coffesoft.financeapplication.util;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class GetRequestImpl implements GetRequest {
    private static final Logger logger = Logger.getLogger(GetRequestImpl.class);
    OkHttpClient client = new OkHttpClient();

    @Override
    public String getRequest(String url) {
        try {
            return get(url).body().string();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public String getWithHeaderRequest(String url, Map<String, String> headers) {
        try {
            return getWithHeader(url, headers).body().string();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return null;
    }


    private Response get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        return client.newCall(request).execute();
    }

    private Response getWithHeader(String url, Map<String, String> headers) throws IOException {
        Headers headerBuilder = Headers.of(headers);
        Request request = new Request.Builder()
                .url(url)
                .headers(headerBuilder)
                .build();
        return client.newCall(request).execute();
    }
}
