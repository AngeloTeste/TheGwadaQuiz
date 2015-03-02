package com.quiz.gwadaquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/* Activity pour commencer l'application*/


public class FirstActivity extends Activity {
	private Button mBeginButton;
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		
		mBeginButton = (Button)findViewById(R.id.begin_button);
		mBeginButton.setOnClickListener(new View.OnClickListener(){
			//clic pour commencez le Gwada Quiz.
			@Override
			public void onClick(View v) {
				Intent i= new Intent (FirstActivity.this, QuizActivity.class);
				
				startActivity(i);
				
			}
		});

	}

}
