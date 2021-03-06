package com.gnq.video.video.controller;

import com.gnq.video.video.entity.Video;
import com.gnq.video.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private VideoService videoService;

    private static final String accessKeyId = "";
    private static final String accessKeySecret = "";
//    @RequestParam("file") MultipartFile multipartfile,
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Object uploadVideo(@RequestParam("file") MultipartFile multipartfile,HttpServletRequest request){
        Map<String, Object> resultMap = new HashMap<>();
        String fileRealName = multipartfile.getOriginalFilename();//获得原始文件名;
        String fileName = multipartfile.getName();
        InputStream inputStream = null;
        try{
            inputStream = multipartfile.getInputStream();
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
        videoService.uploadStream(accessKeyId, accessKeySecret, fileName, fileRealName, inputStream);
        resultMap.put("success", true);
        return resultMap;
    }

    @RequestMapping(value = "/uploadStream", method = RequestMethod.POST)
    public Object uploadVideoStream(HttpServletRequest request){
        String url = "https://pan.baidu.com/play/video#/video?path=%2F业余爱好资源%2F视频素材%2F一起变老浪漫婚礼视频去水印.mp4&t=-1";
        String fileName = "demo";
        String fileRealName = "test.mp4";
        Map<String, Object> resultMap = new HashMap<>();
        videoService.uploadURLStream(accessKeyId, accessKeySecret, fileName, fileRealName, url);
        resultMap.put("success", true);
        return resultMap;
    }
}
