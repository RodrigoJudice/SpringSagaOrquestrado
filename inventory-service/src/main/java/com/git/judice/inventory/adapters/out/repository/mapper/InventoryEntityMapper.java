package com.git.judice.inventory.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import com.git.judice.inventory.adapters.out.repository.entity.InventoryEntity;
import com.git.judice.inventory.application.core.domain.Inventory;

@Mapper(componentModel = "spring")
public interface InventoryEntityMapper {

  Inventory toInventory(final InventoryEntity inventoryEntity);

  InventoryEntity toInventoryEntity(final Inventory inventory);
}
