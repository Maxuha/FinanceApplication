package com.coffesoft.financeapplication.util;

import java.util.Map;

public interface PostRequest {
    Object postWithJsonRequest(String url, String json);
}
