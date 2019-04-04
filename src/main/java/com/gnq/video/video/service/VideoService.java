package com.gnq.video.video.service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.gnq.video.video.dto.VideoDTO;
import com.gnq.video.video.entity.Media;
import com.gnq.video.video.entity.Video;

import java.io.InputStream;

public interface VideoService extends MediaService {
    void uploadMedia(Media video);

    /**
     *
     * @param accessKeyId
     * @param accessKeySecret
     * @param title
     * @param fileName
     */
    void uploadFileStream(String accessKeyId, String accessKeySecret, String title, String fileName);

    void uploadURLStream(String accessKeyId, String accessKeySecret, String title, String fileName, String url);

    CreateUploadVideoResponse createUploadVideo(DefaultAcsClient client, VideoDTO videoDTO);

    void uploadStream(String accessKeyId, String accessKeySecret, String title, String fileName, InputStream inputStream);
}
