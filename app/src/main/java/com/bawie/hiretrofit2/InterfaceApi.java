package com.bawie.hiretrofit2;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by 张肖肖 on 2017/11/1.
 */

public interface InterfaceApi {

    //上传头像
    @POST("file/upload")
    @Multipart
    Call<ResponseBody> getUpload(@Part MultipartBody.Part uid,@Part MultipartBody.Part file);

}
