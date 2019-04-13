package com.hewerton.bioquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int checkQuestionOne() {
        RadioButton answer = findViewById(R.id.question_one_opt2);
        answer.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        if (answer.isChecked())
            return 1;
        return 0;
    }

    private int checkQuestionTwo() {
        RadioButton answer = findViewById(R.id.question_two_opt4);
        answer.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        if (answer.isChecked())
            return 1;
        return 0;
    }

    private int checkQuestionThree() {
        EditText editText = findViewById(R.id.question_three_answer);
        String answer = editText.getText().toString().toLowerCase();
        String correctAnswer = getResources().getString(R.string.question_three_correct_answer).toLowerCase();
        if (answer.equals(correctAnswer)) {
            editText.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            return 1;
        } else {
            editText.setTextColor(getResources().getColor(R.color.colorWrongAnswer));
            //editText.setText(correctAnswer);
            return 0;
        }
    }

    private int checkQuestionFour() {
        EditText editText = findViewById(R.id.question_four_answer);
        String answer = editText.getText().toString().toLowerCase();
        String correctAnswer = getResources().getString(R.string.question_four_correct_answer).toLowerCase();
        if (answer.equals(correctAnswer)) {
            editText.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            return 1;
        } else {
            editText.setTextColor(getResources().getColor(R.color.colorWrongAnswer));
            //editText.setText(correctAnswer);
            return 0;
        }
    }

    private int checkQuestionFive() {
        CheckBox opt1 = findViewById(R.id.question_five_opt1);
        CheckBox opt2 = findViewById(R.id.question_five_opt2);
        CheckBox opt3 = findViewById(R.id.question_five_opt3);
        CheckBox opt4 = findViewById(R.id.question_five_opt4);
        CheckBox opt5 = findViewById(R.id.question_five_opt5);

        boolean correctAnswers = opt3.isChecked() && opt4.isChecked();
        boolean wrongAnswers = opt1.isChecked() || opt2.isChecked() || opt5.isChecked();

        opt3.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        opt4.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

        opt1.setTextColor(getResources().getColor(R.color.colorWrongAnswer));
        opt2.setTextColor(getResources().getColor(R.color.colorWrongAnswer));
        opt5.setTextColor(getResources().getColor(R.color.colorWrongAnswer));

        if (correctAnswers && !wrongAnswers)
            return 1;

        return 0;
    }

    private int checkQuestionSix() {

            CheckBox opt1 = findViewById(R.id.question_six_opt1);
            CheckBox opt2 = findViewById(R.id.question_six_opt2);
            CheckBox opt3 = findViewById(R.id.question_six_opt3);
            CheckBox opt4 = findViewById(R.id.question_six_opt4);
            CheckBox opt5 = findViewById(R.id.question_six_opt5);
            CheckBox opt6 = findViewById(R.id.question_six_opt6);

            boolean correctAnswers = opt1.isChecked() && opt2.isChecked() && opt5.isChecked();
            boolean wrongAnswers = opt3.isChecked() || opt4.isChecked() || opt6.isChecked();

            opt1.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            opt2.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            opt5.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            opt3.setTextColor(getResources().getColor(R.color.colorWrongAnswer));
            opt4.setTextColor(getResources().getColor(R.color.colorWrongAnswer));
            opt6.setTextColor(getResources().getColor(R.color.colorWrongAnswer));

            if (correctAnswers && !wrongAnswers)
                return 1;

            return 0;
    }


    public void checkAnswers(View view) {

        int correctAnswers = 0;
        correctAnswers += this.checkQuestionOne();
        correctAnswers += this.checkQuestionTwo();
        correctAnswers += this.checkQuestionThree();
        correctAnswers += this.checkQuestionFour();
        correctAnswers += this.checkQuestionFive();
        correctAnswers += this.checkQuestionSix();

        String msg = "";
        if (correctAnswers != 1) {
            msg = getResources().getString(R.string.toast_msg_multiple_question, correctAnswers);
        } else {
            msg = getResources().getString(R.string.toast_msg_one_question, correctAnswers);
        }
        Toast info = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        info.show();
    }
}
