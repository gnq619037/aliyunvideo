package com.gnq.video.video;

import com.aliyun.oss.ClientException;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;

public class DefaultAcsClientConfig {

//    private static final String accessKeyId = "LTAI04TZLadX6QC0";
//    private static final String accessKeySecret = "1x7YbRrZrV4NkqyVAQafrsfWdgBoqp";
    private String accessKeyId = "";
    private String accessKeySecret = "";

    public DefaultAcsClientConfig(String accessKeyId, String accessKeySecret){
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
    }

    public DefaultAcsClient initVodClient() throws ClientException {
        String regionId = "cn-shanghai";  // 点播服务接入区域
        DefaultProfile profile = DefaultProfile.getProfile(regionId, this.accessKeyId, this.accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        return client;
    }

    public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret){
        String regionId = "cn-shanghai";  // 点播服务接入区域
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        return client;
    }
}
