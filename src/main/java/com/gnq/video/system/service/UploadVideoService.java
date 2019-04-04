package com.gnq.video.system.service;

import com.aliyun.vod.upload.impl.PutObjectProgressListener;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.*;

import java.util.List;

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

    ListTranscodeTemplateGroupResponse listTranscodeTemplateGroup(DefaultAcsClient client) throws Exception;

    GetTranscodeTemplateGroupResponse getTranscodeTemplateGroup(DefaultAcsClient client, String groupId) throws Exception;

    GetTranscodeSummaryResponse getTranscodeSummary(DefaultAcsClient client, List<String> videoIds) throws Exception;

    PutObjectProgressListener getProcess(DefaultAcsClient client, String videoId);
}
