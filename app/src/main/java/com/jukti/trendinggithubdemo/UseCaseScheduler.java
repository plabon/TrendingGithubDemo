package com.jukti.trendinggithubdemo;

import java.jukti.trendingGithubDemo.domain.interactors.UseCase;

/**
 * Created by Pl@b0n on 15,August,2018
 */
public interface UseCaseScheduler {
    void execute(Runnable runnable);
    <V extends UseCase.ResponseValue> void notifyRespoonse(final V response, final UseCase.Callback<V> callback);
    <V extends UseCase.ResponseValue> void notifyError(final UseCase.Callback<V> callback);
}
