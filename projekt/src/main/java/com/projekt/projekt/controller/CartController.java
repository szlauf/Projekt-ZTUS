package com.projekt.projekt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.projekt.projekt.model.Cart;
import com.projekt.projekt.model.Part;
import com.projekt.projekt.model.User;
import com.projekt.projekt.repository.CartRepository;
import com.projekt.projekt.repository.UserRepository;
import com.projekt.projekt.service.PartsService;

@Controller
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PartsService partsService;

    @GetMapping("/cart")
    public String cart(ModelMap model) {
        User user = getCurrentUser();
        List<Part> order = getCartOrder(user);
        int price = calculateTotalPrice(order);

        model.addAttribute("price", price);
        model.addAttribute("parts", order);
        return "cart";
    }

    @GetMapping("/cart_eng")
    public String cartEng(ModelMap model) {
        User user = getCurrentUser();
        List<Part> order = getCartOrder(user);
        int price = calculateTotalPrice(order);

        model.addAttribute("price", price);
        model.addAttribute("parts", order);
        return "cart_eng";
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByLogin(username);
    }

    private List<Part> getCartOrder(User user) {
        return Optional.ofNullable(cartRepository.findByIdUser(user.getId()))
                .map(Cart::getPart)
                .orElse(new ArrayList<>());
    }

    private int calculateTotalPrice(List<Part> order) {
        return order.stream().mapToInt(Part::getPrice).sum();
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<?> placeOrder() {
        User user = getCurrentUser();
        List<Part> order = getCartOrder(user);
    
        // Check if the cart is empty
        if (order.isEmpty()) {
            // You can handle this case, for example, by returning an error response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Cart is empty\"}");
        }
    
        int price = calculateTotalPrice(order) + 10;
    
        // Get the list of part IDs to be deleted
        List<Long> partIdsToDelete = order.stream().map(Part::getId).collect(Collectors.toList());
    
        // Delete the parts from the database
        partsService.deleteParts(partIdsToDelete);
    
        // Generate the PDF
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (PdfWriter writer = new PdfWriter(outputStream);
             PdfDocument pdf = new PdfDocument(writer);
             Document document = new Document(pdf)) {
    
            // Add a title to the PDF
            document.add(new Paragraph("Podsumowanie zamowienia").setTextAlignment(TextAlignment.CENTER));
    
            // Add a table to the PDF
            Table table = new Table(2);
            table.addHeaderCell("Nazwa");
            table.addHeaderCell("Cena");
            for (Part part : order) {
                table.addCell(new Cell().add(new Paragraph(part.getTitle())));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(part.getPrice()))));
            }
            table.addFooterCell(new Cell(1, 2).add(new Paragraph("suma z dostawą(10PLN): " + price + " PLN").setTextAlignment(TextAlignment.RIGHT)));
            document.add(table);
    
            // Close the document
            document.close();
        } catch (IOException e) {
            throw new RuntimeException("Error generating PDF", e);
        }
    
        // Return the PDF as a response
        ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
        }
    
}

