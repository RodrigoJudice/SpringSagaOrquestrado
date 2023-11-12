package com.git.judice.payment.adapters.out;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.git.judice.payment.adapters.out.message.SaleMessage;
import com.git.judice.payment.application.core.domain.Sale;
import com.git.judice.payment.application.core.domain.enums.SaleEvent;
import com.git.judice.payment.application.ports.out.SendToKafkaOutputPort;

import lombok.RequiredArgsConstructor;

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