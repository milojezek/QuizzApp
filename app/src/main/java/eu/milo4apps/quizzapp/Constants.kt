package eu.milo4apps.quizzapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): MutableList<Question> {
        val questionsList = mutableListOf<Question>()

        val question1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.czech_flag,
            "Slovakia",
            "Poland",
            "Slovenia",
            "Czechia",
            4
        )

        val question2 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.cambodia_flag,
            "Laos",
            "Thailand",
            "Cambodia",
            "Vietnam",
            3
        )
        val question3 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.faroe_islands_flag,
            "Sweden",
            "Faroe Islands",
            "Iceland",
            "Finland",
            2
        )

        val question4 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ecuador_flag,
            "Ecuador",
            "Venezuela",
            "Colombia",
            "Peru",
            1
        )

        val question5 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.democratic_republic_of_kongo_flag,
            "Republic of the Congo",
            "South Sudan",
            "Uganda",
            "Democratic Republic of the Congo",
            4
        )

        val question6 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.tajikistan_flag,
            "Uzbekistan",
            "Tajikistan",
            "Kyrgyzstan",
            "Afghanistan",
            2
        )



        questionsList.add(question1)
        questionsList.add(question2)
        questionsList.add(question3)
        questionsList.add(question4)
        questionsList.add(question5)
        questionsList.add(question6)

        return questionsList
    }

}