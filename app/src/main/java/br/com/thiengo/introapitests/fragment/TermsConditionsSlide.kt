package br.com.thiengo.introapitests.fragment

import agency.tango.materialintroscreen.SlideFragment
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.thiengo.introapitests.QuestionsActivity
import br.com.thiengo.introapitests.R
import br.com.thiengo.introapitests.data.SPInfo
import kotlinx.android.synthetic.main.fragment_terms_conditions_slide.*


class TermsConditionsSlide : SlideFragment() {

    override fun onCreateView(
            inflater: LayoutInflater?,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

        return inflater?.inflate( R.layout.fragment_terms_conditions_slide, container, false )
    }

    override fun canMoveFurther(): Boolean {
        //Log.i("Log", "canMoveFurther() : test");

        if( cb_concordo.isChecked ){
            SPInfo(activity).updateIntroStatus(true)

            val intent = Intent(activity, QuestionsActivity::class.java)
            intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP )
            activity.startActivity( intent )
            activity.finish()
        }
        return cb_concordo.isChecked
    }

    override fun cantMoveFurtherErrorMessage(): String {
        return activity.resources.getString(R.string.slide_4_checkbox_error)
    }

    override fun backgroundColor(): Int {
        return R.color.slide_4
    }

    override fun buttonsColor(): Int {
        return R.color.slide_button
    }
}