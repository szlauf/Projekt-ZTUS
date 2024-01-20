package com.projekt.projekt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projekt.projekt.model.DaneUser;
import com.projekt.projekt.model.Part;
import com.projekt.projekt.model.User;
import com.projekt.projekt.model.UserOrders;
import com.projekt.projekt.repository.DaneUserRepository;
import com.projekt.projekt.repository.UserOrdersRepository;
import com.projekt.projekt.repository.UserRepository;
import com.projekt.projekt.service.PartsService;

@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    DaneUserRepository daneUserRepository;

    @Autowired
    PartsService partsService;

    @Autowired
    UserOrdersRepository userOrdersRepository;

    // Metoda obsługująca żądania GET na ścieżce "/profile"
    @GetMapping("/profile")
    public String profile(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByLogin(username);
        DaneUser daneUser = daneUserRepository.findByDaneUserId(user.getDaneUserId());
        List<Part> parts = partsService.getUserParts(user);
        List<UserOrders> userOrders = userOrdersRepository.findByIdUser(user.getId());
        List<Part> orders = new ArrayList<>();
        List<Part> archive = partsService.getUserArchive(user);

        for (UserOrders userOrder : userOrders) {
            orders.add(partsService.getUserOrders(userOrder.getIdOgloszenie()));
        }
        model.addAttribute("user", user);
        model.addAttribute("daneUser", daneUser);
        model.addAttribute("parts", parts);
        model.addAttribute("orders", orders);
        model.addAttribute("archive", archive);
        // Zwracanie nazwy widoku (szablonu) o nazwie "profile"
        return "profile";
    }
    

    @GetMapping("/profile_eng")
    public String profileEng(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByLogin(username);
        DaneUser daneUser = daneUserRepository.findByDaneUserId(user.getDaneUserId());
        List<Part> parts = partsService.getUserParts(user);
        List<UserOrders> userOrders = userOrdersRepository.findByIdUser(user.getId());
        List<Part> orders = new ArrayList<>();

        for (UserOrders userOrder : userOrders) {
            orders.add(partsService.getUserOrders(userOrder.getIdOgloszenie()));
        }
        model.addAttribute("user", user);
        model.addAttribute("daneUser", daneUser);
        model.addAttribute("parts", parts);
        model.addAttribute("orders", orders);
        // Zwracanie nazwy widoku (szablonu) o nazwie "profile"
        return "profile_eng";
    }
    

    @PostMapping("/deletePart")
    public String deletePart(@RequestParam("partId") Long partId) {
        // Call service method to delete the part
        partsService.deletePart(partId);
        // Redirect to the profile page or wherever appropriate
        return "redirect:/profile";
    }

   @PostMapping("/archivePart")
   public String archivePart(@RequestParam("partId") Long partId) {
      // Call service method to archive the part
      partsService.archivePart(partId);
      // Redirect to the profile page or wherever appropriate
      return "redirect:/profile";
   }

   @PostMapping("/unArchivePart")
   public String unArchivePart(@RequestParam("partId") Long partId) {
      // Call service method to archive the part
      partsService.unArchivePart(partId);
      // Redirect to the profile page or wherever appropriate
      return "redirect:/profile";
   }

   @PostMapping("/deletePart-eng")
    public String deletePartEng(@RequestParam("partId") Long partId) {
        // Call service method to delete the part
        partsService.deletePart(partId);
        // Redirect to the profile page or wherever appropriate
        return "redirect:/profile_eng";
    }

   @PostMapping("/archivePart-eng")
   public String archivePartEng(@RequestParam("partId") Long partId) {
      // Call service method to archive the part
      partsService.archivePart(partId);
      // Redirect to the profile page or wherever appropriate
      return "redirect:/profile_eng";
   }

   @PostMapping("/unArchivePart-eng")
   public String unArchivePartEng(@RequestParam("partId") Long partId) {
      // Call service method to archive the part
      partsService.unArchivePart(partId);
      // Redirect to the profile page or wherever appropriate
      return "redirect:/profile_eng";
   }

}
