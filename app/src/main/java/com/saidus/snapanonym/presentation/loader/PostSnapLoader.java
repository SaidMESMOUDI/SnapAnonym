package com.saidus.snapanonym.presentation.loader;

import android.content.Context;
import android.location.Location;

import com.saidus.snapanonym.infrastructure.NetworkUtils;

import java.io.File;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class PostSnapLoader extends AsyncTaskLoader {


    private final Location mCurrentLocation;
    private final File mPhotoFile;

    public PostSnapLoader(@NonNull Context context, Location currentLocation, File file) {
        super(context);
        this.mCurrentLocation = currentLocation;
        this.mPhotoFile = file;
    }

    @Override
    protected void onStartLoading() {
        onForceLoad();
        super.onStartLoading();
    }

    @Nullable
    @Override
    public Object loadInBackground() {
        NetworkUtils networkUtils = new NetworkUtils(getContext());
        networkUtils.postSnap(mCurrentLocation, mPhotoFile);
        return null;
    }
}
