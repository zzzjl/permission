package com.zzz.controller;

import com.zzz.common.ApplicationContextHelper;
import com.zzz.common.JsonData;
import com.zzz.dao.SysAclModuleMapper;
import com.zzz.exception.ParamException;
import com.zzz.exception.PermissionException;
import com.zzz.model.SysAclModule;
import com.zzz.model.SysDept;
import com.zzz.param.TestVo;
import com.zzz.util.BeanValidator;
import com.zzz.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData Hello(){
        log.info("loghello");
        throw  new RuntimeException("test Ex");
        //return JsonData.success("hello permission");
    }
    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo) throws ParamException {
        log.info("validate");
       /*验证对象的验证
        try{
            Map<String,String> map =BeanValidator.validateObject(vo);
            if(map!=null&&map.entrySet().size()>0){
                for(Map.Entry<String,String> entry:map.entrySet()){
                    log.info("{}->{}",entry.getKey(),entry.getValue());
                }
            }
        }catch (Exception e){

        }*/
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule module = moduleMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(module));
        BeanValidator.check(vo);
        return JsonData.success("test validate");
    }
    @RequestMapping("/arg")
    @ResponseBody
    public String arg(String name,String password ){
        System.out.println(name);
        System.out.println(password);
        return name;

    }
    @RequestMapping("/req")
    @ResponseBody
    public String req(HttpServletRequest request){
        String name =request.getParameter("name");
        String password =request.getParameter("password");
        System.out.println(name);
        System.out.println(password);
        return name;

    }
    @RequestMapping("/pojo")
    @ResponseBody
    public String pojo(SysDept sysDept){
       int id = sysDept.getId();
       String name = sysDept.getName();
        System.out.println(id);
        System.out.println(name);
        return name;

    }

}
