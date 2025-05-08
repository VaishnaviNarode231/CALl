package com.example.contactmanagement.controller;

import com.example.contactmanagement.model.Contact;
import com.example.contactmanagement.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public String home() {
        return "index"; // refers to /WEB-INF/views/index.jsp
    }
//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("contacts", contactService.getAllContacts());
//        return "index";
//    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Contact contact) {
        contactService.addContact(contact);
        return "redirect:/";
    }
}
