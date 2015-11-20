package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @ModelAttribute
    HelloForm helloForm() {
        return new HelloForm();
    }

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("/download")
    String download(@Validated HelloForm helloForm, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "index";
        }
        model.addAttribute("fileName", helloForm.getFileName());
        return "downloadView";
    }
}
