package com.ebc.lui.take_attendance.controller;

import com.ebc.lui.take_attendance.model.Student;
import com.ebc.lui.take_attendance.service.AttendService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AttendController {

    // HashMap created for testing purpose
//    private Map<String, Student> testMapDB = new HashMap<>();

    private final AttendService attendService;

    public AttendController(AttendService attendService) {
        this.attendService = attendService;
    }

    // For testing purpose
    @GetMapping("/testing")
    @ResponseBody
    public String hello() {
        return "Hello World";
    }


    //Replaced by login function
    @GetMapping("/")
    @ResponseBody
    public String password(){
        return "This page expected to have a password page";
    }

    @GetMapping("/add")
    public String studentForm(Model model){
        model.addAttribute("student", new Student());
        return "add";
    }

    @PostMapping("/add")
    public String studentAdd(@ModelAttribute @RequestPart("data") Student student, Model model){
        attendService.save(student.getName(), student.getStudent_class());
        return "display_test";
    }

    @GetMapping("/check")
    public String checkStatus(Model model){
//        return testMapDB.values();
        model.addAttribute("students", attendService.find());
        return "display";
    }

    @PostMapping("/remove/{id}")
    public String delete(@PathVariable Integer id){
        attendService.remove(id);
        return "redirect:/check";
    }

}
