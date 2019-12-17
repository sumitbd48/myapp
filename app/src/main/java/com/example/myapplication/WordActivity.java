package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Adapter.CharactersAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WordActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editWord;
    TextView textView;
    Button btnOk, btnClear;
    SharedPreferences sharedPreferences;
    private RecyclerView recyclerView;
    private String[] words = {"irregardless", "barbecue", "starry", "abandoned", "ponga", "flipflops"};
    private int level = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editWord = findViewById(R.id.editWord);
        textView = findViewById(R.id.gameLevel);
        btnOk = findViewById(R.id.btnOk);
        btnClear = findViewById(R.id.btnClear);
        recyclerView = findViewById(R.id.recyclerView);


        SharedPreferences savedata = getSharedPreferences("Game", Context.MODE_PRIVATE);
        if (savedata.getInt("Level",0)==0) {
            showWord(level);

        }
        else {
            level=savedata.getInt("Level",0);
            showWord(level);
        }

        btnOk.setOnClickListener(this);
        btnClear.setOnClickListener(this);

    }

    private Character[] shuffleWords(int level){
        char[] word = words[level].toCharArray();


        ArrayList<Character> chars = new ArrayList<>(word.length);
        for(char c: word){
            chars.add(c);
        }

        Collections.shuffle(chars);
        Character[] shuffledWord = new Character[chars.size()];

        for(int i=0; i<shuffledWord.length; i++ ){
            shuffledWord[i] = chars.get(i);
        }
        return shuffledWord;
    }


    private void showWord(int i){
        CharactersAdapter charactersAdapter = new CharactersAdapter(WordActivity.this, shuffleWords(i),editWord);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setAdapter(charactersAdapter);
        recyclerView.setLayoutManager(layoutManager);
        textView.setText("GAME LEVEL : " + (i+1));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOk:
                String usr_word = editWord.getText().toString();
                if(level<words.length) {
                    if (usr_word.equals(words[level])) {
                        level++;
                        showWord(level);
                        sharedPreferences = getSharedPreferences("Game",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("Level",level);
                        editor.commit();
                        editWord.setText("");
                        Toast.makeText(WordActivity.this, "Next Level", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(WordActivity.this, "Wrong Word", Toast.LENGTH_SHORT).show();
                        editWord.setText("");
                        showWord(level);
                    }
                }
                else {
                    level=0;
                    Toast.makeText(WordActivity.this, "Game Over", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnClear:
                editWord.getText().clear();
                showWord(level);
                break;
        }

    }
}
