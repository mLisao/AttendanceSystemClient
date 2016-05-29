package com.lisao.attendancesystemclient.api;

import com.lisao.attendancesystemclient.entity.Schedule;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by lisao on 2016/5/29.
 */
public interface ScheduleApi {
    /**
     * 获取所有的课表
     *
     * @return
     */
    @GET("schedule/all")
    Observable<List<Schedule>> getAllSchedule();

    /**
     * 添加一个课表
     *
     * @param body
     * @return
     */
    @POST("schedule/add")
    Observable<String> addSchedule(Body body);


    /**
     * 获取所有的课表
     *
     * @return
     */
    @GET("schedule/{id}")
    Observable<String> getSchedule(@Path("id") int id);

}
