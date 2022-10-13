package com.hty.api.manage.service.impl.content;

import com.hty.api.dao.ContentMapper;
import com.hty.api.manage.service.content.AddContentService;
import com.hty.api.pojo.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AddContentServiceImpl implements AddContentService {
    @Autowired
    private ContentMapper contentMapper;

    @Override
    public Map<String, String> add(Map<String, String> data) {
        Map<String,String> map = new HashMap<>();
        String title = data.get("title");
        String theContent = data.get("content");
        Integer problemId = Integer.parseInt(data.get("problemId"));

        if(title == null || title.equals("")){
            map.put("message","标题不能为空");
            return map;
        }
        if(theContent == null || theContent.equals("")){
            map.put("message","内容不能为空");
            return map;
        }

        Content content = new Content(null,theContent,new Date(),problemId,title);
        contentMapper.insert(content);
        map.put("message","success");
        return map;
    }
}
