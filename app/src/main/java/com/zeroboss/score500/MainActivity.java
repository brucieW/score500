package com.zeroboss.score500;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView newGame;
    Button resumeGame;
    SharedPreferences preferences;

    public static final String runningGames = "runningGames";
    public static final String gameId = "gameId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar = getSupportActionBar();
        bar.setDisplayShowHomeEnabled(true);
        bar.setIcon(R.mipmap.ic_launcher_foreground);

        newGame = findViewById(R.id.newGame);
        newGame.setOnClickListener(view -> {
        });

        preferences = getSharedPreferences(runningGames, Context.MODE_PRIVATE);
        resumeGame = findViewById(R.id.resumeGameButton);
        resumeGame.setText((preferences.contains(runningGames) ? R.string.resume_game : R.string.no_active_games));

        resumeGame.setOnClickListener(view -> {
            if (preferences.contains(runningGames)) {
                Toast.makeText(getApplicationContext(), "Resuming game", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "There are no saved games", Toast.LENGTH_LONG).show();
            }
        });

    }
}