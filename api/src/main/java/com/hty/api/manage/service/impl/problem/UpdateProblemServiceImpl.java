package com.hty.api.manage.service.impl.problem;

import com.hty.api.dao.ProblemMapper;
import com.hty.api.manage.service.problem.UpdateProblemService;
import com.hty.api.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateProblemServiceImpl implements UpdateProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public Map<String, String> update(Map<String, String> data) {
        Integer id = Integer.parseInt(data.get("problemId"));
        String title = data.get("title");
        String link = data.get("link");
        Integer tagId = Integer.parseInt(data.get("tagId"));
        Problem problem = new Problem(id,title,link,tagId);
        problemMapper.updateById(problem);
        Map<String,String> resp = new HashMap<>();
        resp.put("message","success");
        return resp;
    }
}
