package com.hty.api.controller.problem;

import com.alibaba.fastjson.JSONObject;
import com.hty.api.service.problem.GetProblemByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetProblemByIdController {
    @Autowired
    private GetProblemByIdService getProblemByIdService;

    @GetMapping("/problem/getbyid")
    public JSONObject getProblemById(Integer problemId){
        return getProblemByIdService.getProblem(problemId);
    }

}
