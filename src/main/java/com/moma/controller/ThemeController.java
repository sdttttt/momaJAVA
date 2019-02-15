package com.moma.controller;

import com.moma.dao.bean.Theme;
import com.moma.exception.ExceptionEnum;
import com.moma.exception.ThemeNotFountException;
import com.moma.service.ThemeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@ResponseBody
@RestController
public class ThemeController {

    @Resource(type = ThemeService.class)
    ThemeService themeService;

    @RequestMapping(value = "/theme/{id}",method = RequestMethod.GET)
    public Theme getThemeAll(@PathVariable Integer id){
        Theme result = themeService.getThemeAll(id);
        if(result == null){
            throw new ThemeNotFountException();
        }
        return result;
    }

}
