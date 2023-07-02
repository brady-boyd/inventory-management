package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class EnufPartsValidator implements ConstraintValidator<ValidEnufParts, Product> {
    @Autowired
    private ApplicationContext context;
    public static ApplicationContext myContext;

    @Override
    public void initialize(ValidEnufParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        if (context == null) return true;
        if (context != null) myContext = context;
        ProductService repo = myContext.getBean(ProductServiceImpl.class);
        Product myProduct;
        if (product.getId() != 0) {
            myProduct = repo.findById((int) product.getId());
        } else {
            myProduct = product;
        }
        for (Part p : myProduct.getParts()) {
            int inventoryDifference = product.getInv() - myProduct.getInv();
            int proposedInventory = p.getInv();
            if (inventoryDifference > 0) { // If we are increasing product inventory
                proposedInventory = p.getInv() - inventoryDifference; // Decrease part inventory
            }
            // Check if the proposed inventory is less than the minimum inventory of the part
            if (proposedInventory < p.getMinInv()) {
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory of " + p.getName() + " would be too low (" + proposedInventory + ") to create that many products. Minimum inventory is " + p.getMinInv() + ".")
                        .addConstraintViolation();
                return false;
            }
        }
        return true;
    }

}
