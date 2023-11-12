package com.git.judice.sale.application.core.usecase;

import org.springframework.stereotype.Component;

import com.git.judice.sale.application.core.domain.Sale;
import com.git.judice.sale.application.core.domain.enums.SaleStatus;
import com.git.judice.sale.application.ports.in.CancelSaleInputPort;
import com.git.judice.sale.application.ports.in.FindSaleByIdInputPort;
import com.git.judice.sale.application.ports.out.SaveSaleOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CancelSaleUseCase implements CancelSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;

    private final SaveSaleOutputPort saveSaleOutputPort;

    @Override
    public void cancel(Sale sale) {
        var saleResponse = findSaleByIdInputPort.find(sale.getId());
        saleResponse.setStatus(SaleStatus.CANCELED);
        saveSaleOutputPort.save(saleResponse);
    }

}