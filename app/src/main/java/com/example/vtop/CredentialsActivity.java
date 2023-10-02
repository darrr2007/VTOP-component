package com.example.vtop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CredentialsActivity extends AppCompatActivity {

    private static final int NUM_ROWS = 3;
    private static final int NUM_COLUMNS = 5;

    TextView gmail,teams;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credentials2);

        gmail = findViewById(R.id.gmail_text_view);
        teams = findViewById(R.id.teams_text_view);

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Gmail
                String gmailUrl = "https://www.gmail.com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(gmailUrl));
                startActivity(intent);
            }
        });

        teams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Microsoft Teams
                String teamsUrl = "https://www.microsoft.com/teams";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(teamsUrl));
                startActivity(intent);
            }
        });



    }
}