package com.git.judice.inventory.application.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

  private Integer id;
  private Integer productId;
  private Integer quantity;

  public void debitQuantity(Integer quantity) {
    if (this.quantity < quantity) {
      throw new RuntimeException("Insufficient inventory");
    }
    this.quantity -= quantity;
  }

  public void creditQuantity(Integer quantity) {
    this.quantity += quantity;
  }

}
