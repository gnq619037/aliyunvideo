package com.gnq.video.system.entity;

import com.aliyun.oss.ClientException;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;

public class DefaultAcsClientDto {

//    private static final String accessKeyId = "LTAI04TZLadX6QC0";
//    private static final String accessKeySecret = "1x7YbRrZrV4NkqyVAQafrsfWdgBoqp";

    public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret) throws ClientException{
        String regionId = "cn-shanghai";  // 点播服务接入区域
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        return client;
    }
}
