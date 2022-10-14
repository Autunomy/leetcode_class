package com.hty.api.manage.service.impl.content;

import com.hty.api.dao.ContentMapper;
import com.hty.api.dao.ProblemMapper;
import com.hty.api.manage.service.content.ListContentService;
import com.hty.api.pojo.Content;
import com.hty.api.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ListContentServiceImpl implements ListContentService {
    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private ProblemMapper problemMapper;


    @Override
    public List<Map<String, String>> list() {
        List<Map<String,String>> resp = new ArrayList<>();
        List<Content> contents = contentMapper.selectList(null);

        for (Content content : contents) {
            Map<String,String> map = new HashMap<>();
            Problem problem = problemMapper.selectById(content.getProblemId());
            if(problem == null) continue;
            map.put("id",content.getId().toString());
            map.put("title",content.getTitle());
            map.put("content",content.getContent());
            map.put("createTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(content.getCreateTime()));
            map.put("problemName",problem.getTitle());
            resp.add(map);
        }
        return resp;
    }
}
