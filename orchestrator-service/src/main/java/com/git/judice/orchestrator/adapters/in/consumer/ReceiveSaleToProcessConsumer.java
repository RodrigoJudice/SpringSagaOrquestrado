package com.git.judice.orchestrator.adapters.in.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.git.judice.orchestrator.adapters.out.message.SaleMessage;
import com.git.judice.orchestrator.application.ports.in.WorkflowInputPort;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToProcessConsumer {

  private final List<WorkflowInputPort> workflows;

  @KafkaListener(topics = "tp-saga-orchestrator", groupId = "orchestrator")
  public void receive(SaleMessage saleMessage) {
    var workflow = workflows.stream()
        .filter(w -> w.isCalledByTheEvent(saleMessage.getEvent()))
        .findFirst()
        .orElse(null);

    if (workflow != null) {
      workflow.execute(saleMessage.getSale());
    } else {
      log.error("Evento não encontrado.");
    }
  }

}