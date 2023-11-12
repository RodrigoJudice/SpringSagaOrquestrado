package com.git.judice.inventory.application.ports.out;

import com.git.judice.inventory.application.core.domain.Inventory;

/**
 * UpdateInventoryOutputPort
 */
public interface UpdateInventoryOutputPort {

    void update(Inventory inventory);

}