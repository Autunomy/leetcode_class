package com.hty.api.manage.service.impl.tag;

import com.hty.api.dao.TagMapper;
import com.hty.api.manage.service.tag.GetListTagService;
import com.hty.api.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetListTagServiceImpl implements GetListTagService {
    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> listTag() {
        List<Tag> tags = tagMapper.selectList(null);
        return tags;
    }
}
