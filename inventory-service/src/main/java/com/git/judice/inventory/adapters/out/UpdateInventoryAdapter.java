package com.git.judice.inventory.adapters.out;

import org.springframework.stereotype.Component;

import com.git.judice.inventory.adapters.out.repository.InventoryRepository;
import com.git.judice.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.git.judice.inventory.application.core.domain.Inventory;
import com.git.judice.inventory.application.ports.out.UpdateInventoryOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateInventoryAdapter implements UpdateInventoryOutputPort {

  private final InventoryRepository inventoryRepository;
  private final InventoryEntityMapper inventoryEntityMapper;

  @Override
  public void update(Inventory inventory) {

    var inventoryEntity = inventoryEntityMapper.toInventoryEntity(inventory);
    inventoryRepository.save(inventoryEntity);
  }

}
