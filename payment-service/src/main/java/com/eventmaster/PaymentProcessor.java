
package com.eventmaster;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class PaymentProcessor {

    @Incoming("orders")
    @Outgoing("payments")
    public String process(String orderEvent) {
        return "PAYMENT_APPROVED:" + orderEvent;
    }
}
