package com.gnq.video.video.service;

import com.gnq.video.video.entity.Media;
import com.gnq.video.video.entity.Video;

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
}
