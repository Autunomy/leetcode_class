package com.hty.api.manage.service.impl.tag;

import com.hty.api.dao.TagMapper;
import com.hty.api.manage.service.tag.DeleteTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeleteTagServiceImpl implements DeleteTagService {
    @Autowired
    private TagMapper tagMapper;

    @Override
    public Map<String, String> delete(Map<String,String> data) {
        Integer tagId = Integer.parseInt(data.get("tagId"));
        tagMapper.deleteById(tagId);
        Map<String,String> map = new HashMap<>();
        map.put("message","success");
        return map;
    }
}
