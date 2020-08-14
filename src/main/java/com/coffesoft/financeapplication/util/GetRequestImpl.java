package com.coffesoft.financeapplication.util;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;

public class GetRequestImpl implements GetRequest {
    private static final Logger logger = Logger.getLogger(GetRequestImpl.class);

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
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        return client.newCall(request).execute();
    }

    private Response getWithHeader(String url, Map<String, String> headers) throws IOException {
        Headers headerBuilder = Headers.of(headers);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .headers(headerBuilder)
                .build();
        return client.newCall(request).execute();
    }
}
