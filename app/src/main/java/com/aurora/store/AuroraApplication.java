/*
 * Aurora Store
 * Copyright (C) 2019, Rahul Kumar Patel <whyorean@gmail.com>
 *
 * Aurora Store is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * Aurora Store is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Aurora Store.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 */

package com.aurora.store;

import android.app.Application;

import io.reactivex.plugins.RxJavaPlugins;

public class AuroraApplication extends Application {

    public static boolean tokenRefreshing = false;
    public static boolean anonymousLogging = false;

    public static boolean isAnonymousLogging() {
        return anonymousLogging;
    }

    public static void setAnonymousLogging(boolean anonymousLogging) {
        AuroraApplication.anonymousLogging = anonymousLogging;
    }

    public static boolean isTokenRefreshing() {
        return tokenRefreshing;
    }

    public static void setTokenRefreshing(boolean tokenRefreshing) {
        AuroraApplication.tokenRefreshing = tokenRefreshing;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        RxJavaPlugins.setErrorHandler(err -> {
        });
    }
}
