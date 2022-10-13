package com.hty.api.service.impl.problem;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hty.api.dao.ProblemMapper;
import com.hty.api.pojo.Problem;
import com.hty.api.service.problem.GetProblemByTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProblemByTagServiceImpl implements GetProblemByTagService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public List<Problem> getProblemByTag(Integer tagId) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tag_id",tagId);
        List<Problem> problems = problemMapper.selectList(queryWrapper);
        return problems;
    }
}
