package com.saidus.snapanonym.infrastructure;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;


public class AppUtils {

    public static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 123;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static boolean hasPermissions(Context context, String[] permissions) {
        for (int i = 0; i < permissions.length; i++) {
            String permission = permissions[i];
            if (context.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED)
                return false;
        }
        return true;
    }

    public static void requestPermissions(Activity activity, String[] permissions, int permissionRequestCode) {
        ActivityCompat.requestPermissions(activity,
                permissions,
                permissionRequestCode);

    }

}
