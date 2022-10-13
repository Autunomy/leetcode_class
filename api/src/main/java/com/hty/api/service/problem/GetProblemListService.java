package com.hty.api.service.problem;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public interface GetProblemListService {
    List<Map<String,String>> getList();
}
