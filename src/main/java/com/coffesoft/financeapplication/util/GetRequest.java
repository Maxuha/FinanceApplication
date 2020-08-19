package com.coffesoft.financeapplication.util;
import java.util.Map;

public interface GetRequest {
    String getRequest(String url);
    String getWithHeaderRequest(String url, Map<String, String> headers);
}
