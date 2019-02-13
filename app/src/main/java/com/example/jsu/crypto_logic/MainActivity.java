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

    ArrayList<String> secretWords;
    ArrayList<String> splitWord;
    private String guessedWord, word ,letter;
    private int index;
    private int incorrectCount;


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

        secretWords = new ArrayList(Arrays.asList("APPLE", "BANANA", "CHERRY", "FISH",
                "EDITOR", "ARTISIT", "SOFTWARE", "WRITE", "READ", "GAMING",
                "LUNCH", "DINNER", "HOUSE", "BOOKS", "ANIMALS"));


        guessedWord = "";
        word = "";
        letter = "";
        index = 0;
        incorrectCount = 0;

        shuffle();

    }

    public void shuffle(){
        int randomIndex = (int)(Math.random() * secretWords.size());
        String shuffledWord = "";
        word = String.valueOf(secretWords.get(randomIndex));
        splitWord = new ArrayList(Arrays.asList(word.split("")));
        Collections.shuffle(splitWord);
        for (String c : splitWord)
            shuffledWord += c;

        TextView outputShuffledWord = (TextView) findViewById(R.id.txtShuffledWord);
        outputShuffledWord.setText(shuffledWord.toUpperCase());

    }

    public void buttonGuuessClicked(View V){
       EditText userEnter = (EditText) findViewById(R.id.txtEnterWord);
       letter = userEnter.getText().toString().toUpperCase();
       guess();
       userEnter.setText("");
    }

    public void guess(){
        TextView outputGussedLetter = (TextView) findViewById(R.id.txtShowEnteredLetter);
        TextView outputIncorrect = (TextView) findViewById(R.id.textIncorrectGuess);

        if(letter.charAt(0) == word.charAt(index)){
            guessedWord = guessedWord+letter;
            outputGussedLetter.setText(guessedWord.toUpperCase());
            index += 1;
        }
        else{
            incorrectCount += 1;
            outputIncorrect.setText("Incorrect guesses: " + incorrectCount);
        }
        checkWin();
    }

    public void checkWin(){
        TextView outputFinal = (TextView) findViewById(R.id.txtShowFinalOutput);
        Button guessButton = (Button) findViewById(R.id.btnEnter);
        if(guessedWord.equalsIgnoreCase(word)){
            if(incorrectCount == 0) {
                outputFinal.setText("Congratulations! You have guessed the word without mistakes!");
                guessButton.setEnabled(false);
            }
            else{
                outputFinal.setText("You have guessed the word in "+ incorrectCount + " tries!");
                guessButton.setEnabled(false);
            }

        }
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
