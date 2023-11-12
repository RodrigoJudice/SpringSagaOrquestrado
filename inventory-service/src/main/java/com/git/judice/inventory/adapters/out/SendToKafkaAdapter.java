package com.git.judice.inventory.adapters.out;

import com.git.judice.inventory.adapters.out.message.SaleMessage;
import com.git.judice.inventory.application.core.domain.Sale;
import com.git.judice.inventory.application.core.domain.enums.SaleEvent;
import com.git.judice.inventory.application.ports.out.SendToKafkaOutputPort;

import lombok.RequiredArgsConstructor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendToKafkaAdapter implements SendToKafkaOutputPort {

  private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

  @Override
  public void send(Sale sale, SaleEvent event) {
    var saleMessage = new SaleMessage(sale, event);
    kafkaTemplate.send("tp-saga-orchestrator", saleMessage);
  }

}