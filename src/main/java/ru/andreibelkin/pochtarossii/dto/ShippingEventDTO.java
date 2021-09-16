package ru.andreibelkin.pochtarossii.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.andreibelkin.pochtarossii.entity.ShippingEvent;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class ShippingEventDTO {
    private ShippingEvent.ShipmentStatus shipmentStatus;
    private ZonedDateTime timestamp;
    private String destinationName, destinationIndex, destinationAddress;
}
