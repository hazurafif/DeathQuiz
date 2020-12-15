package com.example.deathquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class MainActivity extends AppCompatActivity {

    private TextView title;
    private Button start;
    ImageButton profile;

    GoogleSignInClient mGoogleSignInClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        
        title = findViewById(R.id.main_start);
        start = findViewById(R.id.ma_startB);
        profile = findViewById(R.id.imageButton);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccountInformation();
            }
        });

        Typeface typeface = ResourcesCompat.getFont(this,R.font.mainfont);
        Typeface typeface1 = ResourcesCompat.getFont(this,R.font.gotham);
        title.setTypeface(typeface);
        start.setTypeface(typeface1);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CategoryActivityAccount.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {

    }

    private void openAccountInformation() {
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(MainActivity.this);
        if (acct != null) {
            startActivity(new Intent(MainActivity.this, AccountInformation.class));
        }
        else{
            startActivity(new Intent(MainActivity.this, AccountInformationFirebase.class));
        }
    }
}