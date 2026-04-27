package com.example.CamisaDez.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.CamisaDez.model.Camiseta;
import com.example.CamisaDez.model.CamisetaService;

@Controller
public class CamisetaController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/camisetas")
    public String listarCamisetas(Model model){
        CamisetaService cs = context.getBean(CamisetaService.class);
        ArrayList<Camiseta> camisetas = (ArrayList<Camiseta>) cs.listarCamisetas();
        model.addAttribute("camisetas", camisetas);
        return "camisetas/list";
    }

    @GetMapping("/camisetas/new")
    public String formCamiseta(Model model) {
        model.addAttribute("camiseta", new Camiseta());
        return "camisetas/form";
    }

    @GetMapping("/camisetas/{uuid}")
    public String verCamiseta(@PathVariable String uuid, Model model){
        CamisetaService cs = context.getBean(CamisetaService.class);
        Camiseta camiseta = cs.mostrarCamiseta(uuid);
        model.addAttribute("camiseta", camiseta);
        return "camisetas/detalhe";
    }

    @PostMapping("/camiseta")
    public String salvarCamiseta(@ModelAttribute Camiseta camiseta) {
        CamisetaService cs = context.getBean(CamisetaService.class);
        cs.inserirCamiseta(camiseta);
        return "redirect:/camisetas";
    }
}
