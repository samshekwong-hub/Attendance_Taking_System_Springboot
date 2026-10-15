package com.ebc.lui.take_attendance.controller;

import com.ebc.lui.take_attendance.model.Student;
import com.ebc.lui.take_attendance.service.AttendService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/")
    public String add(){
        return "redirect:/add";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/add")
    public String studentForm(Model model){
        model.addAttribute("student", new Student());
        return "add";
    }

    @PostMapping("/add")
    public String studentAdd(@ModelAttribute Student student, Model model){
        String result = attendService.save(student.getName(), student.getStudentClass());

        model.addAttribute("message", result);
        model.addAttribute("student", new Student());

        return "add";
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

    @PostMapping("/attend/{id}")
    public String takeAttend(@PathVariable Integer id){
        attendService.addAttendRecord(id);
        return "redirect:/check";
    }

    @PostMapping("/cancel_attend/{id}")
    public String removeAttend(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        boolean notZero = attendService.removeAttendRecord(id);

        if (!notZero) {
            redirectAttributes.addFlashAttribute("errMsgAttend", "The attendance count is already 0");
        }

        return "redirect:/check";
    }

    @PostMapping("/ask_leave/{id}")
    public String takeAskLeave(@PathVariable Integer id) {
        attendService.addAskLeaveRecord(id);
        return "redirect:/check";
    }

    @PostMapping("/remove_ask_leave/{id}")
    public String removeAskLeave(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        boolean notZero = attendService.removeAskLeaveRecord(id);

        if (!notZero) {
            redirectAttributes.addFlashAttribute("errMsgAskLeave", "The ask for leave count is already 0");
        }

        return "redirect:/check";
    }
}
