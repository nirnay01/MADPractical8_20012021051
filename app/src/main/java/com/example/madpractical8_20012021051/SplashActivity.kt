package com.example.madpractical8_20012021051

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView


 class SplashActivity:AppCompatActivity(), Animation.AnimationListener{
    lateinit var logo_img:ImageView
    lateinit var logo_frame_by_fram_animation:AnimationDrawable
    lateinit var twin_animation:Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        logo_img=findViewById(R.id.img)
        logo_img.setBackgroundResource(R.drawable.uvpce_logo_list)
        logo_frame_by_fram_animation=logo_img.background as AnimationDrawable
        twin_animation= AnimationUtils.loadAnimation(this,R.anim.twin_animation)
        twin_animation.setAnimationListener(this)
    }
     override fun onWindowFocusChanged(hasFocus: Boolean) {
         super.onWindowFocusChanged(hasFocus)

         if(hasFocus){
             logo_frame_by_fram_animation.start()
             logo_img.startAnimation(twin_animation)
         }
         else{
             logo_frame_by_fram_animation.stop()
         }
     }

     override fun onAnimationStart(p0: Animation?) {

     }

     override fun onAnimationEnd(p0: Animation?) {
         Intent(this, MainActivity::class.java).also {
             startActivity(it)
             overridePendingTransition(R.anim.scale_in, R.anim.scale_out)
             finish()
         }
     }

     override fun onAnimationRepeat(p0: Animation?) {

     }
}