package com.quiz.gwadaquiz;

import com.quiz.gwadaquiz.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class ResultQuiz extends Activity{
	
	
	private static TextView mScore;
	//private static int nbCorrect;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_quiz);
        
        Bundle var = this.getIntent().getExtras();
        
        String id1 = var.getString("maco");
        
        
        mScore = (TextView)findViewById(R.id.score);
		mScore.setText(id1);
    } 

}
