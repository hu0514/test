package com.xujiaji.todo.module.about;

import android.support.v4.widget.SwipeRefreshLayout;

import com.xujiaji.todo.base.PresenterLife;
import com.xujiaji.todo.repository.bean.LicenseBean;
import com.xujiaji.todo.repository.bean.Result;
import com.xujiaji.todo.repository.remote.DataCallback;

import java.util.List;

import io.xujiaji.xmvp.contracts.XContract;

/**
 * author: xujiaji
 * created on: 2018/11/30 14:24
 * description:
 */
public class LicenseContract {
    interface View extends XContract.View {
        void displayLicenseList(List<LicenseBean> licenseBeans);
    }

    interface Presenter extends XContract.Presenter {
        void requestLicense(SwipeRefreshLayout refreshLayout);
    }

    interface Model extends XContract.Model {
        void catLicense(PresenterLife presenterLife, DataCallback<Result<List<LicenseBean>>> callback);
    }
}
