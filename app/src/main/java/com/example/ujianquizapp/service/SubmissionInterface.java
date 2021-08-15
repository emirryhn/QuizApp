package com.example.ujianquizapp.service;

import com.example.ujianquizapp.entity.PostBody;
import com.example.ujianquizapp.entity.SubmissionCode;
import com.example.ujianquizapp.entity.TokenCode;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SubmissionInterface {

//    @POST("submissions")
//    Call<PostBody> getToken(@Query("base64_encoded") String base64_encoded,
//                            @Query("fields") String fields);

    @POST("submissions")
    Call<PostBody> getToken(
            @Query("base64_encoded") String base64_encoded,
            @Query("field") String field,
            @Body PostBody postBody);

    @GET("submissions/")
    Call<SubmissionCode> getInfo(@Path("token") String token);
}
