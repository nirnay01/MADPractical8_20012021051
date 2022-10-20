package com.example.madpractical8_20012021051

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var logo_img : ImageView
    lateinit var logo_frame_by_frame_animation : AnimationDrawable
    lateinit var twin_animation : Animation
    lateinit var alarmimgs : ImageView
    lateinit var alarmimg_frameByFrameAnimation : AnimationDrawable
    lateinit var alarmimgAnimation : Animation
    lateinit var heartimgs : ImageView
    lateinit var heart_frameByFrameAnimation : AnimationDrawable
    lateinit var heartAnimation : Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logo_img = findViewById(R.id.img)
        logo_img.setBackgroundResource(R.drawable.uvpce_logo_list)
        logo_frame_by_frame_animation = logo_img.background as AnimationDrawable
        twin_animation = AnimationUtils.loadAnimation(this, R.anim.twin_animation)
        twin_animation.setAnimationListener(this)

        alarmimgs = findViewById(R.id.alarmImages)
        alarmimgs.setBackgroundResource(R.drawable.alarm_image_list)

        heartimgs = findViewById(R.id.heartImages)
        heartimgs.setBackgroundResource(R.drawable.heart_image_list)

        alarmimg_frameByFrameAnimation = alarmimgs.background as AnimationDrawable

        heart_frameByFrameAnimation = heartimgs.background as AnimationDrawable

        alarmimgAnimation = AnimationUtils.loadAnimation(this, R.anim.alarm_animation)
        alarmimgAnimation.setAnimationListener(this)

        heartAnimation = AnimationUtils.loadAnimation(this, R.anim.heart_animation)
        alarmimgAnimation.setAnimationListener(this)
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        if(hasFocus){
            logo_frame_by_frame_animation.start()
            logo_img.startAnimation(twin_animation)

            alarmimg_frameByFrameAnimation.start()
            alarmimgs.startAnimation(alarmimgAnimation)

            heart_frameByFrameAnimation.start()
            heartimgs.startAnimation(heartAnimation)
        }
    }
    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {

    }

    override fun onAnimationRepeat(p0: Animation?) {

    }
}