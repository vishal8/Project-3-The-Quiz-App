package com.example.android.project_3;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/*This quiz app consists of 6 questions (4 radio button choices, 1 multiple choice question (checkboxes), and
a edit text question)*/
public class MainActivity extends AppCompatActivity {

/* declaring variables to be used */
    int score = 0;
    static final int numQuestions = 6;

    RadioButton question1RadioButton;
    RadioButton question2RadioButton;
    RadioButton question3RadioButton;
    RadioButton question4RadioButton;
    CheckBox Abc_1;
    CheckBox OneAbc;
    CheckBox $while;
    CheckBox wrong1abc;
    CheckBox wrongfinal;
    EditText question6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/* assigning methods for all the 6 questions*/
        question1RadioButton = findViewById(R.id.q1r4);
        question2RadioButton = findViewById(R.id.q2r1);
        question3RadioButton = findViewById(R.id.q3r3);
        question4RadioButton = findViewById(R.id.q4r2);
        Abc_1 = findViewById(R.id.q5c2);
        OneAbc = findViewById(R.id.q5c3);
        $while = findViewById(R.id.q5c5);
        wrong1abc = findViewById(R.id.q5c1);
        wrongfinal = findViewById(R.id.q5c4);
        question6 = findViewById(R.id.q6);

    }

    public void submitAnswers(View view) {
        Question1();
        Question2();
        Question3();
        Question4();
        Question5();
        Question6();

        displayScore();
    }
/* Radio button question: Checks if the right answer is selected for question1 which is q1r4 id */
    private void Question1() {
        if (question1RadioButton.isChecked()) {
            score += 1;
        }
    }

/* Radio button question: Checks if the right answer is selected for question2 which is q2r1 id */
    private void Question2() {
        if (question2RadioButton.isChecked()) {
            score += 1;
        }
    }

    /* Radio button question: Checks if the right answer is selected for question3 which is q3r3 id */
    private void Question3() {
        if (question3RadioButton.isChecked()) {
            score += 1;
        }
    }

    /* Radio button question: Checks if the right answer is selected for question4 which is q4r2 id */
    private void Question4() {
        if (question4RadioButton.isChecked()) {
            score += 1;
        }
    }

    /* Check box question: Checks if the right choices are selected for question5 which are choices 2,3 & 5
    * and wrong choices are not selected being 1 & 4 */
    private void Question5() {
        if (Abc_1.isChecked() && OneAbc.isChecked() && $while.isChecked()
                && !wrong1abc.isChecked() && !wrongfinal.isChecked()) {
            score += 1;
        }
    }

    /* Edit text question: Checks if the string matches 'This is else statement' which will be the only right answer */
    private void Question6() {
        String checkAnswer6 = question6.getText().toString();

        if (checkAnswer6.equals("This is else statement")) {
            score += 1;
        }
    }

    private void displayScore() {
        Resources res = getResources();
        String msg = "";

        if (score == numQuestions) {
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
            msg = res.getString(R.string.toast_correct);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        } else if (score == 0) {
            msg = res.getString(R.string.toast_wrong);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        } else {
            msg = "You got " + score + " out of " + numQuestions + " questions right.";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }

        score = 0;
    }
}