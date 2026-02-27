
package com.eventmaster;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentProcessorTest {

    @Test
    void shouldApprovePaymentEvent() {
        PaymentProcessor processor = new PaymentProcessor();
        String result = processor.process("ORDER123");
        assertEquals("PAYMENT_APPROVED:ORDER123", result);
    }
}
