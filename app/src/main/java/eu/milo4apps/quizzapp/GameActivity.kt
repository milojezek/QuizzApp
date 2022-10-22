package eu.milo4apps.quizzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class GameActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgress: TextView
    private lateinit var tvQuestion: TextView
    private lateinit var ivImage: ImageView

    private lateinit var tvOptionOne: Button
    private lateinit var tvOptionTwo: Button
    private lateinit var tvOptionThree: Button
    private lateinit var tvOptionFour: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        progressBar = findViewById(R.id.progressbar)
        tvProgress = findViewById(R.id.textview_progress)
        tvQuestion = findViewById(R.id.textview_question)
        ivImage = findViewById(R.id.imageview_image)

        tvOptionOne = findViewById(R.id.button_option_one)
        tvOptionTwo = findViewById(R.id.button_option_two)
        tvOptionThree = findViewById(R.id.button_option_three)
        tvOptionFour = findViewById(R.id.button_option_four)

        val questionsList = Constants.getQuestions()
        Log.i("QuestionsList size is", "${questionsList.size}")

        for (i in questionsList) {
            Log.e("Questions", i.question)
        }

        var currentPosition = 1
        val currentQuestion: Question = questionsList[currentPosition - 1]

        ivImage.setImageResource(currentQuestion.image)
        progressBar.progress = currentPosition
        tvProgress.text = "${currentPosition}/${progressBar.max}"
        tvQuestion.text = currentQuestion.question

        tvOptionOne.text = currentQuestion.optionOne
        tvOptionTwo.text = currentQuestion.optionTwo
        tvOptionThree.text = currentQuestion.optionThree
        tvOptionFour.text = currentQuestion.optionFour
    }
}