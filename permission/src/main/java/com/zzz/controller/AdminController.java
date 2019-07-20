package com.zzz.controller;

import com.zzz.model.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("index.page")
    public ModelAndView index() {
        return new ModelAndView("admin");
    }

    @RequestMapping(value="/handleuser", method = RequestMethod.GET )
    @ResponseBody
    public Map handleUser(HttpServletRequest request) {
        Map<String,String> modelMap = new HashMap<String,String>();
        SysUser sysUser= (SysUser) request.getSession().getAttribute("user");
        String userName=sysUser.getUsername();
        modelMap.put("user",userName);
        return modelMap;
    }

}
