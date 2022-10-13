package com.hty.api.service.problem;

import com.alibaba.fastjson.JSONObject;
import com.hty.api.pojo.Problem;

import java.util.List;

public interface GetProblemByTagService {
    List<Problem> getProblemByTag(Integer tagId);
}
