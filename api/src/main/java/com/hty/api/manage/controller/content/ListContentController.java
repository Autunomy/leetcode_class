package com.hty.api.manage.controller.content;

import com.hty.api.manage.service.content.ListContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ListContentController {
    @Autowired
    private ListContentService listContentService;

    @GetMapping("/manage/content/list")
    public List<Map<String,String>> list(){
        return listContentService.list();
    }
}
