package com.example.ujianquizapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ujianquizapp.entity.PostBody;
import com.example.ujianquizapp.entity.TokenCode;
import com.example.ujianquizapp.service.ApiClient;
import com.example.ujianquizapp.service.SubmissionInterface;

import android.util.Base64;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionDetail extends AppCompatActivity {

    Button btnSubmit;
    EditText editAnswer;
    PostBody postBody;
    TokenCode tokenCode;

    SubmissionInterface sInterface = new ApiClient().getRetrofit().create(SubmissionInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);
        btnSubmit = findViewById(R.id.btn_submit);
        editAnswer = findViewById(R.id.edit_answer);

       editAnswer.setText("public class Main {\n" +
               "    public static void main(String[] args) {\n" +
               "      for(int x =0 ; x <5 ;x ++){\n" +
               "           for (int y=0; y <5; y++){\n" +
               "            System.out.println(\"*\");\n" +
               "           }\n" +
               "        }\n" +
               "    }\n" +
               "}");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest();
            }
        });

    }

    private static String token;

    private void sendRequest() {
        PostBody postBody = new PostBody(62,"cHVibGljIGNsYXNzIE1haW4gewogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgewogICAgICBmb3IoaW50IHggPTAgOyB4IDw1IDt4ICsrKXsKICAgICAgICAgICBmb3IgKGludCB5PTA7IHkgPDU7IHkrKyl7CiAgICAgICAgICAgIFN5c3RlbS5vdXQucHJpbnRsbigiKiIpOwogICAgICAgICAgIH0KICAgICAgICB9CiAgICB9Cn0=",
                "");
        String encode = Base64.encodeToString(editAnswer.getText().toString().getBytes(), Base64.DEFAULT);
        Call<PostBody> call = sInterface.getToken("true","*", postBody);
        call.enqueue(new Callback<PostBody>() {
            @Override
            public void onResponse(Call<PostBody> call, Response<PostBody> response) {

                if(response.isSuccessful()){
                    postBody.setSourceCode(encode);
                    Toast.makeText(QuestionDetail.this, tokenCode.getToken(), Toast.LENGTH_SHORT).show();
                    token = tokenCode.getToken();
                    Intent i = new Intent(getApplicationContext(),SuccessPage.class);
                    startActivity(i);
                }
            }

            @Override
            public void onFailure(Call<PostBody> call, Throwable t) {
                Toast.makeText(QuestionDetail.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}