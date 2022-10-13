package com.hty.api.manage.controller.tag;

import com.hty.api.manage.service.tag.AddTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddTagController {
    @Autowired
    private AddTagService addService;

    @PostMapping("/manage/tag/add")
    public Map<String,String> add(@RequestParam Map<String,String> data){
        return addService.add(data);
    }
}
