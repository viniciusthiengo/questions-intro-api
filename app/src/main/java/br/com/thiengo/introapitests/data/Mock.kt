package br.com.thiengo.introapitests.data

import br.com.thiengo.introapitests.R
import br.com.thiengo.introapitests.domain.Question


class Mock {
    companion object{
        fun generateQuestionList() = listOf<Question>(
            Question(R.drawable.person_1, "Qual o estado brasileiro que protege a Ilha da Trindade?"),
            Question(R.drawable.person_2, "Quais são os países participantes da copa das confederações?"),
            Question(R.drawable.person_3, "Qual das linguagens (em opções) é nativa no Android?"),
            Question(R.drawable.person_4, "Qual o valor do novo Volvo ‎XC60?"),
            Question(R.drawable.person_5, "Quais foram os primeiros exploradores que chegaram a África?"),
            Question(R.drawable.person_6, "Quais as principais montadoras de carros asiáticas?"),
            Question(R.drawable.person_7, "O que é possível fazer com o Anko Layouts DSL?"),
            Question(R.drawable.person_8, "O que é e para que realmente serve o Gradle?")
        )
    }
}