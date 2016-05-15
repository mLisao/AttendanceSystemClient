package com.lisao.attendancesystemclient.api;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lisao on 2016/5/15.
 */
public interface AccountApi {
    @POST("account/login")
    Observable<String> studentLogin(@Query("number") long number, @Query("password") String password);

    @POST("account/register")
    Observable<String> studentRegister(@Query("number") long number, @Query("name") String name, @Query("password") String password);

    @POST("account/teacher/login")
    Observable<String> teacherLogin(@Query("number") long number, @Query("password") String password);

    @POST("account/teacher/register")
    Observable<String> teacherRegister(@Query("number") long number, @Query("name") String name, @Query("password") String password);

}
