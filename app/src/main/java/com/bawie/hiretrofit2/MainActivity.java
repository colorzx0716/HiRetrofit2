package com.bawie.hiretrofit2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //按钮的点击事件
    public void upload(View view) {
        try {

            File file = new File("data/data/ab.jpg");

            System.out.println("file路径 = " + file.getAbsolutePath());
            if(file!= null){
                Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).build();

                //动态代理生成实现类
                InterfaceApi interfaceApi = retrofit.create(InterfaceApi.class);
                RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);

                MultipartBody.Part uidPart = MultipartBody.Part.createFormData("uid","146");
                MultipartBody.Part filePart = MultipartBody.Part.createFormData("file",file.getName(),requestBody);

                Call<ResponseBody> bodyCall = interfaceApi.getUpload(uidPart,filePart);
                bodyCall.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        System.out.println("成功=======");
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        System.out.println("失败=======");
                    }
                });




            }
        }catch (Exception e){

        }
    }
}
