package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {

    public MyController() {
        System.out.println("Creating controller!");
    }

//    @RequestMapping(path = "/greeting", method = RequestMethod.GET)
//    @GetMapping("/greeting")
//    public ModelAndView doGreeting(HttpServletRequest request, HttpServletResponse response) {
//        Map<String, String> values = new HashMap<>();
//        values.put("name", "Dan");
//        ModelAndView modelAndView = new ModelAndView("greet", values );
//        return modelAndView;
//    }

//    @GetMapping("/greeting")
//    public ModelAndView doGreeting(@RequestParam String mode) {
//        Map<String, String> values = new HashMap<>();
//        values.put("name", "Dan");
//        values.put("moodComment", "happy".equals(mode) ? "Feeling great" : "Meh");
//        ModelAndView modelAndView = new ModelAndView("greet", values );
//        return modelAndView;
//    }

    @GetMapping("/greeting/{aParam}")
    public ModelAndView doGreeting(@PathVariable("aParam") String param,  @RequestParam String mode) {
        Map<String, String> values = new HashMap<>();
        values.put("name", param);
        values.put("moodComment", "happy".equals(mode) ? "Feeling great" : "Meh");
        ModelAndView modelAndView = new ModelAndView("greet", values );
        return modelAndView;
    }
}
