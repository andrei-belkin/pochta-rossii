package ru.andreibelkin.pochtarossii.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShipmentEventCreationInputDTO {
    private int shipmentId;
    private String destinationName, destinationIndex, destinationAddress;
}
