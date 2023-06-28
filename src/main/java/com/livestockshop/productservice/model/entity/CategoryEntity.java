package com.livestockshop.productservice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A product category entity.<br />
 * <p>
 * The {@code equals} method should be used for comparisons.
 * The {@code CategoryEntity} objects are compared by {@code id}.
 * The {@code CategoryEntity} with {@code id = null} is equal only to itself.
 * <p>
 * The {@code hashCode} method always returns the same value.
 * <p>
 * This class is not immutable and is not supposed to be used concurrently.
 */
@Entity
@Table(name = "CATEGORY")
@NoArgsConstructor
@Getter
@Setter
public class CategoryEntity {

  @Id
  @GeneratedValue(generator = "common_id_seq")
  @SequenceGenerator(name = "common_id_seq", sequenceName = "COMMON_ID_SEQ", allocationSize = 5)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "CATEGORY_NAME")
  private String categoryName;

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CategoryEntity)) {
      return false;
    }
    CategoryEntity other = (CategoryEntity) o;
    return this.id != null && this.id.equals(other.getId());
  }
}
