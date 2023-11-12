package com.git.judice.sale.adapters.out;

import com.git.judice.sale.adapters.out.Repository.SaleRepository;
import com.git.judice.sale.adapters.out.Repository.mapper.SaleEntityMapper;
import com.git.judice.sale.application.core.domain.Sale;
import com.git.judice.sale.application.ports.out.FindSaleByIdOutputPort;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindSaleByIdAdapter implements FindSaleByIdOutputPort {

    private final SaleRepository saleRepository;

    private final SaleEntityMapper saleEntityMapper;

    @Override
    public Optional<Sale> find(Integer id) {
        var saleEntity = saleRepository.findById(id);
        return saleEntity.map(saleEntityMapper::toSale);
    }

}