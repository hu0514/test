package com.xujiaji.todo.module.about;

import com.xujiaji.todo.base.PresenterLife;
import com.xujiaji.todo.repository.bean.LicenseBean;
import com.xujiaji.todo.repository.bean.Result;
import com.xujiaji.todo.repository.remote.CallbackHandler;
import com.xujiaji.todo.repository.remote.DataCallback;
import com.xujiaji.todo.repository.remote.Net;

import java.util.List;

/**
 * author: xujiaji
 * created on: 2018/11/30 14:24
 * description:
 */
public class LicenseModel implements LicenseContract.Model {
    @Override
    public void catLicense(PresenterLife presenterLife, DataCallback<Result<List<LicenseBean>>> callback) {
        Net.getInstance().getLicense(CallbackHandler.getCallback(presenterLife, callback));
    }
}
