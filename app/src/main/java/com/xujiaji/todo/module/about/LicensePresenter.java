package com.xujiaji.todo.module.about;

import android.support.v4.widget.SwipeRefreshLayout;

import com.xujiaji.todo.base.BasePresenter;
import com.xujiaji.todo.repository.bean.LicenseBean;
import com.xujiaji.todo.repository.bean.Result;
import com.xujiaji.todo.repository.remote.DataCallbackImp;

import java.util.List;

/**
 * author: xujiaji
 * created on: 2018/11/30 14:24
 * description:
 */
public class LicensePresenter extends BasePresenter<LicenseContract.View, LicenseModel> implements LicenseContract.Presenter {
    @Override
    public void requestLicense(SwipeRefreshLayout refreshLayout) {
        model.catLicense(this, new DataCallbackImp<Result<List<LicenseBean>>>(refreshLayout) {
            @Override
            public void success(Result<List<LicenseBean>> bean) {
                view.displayLicenseList(bean.getData());
            }
        });
    }
}
