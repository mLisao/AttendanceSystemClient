package com.lisao.attendancesystemclient.api;

import com.lisao.attendancesystemclient.entity.Attend;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by lisao on 2016/5/28.
 */
public interface AttendApi {
    /**
     * 添加一条签到记录
     *
     * @param attend
     * @return
     */
    @POST("attend/add")
    Observable<String> addAttend(@Body Attend attend);
}
