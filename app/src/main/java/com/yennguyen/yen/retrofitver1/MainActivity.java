package com.yennguyen.yen.retrofitver1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yennguyen.yen.retrofitver1.data.model.Post;
import com.yennguyen.yen.retrofitver1.data.remote.APIService;
import com.yennguyen.yen.retrofitver1.data.remote.APIUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTextViewTitle;
    private TextView mTextViewResult;
    private EditText mEditTextInput;
    private Button mButtonSubmit;
    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        mAPIService = APIUtils.getService();
        mButtonSubmit.setOnClickListener(this);
    }
    private void initComponent(){
        mTextViewTitle = findViewById(R.id.text_title);
        mEditTextInput = findViewById(R.id.edit_input);
        mButtonSubmit = findViewById(R.id.button_submit);
        mTextViewResult = findViewById(R.id.text_result);
    }

    @Override
    public void onClick(View v) {
        String input = mEditTextInput.getText().toString();
        if(input == null) return;
        if(!TextUtils.isEmpty(input)){
            sendPost(input);
        }
    }

    private void sendPost(String input) {
        mAPIService.savePost(input, null, 1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    mTextViewResult.setText(response.toString().trim());
                    //Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d("failure", t.getMessage());
            }
        });
    }
}
