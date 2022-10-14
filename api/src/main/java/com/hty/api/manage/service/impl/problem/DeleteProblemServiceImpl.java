package com.hty.api.manage.service.impl.problem;

import com.hty.api.dao.ProblemMapper;
import com.hty.api.manage.service.problem.DeleteProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeleteProblemServiceImpl implements DeleteProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public Map<String, String> delete( Map<String, String> data) {
        Integer problemId = Integer.parseInt(data.get("problemId"));
        problemMapper.deleteById(problemId);
        Map<String,String> map = new HashMap<>();
        map.put("message","success");
        return map;
    }
}
