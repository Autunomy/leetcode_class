package com.hty.api.service.impl.problem;

import com.alibaba.fastjson.JSONObject;
import com.hty.api.dao.ProblemMapper;
import com.hty.api.pojo.Problem;
import com.hty.api.service.problem.GetProblemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProblemListServiceImpl implements GetProblemListService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public JSONObject getList() {
        List<Problem> problems = problemMapper.selectList(null);
        JSONObject resp = new JSONObject();
        resp.put("problems",problems);
        return resp;
    }
}
