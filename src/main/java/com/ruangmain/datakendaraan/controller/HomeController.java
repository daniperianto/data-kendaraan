package com.ruangmain.datakendaraan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home.html";
    }

    @GetMapping("/add")
    public String add() {
        return "add.html";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id) {
        return "edit.html";
    }

    @GetMapping("/detail/{id}")
    public String get(@PathVariable String id) {
        return "vehicle.html";
    }

}
