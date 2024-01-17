package com.projekt.projekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductAddControler {

    @GetMapping("/product-add")
    public String productAdd() {
        return "product-add";
    }
    
}
