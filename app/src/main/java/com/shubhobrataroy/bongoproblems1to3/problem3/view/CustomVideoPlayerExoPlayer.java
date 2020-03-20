package com.shubhobrataroy.bongoproblems1to3.problem3.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

/**
 * @Author Shubhobrata Roy
 * Exoplayer 2 implementation of com.shubhobrataroy.bongoproblems1to3.problem3.view.IVideoPlayerView
 */


public class CustomVideoPlayerExoPlayer extends com.google.android.exoplayer2.ui.PlayerView implements IVideoPlayerView {
    private MutableLiveData<Boolean> isPlayingLiveData = new MutableLiveData<>();
    private SimpleExoPlayer simpleExoPlayer;

    public CustomVideoPlayerExoPlayer(Context context) {
        super(context);
    }

    public CustomVideoPlayerExoPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomVideoPlayerExoPlayer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void play() {
        simpleExoPlayer.setPlayWhenReady(true);
    }

    @Override
    public void pause() {
        simpleExoPlayer.setPlayWhenReady(false);
    }

    @Override
    public void setSource(Uri uri) {
        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();


        DefaultDataSourceFactory dataSourceFactory = new DefaultDataSourceFactory(this.getContext(),
                Util.getUserAgent(this.getContext(), "mediaPlayerSample"), defaultBandwidthMeter);

        ExtractorMediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri);

        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(defaultBandwidthMeter));

        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(getContext(), defaultTrackSelector);

        this.setPlayer(simpleExoPlayer);
        simpleExoPlayer.prepare(mediaSource);

        simpleExoPlayer.addListener(new Player.DefaultEventListener() {
            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                if (playWhenReady && playbackState == Player.STATE_READY)
                    isPlayingLiveData.postValue(true);
                else if (playWhenReady)
                    isPlayingLiveData.postValue(true);
                else
                    isPlayingLiveData.postValue(false);

            }
        });
    }

    @Override
    public void forward() {
        long seekto = simpleExoPlayer.getCurrentPosition() + 1000l;
        if (seekto < simpleExoPlayer.getDuration())
            simpleExoPlayer.seekTo(seekto);
    }

    @Override
    public void rewind() {
        long seekto = simpleExoPlayer.getCurrentPosition() - 1000l;
        if (seekto > 0)
            simpleExoPlayer.seekTo(seekto);
    }

    public LiveData<Boolean> getIsPlayingLiveData() {
        return isPlayingLiveData;
    }

    @Override
    public void releasePlayer() {
        simpleExoPlayer.release();
    }
}
