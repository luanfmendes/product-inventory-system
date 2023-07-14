package br.com.products.service;

import br.com.products.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    void createProduct(ProductDTO productDTO);

    ProductDTO getProduct(Long id);

    void updateProduct(Long id, ProductDTO productDTO);

    void deleteProduct(Long id);

    List<ProductDTO> getAllProducts();
}
