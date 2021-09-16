package ru.andreibelkin.pochtarossii.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.andreibelkin.pochtarossii.entity.Shipment;
import ru.andreibelkin.pochtarossii.entity.ShippingEvent;

import java.util.List;

@Data
@AllArgsConstructor
public class ShipmentHistoryReturnDTO {
    private int shipmentId;
    private Shipment.ShipmentType shipmentType;
    private List<ShippingEventDTO> shippingEvents;
    private String receiverName, receiverIndex, receiverAddress;
}
