package com.example.kwangho.prac_retrofit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    Button button = (Button) findViewById(R.id.button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Super fast hello world", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
                Call<List<Contributor>> call = gitHubService.repoContributors("square", "retrofit");
                String result = call.execute().body().toString();
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(result);
            }
        });
    }
}
