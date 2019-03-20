package com.saidus.snapanonym.presentation.loader;


import android.content.Context;
import android.location.Location;

import com.saidus.snapanonym.infrastructure.NetworkUtils;
import com.saidus.snapanonym.model.Snap;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class SnapsLoader extends AsyncTaskLoader<List<Snap>> {

    private Location mCurrentLocation;
    private Double mScope;

    public SnapsLoader(@NonNull Context context, Location currentLocation, Double scope) {
        super(context);
        this.mCurrentLocation = currentLocation;
        this.mScope=scope;
    }

    @Override
    protected void onStartLoading() {
        onForceLoad();
        super.onStartLoading();
    }

    @Nullable
    @Override
    public List<Snap> loadInBackground() {

//        List<Snap> snaps = NetworkUtils.getSnaps(mCurrentLocation, mScope);
//        for (Snap snap : snaps) {
//            snap.setDistance((int) AppUtils.distanceBetweenAsMeters(
//                    new SimpleLocation(mCurrentLocation.getLongitude(), mCurrentLocation.getLatitude()),
//                    snap.getPostedAt(),
//                    0,
//                    0));
//        }
//        return snaps;

        return NetworkUtils.getSnaps(mCurrentLocation, mScope);
    }
}

