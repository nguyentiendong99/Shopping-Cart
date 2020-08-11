package com.example.demo.controller;

import com.example.demo.dao.ProductRepository;
import com.example.demo.dao.ProductService;
import com.example.demo.entity.Product;
import com.example.demo.model.Cart;
import com.example.demo.model.CartManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartManager cartManager;
    @Autowired
    private ProductService service;

    @RequestMapping("/add")
    public String add(HttpSession session, @RequestParam("id") Long id,
                      @RequestParam(value = "qty", required = false, defaultValue = "1") int qty){
        Product product = service.get(id);
        Cart cart = cartManager.getCart(session);
        cart.addItem(product, qty);
        return "cart";
    }

    @RequestMapping("/remove")
    public String remove(HttpSession session, @RequestParam("id") Long id){
        Product product = service.get(id);
        Cart cart = cartManager.getCart(session);
        cart.removeItem(product);
        return "cart";
    }

    @RequestMapping("/update")
    public String update(HttpSession session, @RequestParam("id") Long id, @RequestParam("qty") int qty){
        Product product = service.get(id);
        Cart cart = cartManager.getCart(session);
        cart.updateItem(product, qty);
        return "cart";
    }
}
