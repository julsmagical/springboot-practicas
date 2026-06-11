package com.example.springboot_demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_demo.models.dto.ParamDto;
import com.example.springboot_demo.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    // /api/params/foo?message=Hola
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Default Message") String message){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    // /api/params/bar?text=algun%20mensaje%20importante&code=12345
    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code){
        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }
    
    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request){
        Integer code = 0;
        try{
            code = Integer.parseInt(request.getParameter("code"));
        } catch(NumberFormatException e){
        }
        ParamMixDto params = new ParamMixDto();
        params.setMessage(request.getParameter("message"));
        params.setCode(code);
        return params;
    }
}
