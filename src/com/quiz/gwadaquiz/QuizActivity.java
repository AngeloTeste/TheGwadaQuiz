package com.quiz.gwadaquiz;

import com.quiz.gwadaquiz.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {
	
	private static final String TAG ="QuizActivity"; //ajout de TAG contant
	private static final String KEY_INDEX ="index";
	private Button mTrueButton;
	private Button mFalseButton;
	private Button mNextButton;
	private TextView mQuestionTextView;
	private static TextView mScore;
	
	public static int nbCorrect  = 0 ;
	
	
	/* méthode pour le changement de question*/
	public void updateQuestion(){

		
		int question = mQuestionBank[mCurrentIndex] .getQuestion();
		/* Si on est à la 20 question aller dans ResultQuiz*/
		if (mCurrentIndex == 20){
            Intent intent = new Intent(QuizActivity.this, ResultQuiz.class);
            /*Garder la valeur de la bonne réponse*/
            String val = Integer.toString(nbCorrect);
            intent.putExtra("maco", val);
         
            startActivity(intent);
		}else{
			
		mQuestionTextView.setText(question);
		}
	}
    /*vérifier les réponses*/
	private void checkAnswer (boolean userPressTrue) {
		boolean answerIsTrue = mQuestionBank[mCurrentIndex] .isTrueQuestion();
		int messageResId=0;
		int answer= 0;
		if (userPressTrue == answerIsTrue){
			nbCorrect++ ;//donne le nombre de bonne réponse
			messageResId = R.string.correct_toast;
			
		
		} else {
			messageResId = R.string.incorrect_toast;
		
			
		}
		
		mScore = (TextView)findViewById(R.id.score);
		mScore.setText(Integer.toString(nbCorrect));
		answer= mQuestionBank[mCurrentIndex].getAnswer();
		Toast.makeText(this, messageResId, Toast.LENGTH_SHORT) .show();
		/*afin de doubler le temps de réponse on met une boucle 
		mais comme ne fonctionne par j'ai doublé le toast des réponses .*/
		
		
		Toast.makeText(this, answer, Toast.LENGTH_LONG) .show();
		Toast.makeText(this, answer, Toast.LENGTH_LONG) .show();
		
		
		
	}
	/* afin de faire de ne pas un tas de ligne comme en bas création d'un tableau 
	 * mais il faudra nommée les questions et les réponses avec des chiffres
	 * à faire dès que j'aurais plus de question.
	int numero_question;
	String id_question = "question" + numero_question;
    int q = res.getIdentifier(id_question, "string", "com.");
    String q2 = getResources().getString(q);
    */
	/*tableau indiquant une question si elle est vraie ou fausse et la réponse
	 * j'ai décidé de le faire dans cette ordre, un ordre aléatoire est à prévoir*/
	private TrueFalse[] mQuestionBank = new TrueFalse[] {
			/*for (n=0,n++,n<lenghtTru nuString id_question="q" + numero_question;
			 * String q = getResources().getString(.getIdentifier(id_question, "string","com.quiz.gwadaquiz"
			 * new TrueFalse( q,a,b,c,r,)*/
			
			new TrueFalse(R.string.question_km, false, R.string.answer_km),
			new TrueFalse(R.string.question_code, false, R.string.answer_code),
			new TrueFalse(R.string.question_superficie, true, R.string.answer_superficie),
			new TrueFalse(R.string.question_volcan, true, R.string.answer_volcan),
			new TrueFalse(R.string.question_saison, false, R.string.answer_saison),
			new TrueFalse(R.string.question_karukera, false, R.string.answer_karukera),
			new TrueFalse(R.string.question_1794, false, R.string.answer_1794),
			new TrueFalse(R.string.question_britannique, true, R.string.answer_britannique),
			new TrueFalse(R.string.question_suede, true, R.string.answer_suede),
			new TrueFalse(R.string.question_counia, true, R.string.answer_counia),
			new TrueFalse(R.string.question_delgres, false, R.string.answer_delgre),
			new TrueFalse(R.string.question_indien, true, R.string.answer_indien),
			new TrueFalse(R.string.question_14fevrier, true, R.string.answer_14fevrier),
			new TrueFalse(R.string.question_departement, false, R.string.answer_departement),
			new TrueFalse(R.string.question_lkp, false, R.string.answer_lkp),
			new TrueFalse(R.string.question_population, true, R.string.answer_population),
			new TrueFalse(R.string.question_composition, true, R.string.answer_composition),
			new TrueFalse(R.string.question_blanc, false, R.string.answer_blanc),
			new TrueFalse(R.string.question_farce, false, R.string.answer_farce),
			new TrueFalse(R.string.question_dom, true, R.string.answer_dom),
			new TrueFalse(R.string.question_dom, true, R.string.answer_dom),
	};
	
		
	
	private int mCurrentIndex = 0;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate(Bundle) called");//onCreated appel Log.d pour enregistre le message
		setContentView(R.layout.activity_quiz);
		//On fait appel à l'interface
		
		mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
		//déclare à la zone de question
	if (savedInstanceState != null) {
		mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
	}
		updateQuestion();//pour voir la première question 
		
		
		
		
		
		
		mTrueButton = (Button)findViewById(R.id.true_button);
		mTrueButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				checkAnswer(true);
			
				
				mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
				//passer à la prochaine question
				updateQuestion();
				
			}
		});
		mFalseButton = (Button)findViewById(R.id.false_button);
		mFalseButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				checkAnswer(false);
			
				mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
				updateQuestion();
			}
		});
		
		mNextButton = (Button)findViewById(R.id.next_button);
		mNextButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
				updateQuestion();
			}
		});
		
		
			
		
	}// End of onCreate(Bundle)
	//Pour garder la valeur du mCurrentIndex lors de la rotation
	@Override
	public void onSaveInstanceState (Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		Log.i(TAG, "onSaveInstanceState");
		savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
	}
	
	@Override
	public void onStart(){
		super.onStart();
		Log.d(TAG, "onStart() called");
	}
	
	@Override
	public void onPause(){
		super.onPause();
		Log.d(TAG, "onPause() called");
	}
	@Override
	public void onResume(){
		super.onResume();
		Log.d(TAG, "onResume() called");
	}
	
	@Override
	public void onStop(){
		super.onStop();
		Log.d(TAG, "onStop() called");
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy() called");
	}
}
