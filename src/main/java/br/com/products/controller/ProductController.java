package br.com.products.controller;

import br.com.products.dto.ProductDTO;
import br.com.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> create(@RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> get(@PathVariable Long id) {
        ProductDTO productDTO = productService.getProduct(id);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping
    public List<ProductDTO> getAll(){
        return productService.getAllProducts();
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        productDTO.setId(id);
        productService.updateProduct(id, productDTO);
        return ResponseEntity.ok("Product updated successfully.");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully.");
    }
}
