package com.hty.api.service.impl.problem;

import com.alibaba.fastjson.JSONObject;
import com.hty.api.dao.ProblemMapper;
import com.hty.api.pojo.Problem;
import com.hty.api.service.problem.GetProblemByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetProblemByIdServiceImpl implements GetProblemByIdService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public JSONObject getProblem(Integer problemId) {
        Problem problem = problemMapper.selectById(problemId);
        JSONObject resp = new JSONObject();
        resp.put("problem",problem);
        return resp;
    }
}
