package com.quiz.gwadaquiz;

public class TrueFalse {

	private int mQuestion;
	private int mAnswer ;
	private boolean mTrueQuestion;
	
	public TrueFalse(int question, boolean trueQuestion, int answer){
		//public TrueFalse( int question, int a, int b, int c, int r, int e)
		mQuestion = question;
		mTrueQuestion = trueQuestion;
		mAnswer = answer ;
	}

	public int getQuestion() {
		return mQuestion;
	}

	public void setQuestion(int question) {
		mQuestion = question;
	}

	public boolean isTrueQuestion() {
		return mTrueQuestion;
	}

	public void setTrueQuestion(boolean trueQuestion) {
		mTrueQuestion = trueQuestion;
	}

	public int getAnswer() {
		return mAnswer;
	}

	public void setAnswer(int answer) {
		mAnswer = answer;
	}
}
