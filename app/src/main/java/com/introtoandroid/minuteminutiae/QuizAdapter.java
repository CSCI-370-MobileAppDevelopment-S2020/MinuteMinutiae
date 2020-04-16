package com.introtoandroid.minuteminutiae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class QuizAdapter extends BaseAdapter {
    final Context context;
    ArrayList<Quiz> quizList;

    public QuizAdapter(Context context, ArrayList<Quiz> quizList){
        this.context = context;
        this.quizList = quizList;
    }

    @Override
    public int getCount() {
        return quizList.size();
    }

    @Override
    public Object getItem(int position) {
        return quizList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Quiz quiz = quizList.get(position);

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.linearlayout_quiz, null);
            System.out.println("Made it here");
        }

        //final ImageView quizIcon = (ImageView) convertView.findViewById(R.id.quiz_icon);
        final TextView quizName = (TextView) convertView.findViewById(R.id.quiz_name);

        quizName.setText(quiz.getName());

        return convertView;
    }
}
