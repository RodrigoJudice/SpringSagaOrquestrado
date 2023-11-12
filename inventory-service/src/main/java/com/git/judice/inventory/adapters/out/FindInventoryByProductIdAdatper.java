package com.git.judice.inventory.adapters.out;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.git.judice.inventory.adapters.out.repository.InventoryRepository;
import com.git.judice.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.git.judice.inventory.application.core.domain.Inventory;
import com.git.judice.inventory.application.ports.out.FindInventoryByProductIdOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindInventoryByProductIdAdatper implements FindInventoryByProductIdOutputPort {

  private final InventoryRepository inventoryRepository;
  private final InventoryEntityMapper inventoryEntityMapper;

  @Override
  public Optional<Inventory> find(Integer productId) {

    var inventoryEntity = inventoryRepository.findByProductId(productId);

    return inventoryEntity.map(inventoryEntityMapper::toInventory);

  }

}
