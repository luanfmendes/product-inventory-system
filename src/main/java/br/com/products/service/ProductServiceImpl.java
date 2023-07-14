package br.com.products.service;

import br.com.products.dto.ProductDTO;
import br.com.products.entity.Product;
import br.com.products.exception.ProductDoesNotExistException;
import br.com.products.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;
    @Override
    public void createProduct(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        repository.save(product);
    }

    @Override
    public ProductDTO getProduct(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductDoesNotExistException(id));
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    @Override
    public void updateProduct(Long id, ProductDTO productDTO) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductDoesNotExistException(id));
        BeanUtils.copyProperties(productDTO, product);
        repository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductDoesNotExistException(id));
        repository.delete(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = repository.findAll();
        List<ProductDTO> productsDTO = new ArrayList<>();
        for (Product product : products) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(product, productDTO);
            productsDTO.add(productDTO);
        }
        return productsDTO;
    }
}
