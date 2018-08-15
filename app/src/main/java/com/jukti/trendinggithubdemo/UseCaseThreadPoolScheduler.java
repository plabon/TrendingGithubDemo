package com.jukti.trendinggithubdemo;

import android.os.Handler;

import java.jukti.trendingGithubDemo.domain.interactors.UseCase;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public class UseCaseThreadPoolScheduler implements UseCaseScheduler {
    private final Handler mHandler = new Handler();

    public static final int POOL_SIZE = 2;

    public static final int MAX_POOL_SIZE = 4;

    public static final int TIMEOUT = 30;

    private ThreadPoolExecutor mThreadPoolExecutor;

    public UseCaseThreadPoolScheduler() {
        mThreadPoolExecutor = new ThreadPoolExecutor(POOL_SIZE, MAX_POOL_SIZE, TIMEOUT,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(POOL_SIZE));
    }

    @Override
    public void execute(Runnable runnable) {
        mThreadPoolExecutor.execute(runnable);
    }

    @Override
    public <V extends UseCase.ResponseValue> void notifyRespoonse(final V response, final UseCase.Callback<V> callback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(response);
            }
        });
    }

    @Override
    public <V extends UseCase.ResponseValue> void notifyError(final UseCase.Callback<V> callback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onError();
            }
        });
    }
}
