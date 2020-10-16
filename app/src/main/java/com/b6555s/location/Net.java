package com.b6555s.location;

import android.content.Context;

import com.google.android.gms.security.ProviderInstaller;

public class Net {
    private String domain="http://192.168.43.35:5000";

    public String getDomain(Context context) {

        updateAndroidSecurityProvider(context);
        return domain;
    }
    private void updateAndroidSecurityProvider(Context context) {
        try {
            ProviderInstaller.installIfNeeded(context);
        } catch (Exception e)
        {
            e.getMessage();
        }
    }
}
