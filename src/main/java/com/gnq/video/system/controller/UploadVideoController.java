package com.gnq.video.system.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.aliyuncs.vod.model.v20170321.SearchMediaResponse;
import com.gnq.video.system.entity.DefaultAcsClientDto;
import com.gnq.video.system.service.CreateUploadVideoResponService;
import com.gnq.video.system.service.UploadVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/video")
public class UploadVideoController {

    @Autowired
    private UploadVideoService uploadVideoService;
    @Autowired
    private CreateUploadVideoResponService createUploadVideoResponService;

    private final String AccessKey_ID  = "LTAI04TZLadX6QC0";
    private final String AccessKeySecret = "1x7YbRrZrV4NkqyVAQafrsfWdgBoqp";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Object uploadVideo(){
        uploadVideoService.uploadVideo(AccessKey_ID, AccessKeySecret, "测试", "D:\\BaiduNetdiskDownload\\demo.mp4");
        return null;
    }

    @RequestMapping(value = "/streamUpload", method = RequestMethod.POST)
    public Object uploadVideoSteam(){
        uploadVideoService.uploadVideoSteam(AccessKey_ID, AccessKeySecret, "测试",
                "D:\\BaiduNetdiskDownload\\demo.mp4","");
        return null;
    }

    @RequestMapping(value = "/fileStreamUpload", method = RequestMethod.POST)
    public Object uploadVideoFileSteam(HttpServletRequest request){
        String contentType = request.getContentType();
        if(contentType == null || !contentType.toLowerCase().startsWith("multipart/")){
            System.out.println("文件格式不对");
            return null;
        }
        if(request instanceof MultipartHttpServletRequest){

            uploadVideoService.uploadFileStream(AccessKey_ID, AccessKeySecret, "demo", "demo.mp4");
        }
//        multipartFile.getOriginalFilename();
//        System.out.println(multipartFile.getName());
//        System.out.println(multipartFile.getOriginalFilename());

        return null;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object create(){

        DefaultAcsClient client = DefaultAcsClientDto.initVodClient(AccessKey_ID, AccessKeySecret);
        CreateUploadVideoResponse response = new CreateUploadVideoResponse();
        try {
            response = createUploadVideoResponService.createUploadVideo(client);
            System.out.print("VideoId = " + response.getVideoId() + "\n");
            System.out.print("UploadAddress = " + response.getUploadAddress() + "\n");
            System.out.print("UploadAuth = " + response.getUploadAuth() + "\n");
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
        }
        System.out.print("RequestId = " + response.getRequestId() + "\n");
        return null;
    }

    @RequestMapping(value = "/getPlayInfo", method = RequestMethod.POST)
    public Object getPlayInfo(){
        DefaultAcsClient client = DefaultAcsClientDto.initVodClient(AccessKey_ID, AccessKeySecret);
        GetPlayInfoResponse response = new GetPlayInfoResponse();
        try {
            response = uploadVideoService.getPlayInfo(client);
            List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
            //播放地址
            for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
                System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
            }
            //Base信息
            System.out.print("VideoBase.Title = " + response.getVideoBase().getTitle() + "\n");
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
        }
        System.out.print("RequestId = " + response.getRequestId() + "\n");
        return "hello";
    }

    @RequestMapping(value = "/getPlayAuth", method = RequestMethod.POST)
    public Object getPlayAuth(){
        DefaultAcsClient client = DefaultAcsClientDto.initVodClient(AccessKey_ID, AccessKeySecret);
        GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();
        try {
            response = uploadVideoService.getVideoPlayAuth(client);
            //播放凭证
            System.out.print("PlayAuth = " + response.getPlayAuth() + "\n");
            //VideoMeta信息
            System.out.print("VideoMeta.Title = " + response.getVideoMeta().getTitle() + "\n");
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
        }
        System.out.print("RequestId = " + response.getRequestId() + "\n");
        return null;
    }

    @RequestMapping(value = "/searchMedia", method = RequestMethod.POST)
    public Object searchMedia(){
        DefaultAcsClient client = DefaultAcsClientDto.initVodClient(AccessKey_ID, AccessKeySecret);
        SearchMediaResponse response = new SearchMediaResponse();
        try {
            response = uploadVideoService.searchMedia(client);
            if (response.getMediaList() != null && response.getMediaList().size() > 0) {
                System.out.print("Total = " + response.getTotal() + "\n");
                System.out.print("ScrollToken = " + response.getScrollToken() + "\n");
                for (SearchMediaResponse.Media media : response.getMediaList()) {
                    System.out.print("MediaId = " + media.getMediaId() + "\n");
                    System.out.print("MediaType = " + media.getMediaType() + "\n");
                    System.out.print("CreationTime = " + media.getCreationTime() + "\n");
                    System.out.print("Title = " + media.getVideo().getTitle() + "\n");
                    System.out.print("CoverURL = " + media.getVideo().getCoverURL() + "\n");
                    System.out.print("Status = " + media.getVideo().getStatus() + "\n");
                }
            }
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
        }
        System.out.print("RequestId = " + response.getRequestId() + "\n");
        return null;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public Object sayHello(){
        return "hello";
    }
}