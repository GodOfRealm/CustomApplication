package com.example.basemodule.test;


import com.example.basemodule.net.common.IdeaApi;

public class RetrofitHelper {
    private static IdeaApiService mIdeaApiService;

    public static IdeaApiService getApiService() {
        if (mIdeaApiService == null)
            mIdeaApiService = IdeaApi.getApiService(IdeaApiService.class, ServerConfig.BASE_URL);
        return mIdeaApiService;
    }
}
