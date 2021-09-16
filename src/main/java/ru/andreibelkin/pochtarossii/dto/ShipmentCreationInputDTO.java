package ru.andreibelkin.pochtarossii.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.andreibelkin.pochtarossii.entity.Receiver;
import ru.andreibelkin.pochtarossii.entity.Shipment;

@Data
@AllArgsConstructor
public class ShipmentCreationInputDTO {
    private Shipment.ShipmentType shipmentType;
    private Receiver receiver;
}
