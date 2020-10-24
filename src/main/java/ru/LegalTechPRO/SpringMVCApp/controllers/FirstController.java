package ru.LegalTechPRO.SpringMVCApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println(name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              Model model) {
        model.addAttribute("message", name + " " + surname);
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "act", required = false) String act,
                             Model model) {
        double res;
        switch (act) {
            case "m":
                res = a * b;
            break;
            case "d":
                res = a / (double)b;
                break;
            case "p":
                res = a + b;
                break;
            case "s":
                res = a - b;
                break;
            default:
                res=0;
                break;
        }
        model.addAttribute("res", res);
        return "first/calculator";
    }
}
