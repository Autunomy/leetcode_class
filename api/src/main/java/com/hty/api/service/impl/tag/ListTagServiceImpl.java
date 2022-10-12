package com.hty.api.service.impl.tag;

import com.alibaba.fastjson.JSONObject;
import com.hty.api.dao.TagMapper;
import com.hty.api.pojo.Tag;
import com.hty.api.service.tag.ListTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListTagServiceImpl implements ListTagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public JSONObject getList() {
        List<Tag> tags = tagMapper.selectList(null);
        JSONObject resp = new JSONObject();
        resp.put("tags",tags);
        return resp;
    }
}
