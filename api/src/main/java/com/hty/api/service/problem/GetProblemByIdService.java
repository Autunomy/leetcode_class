package com.hty.api.service.problem;

import com.alibaba.fastjson.JSONObject;

public interface GetProblemByIdService {
    JSONObject getProblem(Integer problemId);
}
