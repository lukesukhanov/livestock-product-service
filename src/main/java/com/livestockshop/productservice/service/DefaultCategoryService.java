package com.livestockshop.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livestockshop.productservice.model.entity.CategoryEntity;
import com.livestockshop.productservice.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

/**
 * The default {@code CategoryService} implementation.
 */
@Service
@RequiredArgsConstructor
public class DefaultCategoryService implements CategoryService {

  private final CategoryRepository categoryRepository;

  @Transactional(readOnly = true)
  @Override
  public List<CategoryEntity> getAll() {
    return this.categoryRepository.findAll();
  }
}
