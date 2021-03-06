package com.example.demo.controller;

import com.example.demo.dao.ProductRepository;
import com.example.demo.dao.ProductService;
import com.example.demo.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    ProductService service;

    @RequestMapping({"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "shop";
    }

    @RequestMapping("/cart")
    public String cart(){
        return "cart";
    }

    @RequestMapping("/product/{id}")
    public String product(@PathVariable("id")Long id, Model model){
        Product product = service.get(id);
        model.addAttribute("product", product);
        return "product";
    }
}
