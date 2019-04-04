package com.gnq.video.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoRequest;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.gnq.video.system.service.CreateUploadVideoResponService;
import org.springframework.stereotype.Service;

@Service
public class CreateUploadVideoResponServiceImpl implements CreateUploadVideoResponService  {
    @Override
    public CreateUploadVideoResponse createUploadVideo(DefaultAcsClient client) throws Exception{
        CreateUploadVideoRequest request = new CreateUploadVideoRequest();
        request.setTitle("this is a sample");
        request.setFileName("D:\\BaiduNetdiskDownload\\demo.mp4");

        JSONObject userData = new JSONObject();

        JSONObject messageCallback = new JSONObject();
        messageCallback.put("CallbackURL", "http://localhost:7878/video/process?videoId=04a15ff2a06a4a0790d01b58483d84bd");
        messageCallback.put("CallbackType", "http");
        userData.put("MessageCallback", messageCallback.toJSONString());

        JSONObject extend = new JSONObject();
        extend.put("MyId", "user-defined-id");
        userData.put("Extend", extend.toJSONString());

        request.setUserData(userData.toJSONString());

        return client.getAcsResponse(request);
    }
}
