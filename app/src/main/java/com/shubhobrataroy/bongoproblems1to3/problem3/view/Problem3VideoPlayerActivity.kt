package com.shubhobrataroy.bongoproblems1to3.problem3.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.shubhobrataroy.bongoproblems1to3.R
import com.shubhobrataroy.bongoproblems1to3.problem3.viewmodel.VideoPlayerViewModel
import kotlinx.android.synthetic.main.activity_problem3_video_player.*


/**
 * @Author Shubhobrata Roy
 *
 *Here there are two implementations of IVideoPlayerView .
1st implementation CustomVideoPlayerVideoView is  VideoView based.
Another implementation CustomVideoPlayerExoPlayer is Exo Player 2 based.
On Problem3VideoPlayerActivity I have wrapped the implementations of IVideoPlayerView , with the interface.
So even if I change the video player with any that implements IVideoPlayerView,
we dont have to change any code of Problem3VideoPlayerActivity
You can change the video player on activity_problem3_video_player.xml from
CustomVideoPlayerExoPlayer to CustomVideoPlayerVideoView and the app will still work
 */

class Problem3VideoPlayerActivity : AppCompatActivity() {

    val iVideoPlayerView by lazy { cvp_video_player as IVideoPlayerView }
    val viewModel by lazy { ViewModelProviders.of(this)[VideoPlayerViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problem3_video_player)

        bt_play.setOnClickListener(this@Problem3VideoPlayerActivity::play)
        iVideoPlayerView.isPlayingLiveData.observe(this, Observer { isPlaying ->
            if (isPlaying) {
                bt_play.text = "Pause"
                bt_play.setOnClickListener(this@Problem3VideoPlayerActivity::pause)
            } else {
                bt_play.text = "Play"
                bt_play.setOnClickListener(this@Problem3VideoPlayerActivity::play)
            }
        })

        iVideoPlayerView.setSource(viewModel.createLocalVideoUri())
        bt_forward.setOnClickListener(this::forward)
        bt_rewind.setOnClickListener(this::rewind)
    }


    fun play(view: View) {
        iVideoPlayerView.play()
    }


    fun pause(view: View) {
        iVideoPlayerView.pause()
    }

    fun forward(view: View) {
        iVideoPlayerView.forward()
    }

    fun rewind(view: View) {
        iVideoPlayerView.rewind()
    }


}
