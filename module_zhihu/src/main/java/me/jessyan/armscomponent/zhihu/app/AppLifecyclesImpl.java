/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.jessyan.armscomponent.zhihu.app;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.multidex.MultiDex;

import com.jess.arms.base.delegate.AppLifecycles;

import butterknife.ButterKnife;
import me.jessyan.armscomponent.zhihu.BuildConfig;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import timber.log.Timber;

import static me.jessyan.armscomponent.zhihu.mvp.model.api.Api.ZHIHU_DOMAIN;
import static me.jessyan.armscomponent.zhihu.mvp.model.api.Api.ZHIHU_DOMAIN_NAME;

/**
 * ================================================
 * 展示 {@link AppLifecycles} 的用法
 * <p>
 * Created by JessYan on 04/09/2017 17:12
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class AppLifecyclesImpl implements AppLifecycles {

    @Override
    public void attachBaseContext(@NonNull Context base) {
        MultiDex.install(base);
    }

    @Override
    public void onCreate(@NonNull Application application) {
        //使用 RetrofitUrlManager 切换 BaseUrl
        RetrofitUrlManager.getInstance().putDomain(ZHIHU_DOMAIN_NAME, ZHIHU_DOMAIN);
        //当所有模块集成到宿主 App 时, 在 App 中已经执行了以下代码
        if (BuildConfig.LOG_DEBUG) {//Timber初始化
            Timber.plant(new Timber.DebugTree());
            ButterKnife.setDebug(true);
        }
    }

    @Override
    public void onTerminate(@NonNull Application application) {

    }
}
