package eu.milo4apps.quizzapp

object Constants {

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

        questionsList.add(question1)

        return questionsList
    }

}