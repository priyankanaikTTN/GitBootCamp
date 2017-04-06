package com.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by priyanka on 4/4/17.
 */

@Controller
public class MultiStudentController extends MultiActionController {


    public ModelAndView action_1(HttpServletRequest request,HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    public void action_2(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setContentType("text/html");
        httpServletResponse.getWriter().println("<b>Hello world in action_2</b>");
    }

}
