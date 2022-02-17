package com.example.miwok;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourcesId;
//    public WordAdapter(Activity context, ArrayList<Word> word){
//        super(context,0,word);
//    }
    public WordAdapter(Activity context, ArrayList<Word> word,int colorResourcesId){

        super(context,0,word);
        mColorResourcesId=colorResourcesId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Word word=getItem(position);
            View listItemView=convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        TextView miwokWord=(TextView) listItemView.findViewById(R.id.miwok_text_view);
        TextView defaultWord=(TextView) listItemView.findViewById(R.id.default_text_view);
        ImageView imageView=(ImageView) listItemView.findViewById(R.id.image);
        View textContainer=(View) listItemView.findViewById(R.id.container);
        int color= ContextCompat.getColor(getContext(),mColorResourcesId);
//        ImageButton btn=(ImageButton) listItemView.findViewById(R.id.media);
        textContainer.setBackgroundColor(color);
//        btn.setBackgroundColor(color);
        if(word.hasImage()){
        imageView.setImageResource(word.getImage());
        imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }
        miwokWord.setText(word.getMiwokTranslation());
        defaultWord.setText(word.getDefaultTranslation());
        return listItemView;
//        return super.getView(position, convertView, parent);
    }

}
