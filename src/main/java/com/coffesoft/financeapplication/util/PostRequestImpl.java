package com.coffesoft.financeapplication.util;

import okhttp3.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Objects;

@Component
public class PostRequestImpl implements PostRequest {
    private static final Logger logger = Logger.getLogger(PostRequestImpl.class);
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();

    @Override
    public String postWithJsonRequest(String url, String json) {
        try {
            return Objects.requireNonNull(postWithJson(url, json).body()).string();
        } catch (IOException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    private Response postWithJson(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return client.newCall(request).execute();
    }
}
