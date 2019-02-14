package com.moma.controller;

import com.moma.dao.bean.Theme;
import com.moma.exception.ExceptionEnum;
import com.moma.exception.ThemeNotFountException;
import com.moma.service.ThemeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@ResponseBody
@RestController
public class ThemeController {

    @Resource(type = ThemeService.class)
    ThemeService themeService;

    @GetMapping("/theme/{id}")
    public Theme getThemeAll(@PathVariable Integer id){
        Theme result = themeService.getThemeAll(id);
        if(result == null){
            throw new ThemeNotFountException(ExceptionEnum.THEME_NOT_FOUNT);
        }
        return result;
    }

}
