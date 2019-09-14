package io.mcnichol.tdd.controller;

import io.mcnichol.tdd.model.Product;
import io.mcnichol.tdd.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id, @RequestParam(required = false) String category) {
        ResponseEntity<Product> productResponseEntity;

        //We search our  productRepsitory for the requested ID.  An optional is returned which let's us evaluate the logical condition of found  or not found '.isPresent()'
        Optional<Product> byId = productRepository.findById(id);

        if (byId.isPresent()) {
            productResponseEntity = new ResponseEntity<>(byId.get(), HttpStatus.OK);
        } else {
            // There  is  no object so we respond with an empty representation and set the id of the missing representation
            Product product = new Product();
            product.setId(id);

            productResponseEntity = new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
        }

        return productResponseEntity;
    }
}
