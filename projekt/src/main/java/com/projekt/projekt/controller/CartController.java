// Deklaracja pakietu, w którym znajduje się klasa CartController
package com.projekt.projekt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
// Importowanie niezbędnych klas z frameworka Spring
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.projekt.projekt.model.Cart;
import com.projekt.projekt.model.Part;
import com.projekt.projekt.model.User;
import com.projekt.projekt.repository.CartRepository;
import com.projekt.projekt.repository.UserRepository;
import com.projekt.projekt.service.PartsService;

// Deklaracja klasy kontrolera obsługującej koszyk
@Controller
public class CartController {

    @Autowired
    private PartsService partsService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    // Metoda obsługująca żądanie GET na ścieżce "/cart"
    @GetMapping("/cart")
    public String cart(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByLogin(username);
        List<Part> order = new ArrayList<>();
        Integer price = 0;
        if (cartRepository.findByIdUser(user.getId())!=null){
            order = cartRepository.findByIdUser(user.getId()).getPart();
            for (Part o : order){
                price += o.getPrice();
            }
        }
        model.addAttribute("price", price);
        model.addAttribute("parts", order);
        return "cart";
    }
    
}
