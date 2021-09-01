package ru.andreibelkin.pochtarossii.entity;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShippingEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private ShipmentStatus shipmentStatus;
    private ZonedDateTime timestamp;
    @ManyToOne(targetEntity = Destination.class)
    private Destination destination;
    @ManyToOne(targetEntity = Shipment.class)
    private Shipment shipment;

    public ShippingEvent(ShipmentStatus shipmentStatus, ZonedDateTime timestamp, Destination destination, Shipment shipment) {
        this.shipmentStatus = shipmentStatus;
        this.timestamp = timestamp;
        this.destination = destination;
        this.shipment = shipment;
    }

    public enum ShipmentStatus {
        НЕ_СУЩЕСТВУЕТ, ОТПРАВЛЕНИЕ, ПРИБЫТИЕ_ПОЧТ_ОТДЕЛ, УБЫТИЕ_ПОЧТ_ОТДЕЛ, ПОЛУЧЕНИЕ_АДРЕСАТОМ;

        public ShipmentStatus getNextStatus() {
            int nextOrdinal = (this.ordinal() + 1) % ShipmentStatus.values().length;
            if (ShipmentStatus.values()[nextOrdinal] == НЕ_СУЩЕСТВУЕТ)
                nextOrdinal++;
            return ShipmentStatus.values()[nextOrdinal];
        }
    }
}
