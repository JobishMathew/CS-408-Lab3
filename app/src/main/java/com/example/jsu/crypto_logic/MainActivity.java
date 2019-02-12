package com.example.jsu.crypto_logic;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import android.widget.*;

public class MainActivity extends AppCompatActivity {

    ArrayList secretWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        secretWords = new ArrayList(Arrays.asList("APPLE", "BANANA", "CHERRY","programming", "fish", "cairo", "arabs", "quraan", "sunnah",
                "editor", "photography", "artist", "software", "write", "read", "gaming",
                "lunch", "participate", "lunch", "dinner", "house", "books", "animals"));

       startGame();
    }

    public void startGame(){

        String sWord = shuffledWord();

        TextView outputShuffledWord = (TextView) findViewById(R.id.txtShuffledWord);
        outputShuffledWord.setText(sWord.toUpperCase().toString());

        EditText userEnter = (EditText) findViewById(R.id.txtEnterWord);
        char letter = userEnter.getText().charAt(0);

        TextView userWordDisplay = (TextView) findViewById(R.id.txtShowEnteredLetter);
        userWordDisplay.setText(letter);

    }

    public String shuffledWord(){
        int randomIndex = (int)(Math.random() * secretWords.size());
        String word = String.valueOf(secretWords.get(randomIndex));
        String shuffledWord = "";
        ArrayList<String> splitWord = new ArrayList(Arrays.asList(word.split("")));
        Collections.shuffle(splitWord);
        for (String c : splitWord)
            shuffledWord += c;

        return shuffledWord;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
