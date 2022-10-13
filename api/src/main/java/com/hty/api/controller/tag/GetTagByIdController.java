package com.hty.api.controller.tag;

import com.alibaba.fastjson.JSONObject;
import com.hty.api.service.tag.GetTagByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetTagByIdController {
    @Autowired
    private GetTagByIdService getTagByIdService;

    @GetMapping("/tag/getbyid")
    public JSONObject getTagById(Integer tagId){
        return getTagByIdService.get(tagId);
    }
}
