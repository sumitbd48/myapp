package com.example.myapplication.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.LinearLayout;
import com.example.myapplication.R;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.CharactersHolder> {

    Context context;
    private Character[] characterList;
    EditText word;

    public CharactersAdapter(Context context, Character[] characterList, EditText word){
        this.context = context;
        this.characterList = characterList;
        this.word = word;
    }

    @NonNull
    @Override
    public CharactersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_layout,parent,false);
        CharactersHolder charHolder = new CharactersHolder(view);
        return charHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return characterList.length;
    }

    public class CharactersHolder extends RecyclerView.ViewHolder{

        LinearLayout designLayout;
        TextView tvCharacter;

        public CharactersHolder(@NonNull View itemView) {
            super(itemView);
            designLayout = itemView.findViewById(R.id.design);
            tvCharacter = itemView.findViewById(R.id.textCharacter);
        }
    }
}
