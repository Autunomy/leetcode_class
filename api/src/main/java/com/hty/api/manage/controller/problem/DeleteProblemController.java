package com.hty.api.manage.controller.problem;

import com.hty.api.manage.service.problem.DeleteProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DeleteProblemController {
    @Autowired
    private DeleteProblemService deleteProblemService;

    @PostMapping("/manage/problem/delete")
    public Map<String,String> delete(@RequestParam Map<String,String> data){
        return deleteProblemService.delete(data);
    }

}
