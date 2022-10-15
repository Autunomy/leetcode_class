package com.hty.api.manage.controller.tag;

import com.hty.api.manage.service.tag.DeleteTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DeleteTagController {
    @Autowired
    private DeleteTagService deleteTagService;

    @PostMapping("/manage/tag/delete")
    private Map<String,String> delete(@RequestParam Map<String,String> data){
        return deleteTagService.delete(data);
    }

}
