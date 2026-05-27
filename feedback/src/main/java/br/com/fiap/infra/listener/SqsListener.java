package br.com.fiap.infra.listener;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@ApplicationScoped
public class SqsListener {

    private final SqsClient sqsClient;

    public SqsListener(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }

    @Inject
    @ConfigProperty(name = "sqs.queue.url")
    String query;

    public  void enviar(String message) {
        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl(query)
                .messageBody(message)
                .build();

        sqsClient.sendMessage(sendMessageRequest);
    }
}
