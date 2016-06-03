package com.lisao.attendancesystemclient.api;

import com.lisao.attendancesystemclient.entity.Attend;
import com.lisao.attendancesystemclient.entity.MyAttend;
import com.lisao.attendancesystemclient.entity.Student;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
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

    /**
     * 获取我的签到记录
     *
     * @param id
     * @return
     */
    @GET("attend/my/{id}")
    Observable<List<MyAttend>> getMyAttend(@Path("id") long id);


    @GET("attend/{id}")
    Observable<List<Student>> getAttendStudeng(@Path("id") long id);
}
