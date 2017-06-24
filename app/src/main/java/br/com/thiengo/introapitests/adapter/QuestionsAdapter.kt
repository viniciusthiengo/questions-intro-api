package br.com.thiengo.introapitests.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.thiengo.introapitests.R
import br.com.thiengo.introapitests.domain.Question
import de.hdodenhof.circleimageview.CircleImageView


class QuestionsAdapter(
        private val context: Context,
        private val carros: List<Question>) :
        RecyclerView.Adapter<QuestionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int) : QuestionsAdapter.ViewHolder {

        val v = LayoutInflater
                .from(context)
                .inflate(R.layout.item_question, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(carros[position])
    }

    override fun getItemCount(): Int {
        return carros.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivUser: CircleImageView
        var tvQuestion: TextView

        init {
            ivUser = itemView.findViewById(R.id.iv_user) as CircleImageView
            tvQuestion = itemView.findViewById(R.id.tv_question) as TextView
        }

        fun setData(question: Question) {
            ivUser.setImageResource(question.userImage)
            tvQuestion.text = question.question
        }
    }
}