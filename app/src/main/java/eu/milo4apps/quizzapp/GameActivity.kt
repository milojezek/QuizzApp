package eu.milo4apps.quizzapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class GameActivity : AppCompatActivity(), View.OnClickListener {

    private var currentPosition: Int = 1
    private lateinit var questionsList: MutableList<Question>

    private lateinit var currentOptionsList: MutableList<Button>
    private var selectedOptionPosition: Int = 0

    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgress: TextView
    private lateinit var tvQuestion: TextView
    private lateinit var ivImage: ImageView

    private lateinit var btnOptionOne: Button
    private lateinit var btnOptionTwo: Button
    private lateinit var btnOptionThree: Button
    private lateinit var btnOptionFour: Button

    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        progressBar = findViewById(R.id.progressbar)
        tvProgress = findViewById(R.id.textview_progress)
        tvQuestion = findViewById(R.id.textview_question)
        ivImage = findViewById(R.id.imageview_image)

        btnOptionOne = findViewById(R.id.button_option_one)
        btnOptionTwo = findViewById(R.id.button_option_two)
        btnOptionThree = findViewById(R.id.button_option_three)
        btnOptionFour = findViewById(R.id.button_option_four)
        btnSubmit = findViewById(R.id.button_submit)

        btnOptionOne.setOnClickListener(this)
        btnOptionTwo.setOnClickListener(this)
        btnOptionThree.setOnClickListener(this)
        btnOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

        questionsList = Constants.getQuestions()
        setQuestion()
    }

    private fun setQuestion() {
        val currentQuestion: Question = questionsList[currentPosition - 1]

        ivImage.setImageResource(currentQuestion.image)
        progressBar.progress = currentPosition
        tvProgress.text = "${currentPosition}/${progressBar.max}"
        tvQuestion.text = currentQuestion.question

        btnOptionOne.text = currentQuestion.optionOne
        btnOptionTwo.text = currentQuestion.optionTwo
        btnOptionThree.text = currentQuestion.optionThree
        btnOptionFour.text = currentQuestion.optionFour

        currentOptionsList = mutableListOf(btnOptionOne, btnOptionTwo, btnOptionThree, btnOptionFour)

        defaultOptionsView()

        if (currentPosition == questionsList.size) {
            btnSubmit.text = "Finish"
        } else {
            btnSubmit.text = "Submit"
        }
    }

    private fun defaultOptionsView() {
        for (option in currentOptionsList) {
            option.setBackgroundColor(Color.parseColor("#ededed"))
        }

        turnOnButtons(currentOptionsList)
    }

    private fun chooseOption(optionButton: Button, selectedOptionNum: Int) {
        defaultOptionsView()
        selectedOptionPosition = selectedOptionNum
        optionButton.setBackgroundColor(Color.parseColor("#78909c"))
    }

    override fun onClick(btn: View) {
        when (btn.id) {
            R.id.button_option_one -> chooseOption(btnOptionOne, 1)
            R.id.button_option_two -> chooseOption(btnOptionTwo, 2)
            R.id.button_option_three -> chooseOption(btnOptionThree, 3)
            R.id.button_option_four -> chooseOption(btnOptionFour, 4)
            R.id.button_submit -> {
                if (selectedOptionPosition == 0) {
                    currentPosition++
                    if (currentPosition <= questionsList.size) {
                        setQuestion()
                    } else {
                        Toast.makeText(this, "You made it to the end", Toast.LENGTH_LONG).show()
                    }
                } else {
                    val question = questionsList.get(currentPosition - 1)
                    if (question.correctAnswer != selectedOptionPosition) {
                        highlightAnswer(selectedOptionPosition, false)
                        highlightAnswer(question.correctAnswer, true)
                        turnOffButtons(currentOptionsList)
                    } else {
                        highlightAnswer(selectedOptionPosition, true)
                        turnOffButtons(currentOptionsList)
                    }

                    if (currentPosition == questionsList.size) {
                        btnSubmit.text = "FINISH"
                    } else {
                        btnSubmit.text = "GO TO NEXT QUESTION"
                    }

                    selectedOptionPosition = 0
                }
            }
        }
    }

    private fun turnOffButtons(currentLs: MutableList<Button>) {
        for (b in currentLs) {
            b.isClickable = false
        }
    }

    private fun turnOnButtons(currentLs: MutableList<Button>) {
        for (b in currentLs) {
            b.isClickable = true
        }
    }

    private fun highlightAnswer(answer: Int, isCorrect: Boolean) {
        if (isCorrect) {
            when (answer) {
                1 -> setCorrectColor(btnOptionOne)
                2 -> setCorrectColor(btnOptionTwo)
                3 -> setCorrectColor(btnOptionThree)
                4 -> setCorrectColor(btnOptionFour)
            }
        } else {
            when (answer) {
                1 -> setWrongColor(btnOptionOne)
                2 -> setWrongColor(btnOptionTwo)
                3 -> setWrongColor(btnOptionThree)
                4 -> setWrongColor(btnOptionFour)
            }
        }
    }

    private fun setCorrectColor(btn: Button) {
        btn.setBackgroundColor(Color.parseColor("#cddc39"))
    }

    private fun setWrongColor(btn: Button) {
        btn.setBackgroundColor(Color.parseColor("#ff5722"))
    }


}