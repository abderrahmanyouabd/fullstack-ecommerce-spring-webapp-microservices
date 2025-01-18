package com.a1st.ecom.order.clients;

import com.a1st.ecom.order.exceptions.BusinessException;
import com.a1st.ecom.order.request.PurchaseRequest;
import com.a1st.ecom.order.response.PurchaseResponse;
import jakarta.ws.rs.core.HttpHeaders;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
@Component
@RequiredArgsConstructor
public class ProductClient {

    @Value("${application.config.product-url}")
    private String PRODUCT_URL;
    private final WebClient webClient = WebClient.builder().baseUrl(PRODUCT_URL).build();


    public List<PurchaseResponse> purchaseProduct(@RequestBody List<PurchaseRequest> purchaseRequests) {
        return webClient.post()
                .uri("/purchase")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(purchaseRequests))
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(error -> Mono.error(new BusinessException(String.format("An error occurred while processing the product purchase: %d::%s",clientResponse.statusCode().value(), error)))))
                .bodyToFlux(PurchaseResponse.class)
                .collectList()
                .block();
    }





}
