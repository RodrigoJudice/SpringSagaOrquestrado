package com.git.judice.orchestrator.adapters.out;

import com.git.judice.orchestrator.adapters.out.message.SaleMessage;
import com.git.judice.orchestrator.application.core.domain.Sale;
import com.git.judice.orchestrator.application.core.domain.enums.SaleEvent;
import com.git.judice.orchestrator.application.ports.out.SendSaleToTopicOutputPort;

import lombok.RequiredArgsConstructor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendSaleToTopicAdapter implements SendSaleToTopicOutputPort {

  private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

  @Override
  public void send(Sale sale, SaleEvent saleEvent, String topic) {
    var saleMessage = new SaleMessage(sale, saleEvent);
    kafkaTemplate.send(topic, saleMessage);
  }

}