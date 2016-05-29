package com.lisao.attendancesystemclient.api;

import com.lisao.attendancesystemclient.entity.Teacher;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by lisao on 2016/5/29.
 */
public interface TeacherApi {
    @GET("teacher/{id}")
    Observable<Teacher> getTeacher(@Path("id") int id);
}
