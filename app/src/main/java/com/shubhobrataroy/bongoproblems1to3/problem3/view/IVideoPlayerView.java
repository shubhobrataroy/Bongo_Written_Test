package com.shubhobrataroy.bongoproblems1to3.problem3.view;

import android.net.Uri;

import androidx.lifecycle.LiveData;

public interface IVideoPlayerView {
    public void play();

    public void forward();

    public void rewind();

    public void pause();

    public void setSource(Uri uri);

    public LiveData<Boolean> getIsPlayingLiveData();

    public void releasePlayer();
}
