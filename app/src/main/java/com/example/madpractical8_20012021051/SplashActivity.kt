package com.example.madpractical8_20012021051

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView


class SplashActivity : AppCompatActivity() ,Animation.Animationlistener{
    lateinit var logo_img:ImageView
    lateinit var logo_frame_by_fram_animation:AnimationDrawable
    lateinit var twin_animation:Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        logo_img=findViewById(R.id.img)
        logo_img.setBackgoundResource(R.drawable.uvpce_logo_list)
        logo_frame_by_fram_animation=logo_img.background as AnimationDrawable
        twin_animation=AnimationUtils.loadAnimation(this,R.anim.twin_animationj)
        twin_animation.setAnimationlistener(this)
    }
    override fun onWindowFocusChanged(hasFocus:Boolean){
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus){
            logo_frame_by_fram_animation.start()
            logo_img.startAnimation(twin_animation)
        }
        else{
            logo_frame_by_fram_animation.stop()
        }
    }
    override fun onAnimationEnd(p0:Animation?){
        var intent=Intent(this,MainActivity::class.java).apply{
            startActivity(this)
        }

    }
}