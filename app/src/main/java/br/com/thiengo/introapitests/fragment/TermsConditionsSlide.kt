package br.com.thiengo.introapitests.fragment

import agency.tango.materialintroscreen.SlideFragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.thiengo.introapitests.QuestionsActivity
import br.com.thiengo.introapitests.R
import br.com.thiengo.introapitests.data.SPInfo
import kotlinx.android.synthetic.main.fragment_terms_conditions_slide.*


class TermsConditionsSlide: SlideFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_terms_conditions_slide, container, false)
    }

    override fun canMoveFurther(): Boolean {
        if( cb_concordo.isChecked ){
            SPInfo(activity).updateIntroStatus( cb_concordo.isChecked )
            val intent = Intent(activity, QuestionsActivity::class.java)
            activity.startActivity(intent)
        }
        return cb_concordo.isChecked
    }

    override fun cantMoveFurtherErrorMessage(): String {
        return "Você precisa concordar com os termos e condições de uso para prosseguir."
    }

    override fun backgroundColor(): Int {
        return R.color.slide_4
    }

    override fun buttonsColor(): Int {
        return R.color.slide_button
    }
}