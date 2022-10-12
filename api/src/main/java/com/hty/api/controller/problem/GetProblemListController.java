package com.hty.api.controller.problem;

import com.alibaba.fastjson.JSONObject;
import com.hty.api.service.problem.GetProblemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetProblemListController {
    @Autowired
    private GetProblemListService getProblemListService;

    @GetMapping("/problem/getlist")
    public JSONObject getList(){
        return getProblemListService.getList();
    }

}
