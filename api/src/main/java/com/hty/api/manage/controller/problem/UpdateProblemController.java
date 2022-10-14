package com.hty.api.manage.controller.problem;

import com.hty.api.manage.service.problem.UpdateProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdateProblemController {

    @Autowired
    private UpdateProblemService updateProblemService;

    @PostMapping("/manage/problem/update")
    public Map<String,String> update(@RequestParam Map<String,String> data){
        return updateProblemService.update(data);
    }
}
