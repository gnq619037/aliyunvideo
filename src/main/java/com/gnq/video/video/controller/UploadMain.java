package com.gnq.video.video.controller;

import com.aliyun.vod.upload.impl.PutObjectProgressListener;
import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadFileStreamRequest;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadFileStreamResponse;
import com.aliyun.vod.upload.resp.UploadStreamResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class UploadMain {
    public static void main(String[] args){
        try{
            String accessKeyId = "LTAI04TZLadX6QC0";
            String accessKeySecret = "1x7YbRrZrV4NkqyVAQafrsfWdgBoqp";
            String title = "demo";
            String fileName = "demo.mp4";
            InputStream inputStream = new FileInputStream(new File("/opt"));
            UploadStreamRequest request = new UploadStreamRequest(accessKeyId, accessKeySecret, title, fileName, inputStream);
            request.setPrintProgress(true);
            request.setProgressListener(new PutObjectProgressListener());
            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);
            System.out.print("RequestId=" + response.getRequestId() + "\n");
            if (response.isSuccess()) {
                System.out.print("VideoId=" + response.getVideoId() + "\n");
            } else {
                System.out.print("VideoId=" + response.getVideoId() + "\n");
                System.out.print("ErrorCode=" + response.getCode() + "\n");
                System.out.print("ErrorMessage=" + response.getMessage() + "\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
