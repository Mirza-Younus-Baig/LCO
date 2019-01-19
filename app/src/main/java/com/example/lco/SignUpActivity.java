package com.example.lco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private TextView mSignIn;
    private Button mSignUp;
    private EditText mFullName, mEmail, mPhone, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mSignIn = findViewById(R.id.signIn);
        mSignUp = findViewById(R.id.sign_up_button);
        mFullName = findViewById(R.id.sign_up_name);
        mEmail = findViewById(R.id.sign_up_email);
        mPhone = findViewById(R.id.sign_up_phone);
        mPassword = findViewById(R.id.sign_up_password);

        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomToast("Successful Sign Up");
                mFullName.setText("");
                mEmail.setText("");
                mPhone.setText("");
                mPassword.setText("");
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showCustomToast(String string) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_root));

        TextView toastText = layout.findViewById(R.id.toast_text);
        toastText.setText(string);

        ImageView toastImage = layout.findViewById(R.id.toast_image);
        toastImage.setImageResource(R.drawable.ic_code);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
