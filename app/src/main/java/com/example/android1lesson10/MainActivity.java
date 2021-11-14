package com.example.android1lesson10;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextInputEditText userName, password;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);
        button = findViewById(R.id.button);
        userName = findViewById(R.id.loginET);
        password = findViewById(R.id.passwordET);

        goToSecondScreen();

        String url = "https://i.pinimg.com/474x/23/ab/a6/23aba60b66ef08174bb7455c4a8a2d2f.jpg";

        Glide.with(this).load(url).into(imageView);



        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void afterTextChanged(Editable s) {
                if (userName.getText().toString().length() > 0) {
                    button.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.color_black));

                } else {
                    button.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.color_grey));
                }
            }
        });
    }

    private void goToSecondScreen() {
        button.setOnClickListener(v -> {
            if (password.getText().toString().length() >=6 && userName.getText().toString().length() > 0) {

                button.setOnClickListener(View -> {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                });

            } else {
                password.setError(getString(R.string.error_password));
                userName.setError(getString(R.string.error_user_name));
            }
        });
    }


}