package com.hty.api.manage.controller.content;

import com.hty.api.utils.QiniuCloudUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class UploadFileController {
    @PostMapping(value="/content/uploadImg")
    public Map<String,String> uploadImg(@RequestParam MultipartFile image) {
        Map<String,String> map = new HashMap<>();
        if (image.isEmpty()) {
            map.put("message","文件为空，请重新上传");
            return map;
        }

        try {
            byte[] bytes = image.getBytes();
            String imageName = UUID.randomUUID().toString();

            QiniuCloudUtil qiniuUtil = new QiniuCloudUtil();
            try {
                //使用base64方式上传到七牛云
                String url = qiniuUtil.put64image(bytes, imageName);
                map.put("message","success");
                map.put("url",url);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return map;
        } catch (IOException e) {
            map.put("message","文件上传发生异常");
            return map;
        }
    }

}
