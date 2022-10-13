package com.hty.api.manage.service.impl.problem;

import com.hty.api.dao.ProblemMapper;
import com.hty.api.manage.service.problem.AddService;
import com.hty.api.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddServiceImpl implements AddService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public Map<String,String> add(Map<String, String> data) {
        System.out.println(data);
        String title = data.get("title");
        String link = data.get("link");
        Integer tagId = Integer.parseInt(data.get("tagId"));
        Map<String,String> resp = new HashMap<>();

        if(title == null || title.equals("")) {
            resp.put("message","标题不能为空");
            return resp;
        }
        if(title.length() > 100) {
            resp.put("message","标题不能大于100字");
            return resp;
        }
        if(link == null || link.equals("")){
            resp.put("message","链接不能为空");
            return resp;
        }
        if(tagId == -1){
            resp.put("message","请选择标签");
            return resp;
        }
        Problem problem = new Problem(null,title,link,tagId);
        problemMapper.insert(problem);
        resp.put("message","success");
        return resp;
    }
}
