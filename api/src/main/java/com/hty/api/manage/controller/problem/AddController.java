package com.hty.api.manage.controller.problem;

import com.hty.api.manage.service.problem.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddController {
    @Autowired
    private AddService addService;

    @PostMapping("/manage/problem/add")
    public Map<String, String> add(@RequestParam Map<String, String> data) {
        return addService.add(data);
    }

}
