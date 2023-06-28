package com.livestockshop.productservice.model.entity;

import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

import com.livestockshop.productservice.repository.ProductRepository;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A product entity.<br />
 * <p>
 * The {@code equals} method should be used for comparisons.
 * The {@code ProductEntity} objects are compared by {@code id}.
 * The {@code ProductEntity} with {@code id = null} is equal only to itself.
 * <p>
 * The {@code hashCode} method always returns the same value.
 * <p>
 * This class is not immutable and is not supposed to be used concurrently.
 * 
 * @see ProductRepository
 */
@Entity
@Table(name = "PRODUCT")
@DynamicUpdate
@NamedEntityGraph(
    name = "product.withCategory.withIdsOfImages",
    attributeNodes = {
        @NamedAttributeNode(value = ProductEntity_.CATEGORY),
        @NamedAttributeNode(value = ProductEntity_.IDS_OF_IMAGES)
    })
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity {

  public static final String ENTITY_GRAPH_WITH_CATEGORY_AND_IDS_OF_IMAGES = "product.withCategory.withIdsOfImages";

  @Id
  @GeneratedValue(generator = "common_id_seq")
  @SequenceGenerator(name = "common_id_seq", sequenceName = "COMMON_ID_SEQ", allocationSize = 5)
  @Column(name = "ID", updatable = false)
  private Long id;

  @Column(name = "PRODUCT_NAME")
  private String productName;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "QUANTITY")
  private Integer quantity;

  @Column(name = "PRICE")
  private Double price;

  @Column(name = "CURRENCY")
  private String currency;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CATEGORY_ID")
  private CategoryEntity category;

  @ElementCollection
  @CollectionTable(name = "PRODUCT_IMAGE", joinColumns = @JoinColumn(name = "PRODUCT_ID"))
  @Column(name = "ID")
  private Set<Long> idsOfImages;

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ProductEntity)) {
      return false;
    }
    ProductEntity other = (ProductEntity) o;
    return this.id != null && this.id.equals(other.getId());
  }
}
