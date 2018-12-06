/*
 * Aurora Store
 * Copyright (C) 2018  Rahul Kumar Patel <whyorean@gmail.com>
 *
 * Yalp Store
 * Copyright (C) 2018 Sergey Yeriomin <yeriomin@gmail.com>
 *
 * Aurora Store (a fork of Yalp Store )is free software: you can redistribute it and/or modify
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
 */

package com.dragons.aurora.task.playstore;

import android.content.Context;

import com.dragons.aurora.model.App;
import com.dragons.aurora.model.AppBuilder;
import com.dragons.aurora.playstoreapiv2.DetailsResponse;

import java.util.ArrayList;
import java.util.List;

public class AppDetailsTask extends ExceptionTask {

    public AppDetailsTask(Context context) {
        super(context);
    }

    public List<App> getAppDetails(ArrayList<String> currList) {
        List<App> apps = new ArrayList<>();
        for (String packageName : currList) {
            try {
                DetailsResponse response = getApi().details(packageName);
                App app = AppBuilder.build(response);
                apps.add(app);
            } catch (Exception e) {
                processException(e);
            }
        }
        return apps;
    }

}