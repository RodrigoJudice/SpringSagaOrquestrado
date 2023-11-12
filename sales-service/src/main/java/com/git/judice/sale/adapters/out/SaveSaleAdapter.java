package com.git.judice.sale.adapters.out;

import com.git.judice.sale.adapters.out.Repository.mapper.SaleEntityMapper;
import com.git.judice.sale.application.ports.out.SaveSaleOutputPort;
import com.git.judice.sale.application.core.domain.Sale;
import com.git.judice.sale.adapters.out.Repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SaveSaleAdapter implements SaveSaleOutputPort {

    private final SaleRepository saleRepository;
    private final SaleEntityMapper saleEntityMapper;

    @Override
    public Sale save(Sale sale) {
        var saleEntityResponse = saleRepository.save(saleEntityMapper.toEntity(sale));
        return saleEntityMapper.toSale(saleEntityResponse);
    }
}
