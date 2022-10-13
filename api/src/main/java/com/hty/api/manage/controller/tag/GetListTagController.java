package com.hty.api.manage.controller.tag;

import com.hty.api.manage.service.tag.GetListTagService;
import com.hty.api.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetListTagController {
    @Autowired
    private GetListTagService getListTagService;

    @GetMapping("/manage/tag/list")
    public List<Tag> listTag(){
        return getListTagService.listTag();
    }
}
