package com.gnq.video.system.service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.aliyuncs.vod.model.v20170321.SearchMediaResponse;

public interface UploadVideoService {
    void uploadVideo(String accessKeyId, String accessKeySecret, String title, String fileName);

    void uploadVideoSteam(String accessKeyId, String accessKeySecret, String title, String fileName, String url);

    void uploadFileStream(String accessKeyId, String accessKeySecret, String title, String fileName);

    GetPlayInfoResponse getPlayInfo(DefaultAcsClient client) throws Exception;

    GetVideoPlayAuthResponse getVideoPlayAuth(DefaultAcsClient client) throws Exception;

    SearchMediaResponse searchMedia(DefaultAcsClient client) throws Exception;

    /**
     * 上传
     * @param client
     * @return
     */
    CreateUploadVideoResponse createUploadVideo(DefaultAcsClient client);
}
