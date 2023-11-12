package com.git.judice.sale.adapters.out.Repository.mapper;

import com.git.judice.sale.adapters.out.Repository.entity.SaleEntity;
import com.git.judice.sale.application.core.domain.Sale;
import com.git.judice.sale.application.core.domain.enums.SaleStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SaleEntityMapper {

    @Mapping(source = "status", target = "statusId", qualifiedByName = "setStatusId")
    SaleEntity toEntity(Sale sale);

    @Mapping(source = "statusId", target = "status", qualifiedByName = "setStatus")
    Sale toSale(SaleEntity saleEntity);

    @Named("setStatusId")
    default Integer setStatusId(SaleStatus saleStatus) {
        return saleStatus.getStatusId();
    }

    @Named("setStatus")
    default SaleStatus setStatus(Integer statusId) {
        return SaleStatus.toEnum(statusId);
    }
}
