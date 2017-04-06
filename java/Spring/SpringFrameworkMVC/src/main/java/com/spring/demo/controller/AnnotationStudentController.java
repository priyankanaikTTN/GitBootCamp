package com.spring.demo.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Factory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by priyanka on 4/4/17.
 */
@Controller
@RequestMapping("/")
public class AnnotationStudentController {

    @ModelAttribute
    void addingObject(Model model){
        model.addAttribute("heading","Spring MVC demo");
    }

    @RequestMapping("dummy")
    ModelAndView dummy() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("msg", "a modelViewobject");
        return modelAndView;

        
    }


    @RequestMapping("/name/{firstName}/{lastName}")
    @ResponseBody
    String returnCountryAndState(@PathVariable Map<String, String> requestMap) {
        return requestMap.get("firstName") + " " + requestMap.get("lastName");
    }

    @RequestMapping("/index")
    @ResponseBody
    String index_1()
    { return "This uses @responsebody annotation ";
    }

    @RequestMapping(value = "/index_1.html", method = RequestMethod.GET)
    ModelAndView index_2() {
        ModelAndView modelAndView = new ModelAndView("form_1");
        return modelAndView;
    }

    @RequestMapping(value = "/index_2.html", method = RequestMethod.GET)
    ModelAndView index_3() {
        ModelAndView modelAndView = new ModelAndView("form_2");
        return modelAndView;
    }

    @RequestMapping(value = "/submitForm_1.html", method = RequestMethod.POST)
    @ResponseBody
    String submitForm(@RequestParam("username") String uname, @RequestParam("password") String pass) {
        return "Username : " + uname + "<br> Password : " + pass;
    }

    @RequestMapping(value = "/submitForm_2.html", method = RequestMethod.POST)
    ModelAndView submitForm(@ModelAttribute("student") StudentCO studentCO) {

        ModelAndView modelAndView = new ModelAndView("stu_info");
        return modelAndView;
    }
}
