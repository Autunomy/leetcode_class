package com.hty.api.service.impl.content;

import com.alibaba.fastjson.JSONObject;
import com.hty.api.dao.ContentMapper;
import com.hty.api.pojo.Content;
import com.hty.api.service.content.ShowContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowContentServiceImpl implements ShowContentService {

    @Autowired
    private ContentMapper contentMapper;

    @Override
    public JSONObject showContent(Integer contentId) {
        Content content = contentMapper.selectById(contentId);
        JSONObject resp = new JSONObject();
        resp.put("content",content);
        return resp;
    }
}
