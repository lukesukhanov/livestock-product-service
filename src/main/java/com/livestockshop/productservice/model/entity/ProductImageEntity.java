package com.livestockshop.productservice.model.entity;

import java.sql.Blob;

import com.livestockshop.productservice.repository.ProductImageRepository;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A product's image entity.
 * <p>
 * The {@code equals} method should be used for comparisons.
 * The {@code ProductImageEntity} objects are compared by {@code id}.
 * The {@code ProductImageEntity} with {@code id = null} is equal only to
 * itself.
 * <p>
 * The {@code hashCode} method always returns the same value.
 * <p>
 * This class is not immutable and is not supposed to be used concurrently.
 * 
 * @see ProductImageRepository
 */
@Entity
@Table(name = "PRODUCT_IMAGE")
@NamedEntityGraph(
    name = "productImage.withImage",
    attributeNodes = @NamedAttributeNode(value = ProductImageEntity_.IMAGE))
@NamedQuery(name = "find_ids_of_images_by_product_id",
    query = "select id from ProductImageEntity where product.id = :productId")
@NoArgsConstructor
@Getter
@Setter
public class ProductImageEntity {

  public static final String ENTITY_GRAPH_WITH_IMAGE = "productImage.withImage";

  public static final String JPQL_FIND_IDS_OF_IMAGES_BY_PRODUCT_ID = "find_ids_of_images_by_product_id";

  @Id
  @GeneratedValue(generator = "common_id_seq")
  @SequenceGenerator(name = "common_id_seq", sequenceName = "COMMON_ID_SEQ", allocationSize = 5)
  @Column(name = "ID", updatable = false)
  private Long id;

  @Lob
  @Basic(fetch = FetchType.LAZY)
  @Column(name = "IMAGE")
  private Blob image;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PRODUCT_ID")
  private ProductEntity product;

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ProductImageEntity)) {
      return false;
    }
    ProductImageEntity other = (ProductImageEntity) o;
    return this.id != null && this.id.equals(other.getId());
  }
}
