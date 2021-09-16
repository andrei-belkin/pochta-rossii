package ru.andreibelkin.pochtarossii.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.andreibelkin.pochtarossii.entity.ShippingEvent;

@Data
@AllArgsConstructor
public class ShipmentEventCreationReturnDTO {
    private int id;
    private ShippingEvent.ShipmentStatus shipmentStatus;
}
