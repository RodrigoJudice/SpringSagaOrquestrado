package com.git.judice.inventory.application.ports.in;

import com.git.judice.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {

    Inventory find(Integer productId);

}
