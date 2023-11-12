package com.git.judice.inventory.application.core.usecase;

import org.springframework.stereotype.Component;

import com.git.judice.inventory.application.core.domain.Inventory;
import com.git.judice.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.git.judice.inventory.application.ports.out.FindInventoryByProductIdOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindInventoryByProductIdUseCase implements FindInventoryByProductIdInputPort {

  private final FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort;

  @Override
  public Inventory find(Integer productId) {
    return findInventoryByProductIdOutputPort.find(productId)
        .orElseThrow(() -> new RuntimeException("Inventory not found"));

  }

}
