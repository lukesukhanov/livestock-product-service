package com.livestockshop.productservice.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

import com.livestockshop.productservice.model.dto.ProductForRead;
import com.livestockshop.productservice.model.entity.ProductEntity;

/**
 * Mappings between model classes associated with products.
 */
@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

  /**
   * Converts {@code ProductEntity} to {@code ProductForRead}.
   * 
   * @param productEntity a {@code ProductEntity} to be converted
   * @return a converted {@code ProductForRead}
   */
  @Mapping(target = "categoryName", source = "category.categoryName")
  ProductForRead productEntityToProductForRead(ProductEntity productEntity);

  /**
   * Converts {@code List<ProductEntity>} to {@code List<ProductForRead>}.
   * 
   * @param productEntities a {@code List<ProductEntity>} to be converted
   * @return a converted {@code List<ProductForRead>}
   */
  List<ProductForRead> productEntityToProductForRead(List<ProductEntity> productEntities);
}
