package com.git.judice.inventory.application.ports.out;

import java.util.Optional;

import com.git.judice.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdOutputPort {

    Optional<Inventory> find(final Integer productId);

}
