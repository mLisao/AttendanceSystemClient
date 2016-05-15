package com.lisao.attendancesystemclient.api;

import com.lisao.attendancesystemclient.config.ServerAddress;
import com.lisao.lisaolibrary.http.factory.ApiFactory;

public class ApiUtil {
    public static <T> T createApi(Class clz) {
        return ApiFactory.createRetrofitService(clz, ServerAddress.URL, null);
    }
}
