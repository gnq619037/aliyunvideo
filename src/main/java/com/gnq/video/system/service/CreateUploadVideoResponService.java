package com.gnq.video.system.service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;

public interface CreateUploadVideoResponService {
    CreateUploadVideoResponse createUploadVideo(DefaultAcsClient client) throws Exception ;
}
