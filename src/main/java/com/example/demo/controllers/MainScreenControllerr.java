package com.example.demo.controllers;

import com.example.demo.service.InhousePartService;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 *
 *
 *
 */

@Controller
public class MainScreenControllerr {
   // private final PartRepository partRepository;
   // private final ProductRepository productRepository;'

    private PartService partService;
    private ProductService productService;

    @Autowired
    private OutsourcedPartService outsourcedpartService;

    @Autowired
    private InhousePartService inhousepartService;

    private List<Part> theParts;
    private List<Product> theProducts;

 /*   public MainScreenControllerr(PartRepository partRepository, ProductRepository productRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
    }*/

    public MainScreenControllerr(PartService partService,ProductService productService){
        this.partService=partService;
        this.productService=productService;
    }
    @GetMapping("/mainscreen")
    public String listPartsandProducts(Model theModel,
                                       @Param("partkeyword") @Nullable String partkeyword,
                                       @Param("productkeyword") @Nullable String productkeyword){
        if (partkeyword == null) {
            partkeyword = "";
        }

        if (productkeyword == null) {
            productkeyword = "";
        }
        //initialize sample inventory
        addSampleInventory();
        //add to the sprig model
        List<Part> partList=partService.listAll(partkeyword);
        theModel.addAttribute("parts",partList);
        theModel.addAttribute("partkeyword",partkeyword);
    //    theModel.addAttribute("products",productService.findAll());
        List<Product> productList=productService.listAll(productkeyword);
        theModel.addAttribute("products", productList);
        theModel.addAttribute("productkeyword",productkeyword);
        return "mainscreen";
    }
    private void addSampleInventory() {
        if (partService.listAll("").isEmpty() && productService.listAll("").isEmpty()) {
            // Create and save sample ingredients (parts)
            OutsourcedPart redPaint = new OutsourcedPart("Red Paint", 0.50, 67, 20, 100);
            OutsourcedPart yellowPaint = new OutsourcedPart("Yellow Paint", 0.50, 51, 15, 90);
            OutsourcedPart bluePaint = new OutsourcedPart("Blue Paint", 0.50, 44, 10, 80);
            InhousePart inkRefill = new InhousePart("Ink Refill", 2.50, 98, 30, 120);
            InhousePart penBody = new InhousePart("Pen Body", 10.50, 75, 25, 110);

            outsourcedpartService.save(redPaint);
            outsourcedpartService.save(yellowPaint);
            outsourcedpartService.save(bluePaint);
            inhousepartService.save(inkRefill);
            inhousepartService.save(penBody);

            // Create and save sample products
            Product redPen = new Product("Red Pen", 19.99, 55);
            Product orangePen = new Product("Orange Pen", 19.99, 73);
            Product yellowPen = new Product("Yellow Pen", 19.99, 62);
            Product greenPen = new Product("Green Pen", 19.99, 41);
            Product bluePen = new Product("Blue Pen", 19.99, 25);
//            Product purplePen = new Product("Purple Pen", 19.99, 32); *Commented out to have exactly 5 products.

            productService.save(redPen);
            productService.save(orangePen);
            productService.save(yellowPen);
            productService.save(greenPen);
            productService.save(bluePen);
//            productService.save(purplePen); *Commented out to have exactly 5 products.
        }
   }
    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") Long productId, Model model) {
        // Get the product and decrement the inventory
        Product product = productService.findById(productId.intValue());
        if (product != null) {
            if (product.getInv() > 0) {
                product.setInv(product.getInv() - 1);
                productService.save(product);
                model.addAttribute("message", "Purchase successful!");
            } else {
                model.addAttribute("message", "Sorry, this item is out of stock.");
            }
        } else {
            model.addAttribute("message", "Purchase failed. Product not found.");
        }

        // Refresh the products and parts list
        listPartsandProducts(model, null, null);
        return "mainscreen";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/login";
    }

}
