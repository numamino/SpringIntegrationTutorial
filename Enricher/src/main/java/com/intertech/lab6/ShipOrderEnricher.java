package com.intertech.lab6;

import com.intertech.domain.Shiporder;
import org.springframework.messaging.Message;

public class ShipOrderEnricher {

    public double computeTotal(Message<Shiporder> order) {
        double sum = 0;
        for (Shiporder.Item item : order.getPayload().getItem()) {
            sum = sum + (item.getPrice().doubleValue() * item.getQuantity().intValue()) ;
        }
        return sum;
    }
}
