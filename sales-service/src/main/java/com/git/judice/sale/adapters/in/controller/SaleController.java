package com.git.judice.sale.adapters.in.controller;

import com.git.judice.sale.adapters.in.controller.mapper.SaleRequestMapper;
import com.git.judice.sale.adapters.in.controller.request.SaleRequest;
import com.git.judice.sale.application.ports.in.CreateSaleInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    private final CreateSaleInputPort createSaleInputPort;
    private final SaleRequestMapper saleRequestMapper;
    private static final Logger logger = LoggerFactory.getLogger(SaleController.class);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSale(@Valid @RequestBody SaleRequest saleRequest) {
        logger.info("Creating sale");
        createSaleInputPort.create(saleRequestMapper.toSale(saleRequest));
        logger.info("Sale created");
    }

}
