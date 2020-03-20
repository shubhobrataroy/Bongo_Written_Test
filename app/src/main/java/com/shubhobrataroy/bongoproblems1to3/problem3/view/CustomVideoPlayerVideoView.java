package com.shubhobrataroy.bongoproblems1to3.problem3.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.VideoView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * @Author Shubhobrata Roy
 * VideoView implementation of com.shubhobrataroy.bongoproblems1to3.problem3.view.IVideoPlayerView
 */

public class CustomVideoPlayerVideoView extends VideoView implements IVideoPlayerView {
    MutableLiveData<Boolean> isPlayingLiveData = new MutableLiveData<>();


    public CustomVideoPlayerVideoView(Context context) {
        super(context);
        init();
    }

    public CustomVideoPlayerVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomVideoPlayerVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CustomVideoPlayerVideoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init() {
//        setBackgroundColor(Color.TRANSPARENT);
    }

    @Override
    public void play() {
        requestFocus();
        start();
        isPlayingLiveData.postValue(isPlaying());
    }

    @Override
    public void pause() {
        super.pause();
        isPlayingLiveData.postValue(isPlaying());
    }

    @Override
    public void setSource(Uri uri) {
        setVideoURI(uri);
    }

    @Override
    public void forward() {
        if (canSeekForward())
            seekTo(getCurrentPosition() + 2000);
    }

    @Override
    public void rewind() {
        if (canSeekBackward())
            seekTo(getCurrentPosition() - 2000);
    }

    public LiveData<Boolean> getIsPlayingLiveData() {
        return isPlayingLiveData;
    }

    @Override
    public void releasePlayer() {

    }
}
