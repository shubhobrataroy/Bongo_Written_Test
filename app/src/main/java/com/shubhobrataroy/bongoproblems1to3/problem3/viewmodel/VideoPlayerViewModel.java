package com.shubhobrataroy.bongoproblems1to3.problem3.viewmodel;

import android.app.Application;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class VideoPlayerViewModel extends AndroidViewModel {
    private Application application;

    public VideoPlayerViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
    }


    public Uri createLocalVideoUri() {
//        return Uri.parse("file:///android_asset/small_video.mp4");

        return Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4");
    }
}
