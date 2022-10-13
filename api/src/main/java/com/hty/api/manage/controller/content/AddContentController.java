package com.hty.api.manage.controller.content;

import com.hty.api.manage.service.content.AddContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddContentController {
    @Autowired
    private AddContentService addContentService;

    @PostMapping("/manage/content/add")
    public Map<String,String> add(@RequestParam Map<String,String> data){
        return addContentService.add(data);
    }
}
