package br.com.thiengo.introapitests

import agency.tango.materialintroscreen.MaterialIntroActivity
import agency.tango.materialintroscreen.MessageButtonBehaviour
import agency.tango.materialintroscreen.SlideFragmentBuilder
import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.View
import br.com.thiengo.introapitests.data.SPInfo
import br.com.thiengo.introapitests.fragment.TermsConditionsSlide


class IntroActivity : MaterialIntroActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verifyIntroActivity()

        /*backButtonTranslationWrapper
            .setEnterTranslation {
                view, percentage -> view.alpha = percentage * 5
            }*/

        //setSkipButtonVisible()
        //hideBackButton()
        //enableLastSlideAlphaExitTransition(true)

        addSlide(
            SlideFragmentBuilder()
                .backgroundColor(R.color.slide_1)
                .buttonsColor( R.color.slide_button )
                .title( resources.getString(R.string.slide_1_title) )
                .description( resources.getString(R.string.slide_1_description) )
                .image( R.drawable.slide_1 )
                .build(),
            MessageButtonBehaviour( object : View.OnClickListener {
                override fun onClick(v: View?) {
                    showMessage( resources.getString(R.string.slide_1_button_message) )
                }
            }, resources.getString(R.string.slide_1_button_label))
        )


        val neededPermissions = arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION)
        addSlide(
            SlideFragmentBuilder()
                .backgroundColor(R.color.slide_2)
                .buttonsColor( R.color.slide_button )
                .title( resources.getString(R.string.slide_2_title) )
                .description( resources.getString(R.string.slide_2_description) )
                .image( R.drawable.slide_2 )
                .neededPermissions( neededPermissions )
                .build()
        )


        val possiblePermissions = arrayOf( Manifest.permission.CAMERA)
        addSlide(
            SlideFragmentBuilder()
                .backgroundColor(R.color.slide_3)
                .buttonsColor( R.color.slide_button )
                .title( resources.getString(R.string.slide_3_title) )
                .description( resources.getString(R.string.slide_3_description) )
                .image( R.drawable.slide_3 )
                .possiblePermissions( possiblePermissions )
                .build()
        )


        addSlide( TermsConditionsSlide() )
    }


    private fun verifyIntroActivity(){
        if( SPInfo(this).isIntroShown() ){
            startActivity(
                Intent(this, QuestionsActivity::class.java)
            )
            finish()
        }
    }
}