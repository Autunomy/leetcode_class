package com.hty.api.service.impl.tag;

import com.alibaba.fastjson.JSONObject;
import com.hty.api.dao.TagMapper;
import com.hty.api.pojo.Tag;
import com.hty.api.service.tag.GetTagByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetTagByIdServiceImpl implements GetTagByIdService {
    @Autowired
    private TagMapper tagMapper;

    @Override
    public JSONObject get(Integer tagId) {
        Tag tag = tagMapper.selectById(tagId);
        JSONObject resp = new JSONObject();
        resp.put("tag",tag);
        return resp;
    }
}
