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
package me.jessyan.armscomponent.gank.mvp.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.jess.arms.base.BaseHolder;

import butterknife.BindView;
import me.jessyan.armscomponent.gank.R2;
import me.jessyan.armscomponent.gank.mvp.model.entity.GankItemBean;

/**
 * ================================================
 * 展示 {@link BaseHolder} 的用法
 * <p>
 * Created by JessYan on 9/4/16 12:56
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class GankHomeItemHolder extends BaseHolder<GankItemBean> {

    @BindView(R2.id.iv_avatar)
    TextView mAvatar;

    public GankHomeItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(GankItemBean data, int position) {
        //itemView 的 Context 就是 Activity, Glide 会自动处理并和该 Activity 的生命周期绑定
        mAvatar.setText("这是模块3：" + position);
    }

    @Override
    protected void onRelease() {

    }
}
