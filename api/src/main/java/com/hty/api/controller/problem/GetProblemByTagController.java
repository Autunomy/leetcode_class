package com.hty.api.controller.problem;

import com.hty.api.pojo.Problem;
import com.hty.api.service.problem.GetProblemByTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetProblemByTagController {
    @Autowired
    private GetProblemByTagService getProblemByTagService;

    @GetMapping("/problem/getbytag")
    public List<Problem> getProblemByTag(Integer tagId){
        return getProblemByTagService.getProblemByTag(tagId);
    }
}
