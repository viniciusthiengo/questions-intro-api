package br.com.thiengo.introapitests

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import br.com.thiengo.introapitests.adapter.QuestionsAdapter
import br.com.thiengo.introapitests.data.Mock
import br.com.thiengo.introapitests.domain.Question
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {

    val questions = ArrayList<Question>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        questions.addAll( Mock.generateQuestionList() )
        initRecycler()
    }

    private fun initRecycler() {
        rv_questions.setHasFixedSize(true)

        val mLayoutManager = LinearLayoutManager(this)
        rv_questions.layoutManager = mLayoutManager

        val divider = DividerItemDecoration( this, mLayoutManager.orientation)
        rv_questions.addItemDecoration(divider)

        val adapter = QuestionsAdapter(this, questions)
        rv_questions.adapter = adapter
    }
}
