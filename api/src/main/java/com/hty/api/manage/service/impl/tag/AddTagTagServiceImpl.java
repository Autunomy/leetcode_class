package com.hty.api.manage.service.impl.tag;

import com.hty.api.dao.TagMapper;
import com.hty.api.manage.service.tag.AddTagService;
import com.hty.api.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddTagTagServiceImpl implements AddTagService {
    @Autowired
    private TagMapper tagMapper;

    @Override
    public Map<String, String> add(Map<String, String> data) {
        String tagName = data.get("name");
        Map<String,String> map = new HashMap<>();
        if(tagName == null || tagName.equals("")){
            map.put("message","名称不能为空");
            return map;
        }

        Tag tag = new Tag(null,tagName);
        tagMapper.insert(tag);
        map.put("message","success");
        return map;
    }
}
