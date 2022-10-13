package com.hty.api.service.impl.problem;

import com.alibaba.fastjson.JSONObject;
import com.hty.api.dao.ProblemMapper;
import com.hty.api.dao.TagMapper;
import com.hty.api.pojo.Problem;
import com.hty.api.service.problem.GetProblemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetProblemListServiceImpl implements GetProblemListService {
    @Autowired
    private ProblemMapper problemMapper;
    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Map<String,String>> getList() {
        List<Map<String,String>> resp = new ArrayList<>();
        List<Problem> problems = problemMapper.selectList(null);
        for (Problem problem : problems) {
            Map<String,String> temp = new HashMap<>();
            temp.put("id",problem.getId().toString());
            temp.put("title",problem.getTitle());
            temp.put("link",problem.getLink());
            temp.put("tagName",tagMapper.selectById(problem.getTagId()).getName());
            resp.add(temp);
        }
        return resp;
    }
}
