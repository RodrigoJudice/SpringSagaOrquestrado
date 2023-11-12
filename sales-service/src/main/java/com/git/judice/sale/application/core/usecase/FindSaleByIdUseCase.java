package com.git.judice.sale.application.core.usecase;

import com.git.judice.sale.application.core.domain.Sale;
import com.git.judice.sale.application.ports.in.FindSaleByIdInputPort;
import com.git.judice.sale.application.ports.out.FindSaleByIdOutputPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindSaleByIdUseCase implements FindSaleByIdInputPort {

    private final FindSaleByIdOutputPort findSaleByIdOutputPort;

    @Override
    public Sale find(final Integer id) {
        return findSaleByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada!"));
    }

}