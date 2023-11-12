package com.git.judice.sale.adapters.in.controller.mapper;

import com.git.judice.sale.adapters.in.controller.request.SaleRequest;
import com.git.judice.sale.application.core.domain.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "value", ignore = true)
    Sale toSale(SaleRequest saleRequest);
}
