package com.livestockshop.productservice.service;

import java.util.List;

import com.livestockshop.productservice.dto.Product;

public interface ProductService {
  
  List<Product> getPagedAndFiltered(String category);
}
