package com.hty.api.service.impl.content;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hty.api.dao.ContentMapper;
import com.hty.api.pojo.Content;
import com.hty.api.service.content.GetContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetContentServiceImpl implements GetContentService {
    @Autowired
    private ContentMapper contentMapper;

    @Override
    public JSONObject getContent(Integer problemId) {
        QueryWrapper<Content> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("problem_id",problemId);
        List<Content> contents = contentMapper.selectList(queryWrapper);
        JSONObject resp = new JSONObject();
        resp.put("contents",contents);
        return resp;
    }
}
