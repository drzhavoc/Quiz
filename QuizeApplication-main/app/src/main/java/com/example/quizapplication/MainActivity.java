package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] questions ={
            "What is 2+3 ?",
            "What is the Capital of Bangladesh?",

    };
    private String[][] options ={
            {"3","4","5","6"} ,
            {"Dhaka","New Delhi","Chittagong","Paris"}
    };
    private int[] correctAnswers = {2,0};
    private int currentQuestionIndex = 0;
    private TextView  questionView,scoreView;
    private RadioGroup optionsRadioGroup;
    private Button submitBtn;
    private int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionView = findViewById(R.id.questionView);
        scoreView = findViewById(R.id.scoreView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        submitBtn = findViewById(R.id.submitBtn);
        displayQuestion(currentQuestionIndex);


        submitBtn.setOnClickListener(v -> checkAnswer());
    }


        //function here!
        private void displayQuestion(int questionIndex){
            questionView.setText(questions[questionIndex]);
            scoreView.setText(String.valueOf(score));
            optionsRadioGroup.removeAllViews();

            for(int i = 0;i<options[questionIndex].length;i++)
            {
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(options[questionIndex][i]);
                optionsRadioGroup.addView(radioButton);
            }
        }
        private void checkAnswer(){
        int selectedOption = optionsRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedOption);
        int selectedAnswerIndex = optionsRadioGroup.indexOfChild(selectedRadioButton);
        if(selectedOption != -1)
        {
            if(selectedAnswerIndex == correctAnswers[currentQuestionIndex]){
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                score++;
                scoreView.setText(String.valueOf(score));


            }
            else {
                Toast.makeText(this,"Incorrect!",Toast.LENGTH_SHORT).show();
            }
            currentQuestionIndex++;

            if(currentQuestionIndex<questions.length){
                displayQuestion(currentQuestionIndex);
            }
            else {
                Toast.makeText(this, "Quiz Complete!", Toast.LENGTH_SHORT).show();
                displayQuestion(0);
            }
        }
        else{
            Toast.makeText(this, "Please select an answer.", Toast.LENGTH_SHORT).show();
            }

    }

}