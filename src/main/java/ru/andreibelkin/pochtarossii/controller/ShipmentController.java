package ru.andreibelkin.pochtarossii.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.andreibelkin.pochtarossii.dto.*;
import ru.andreibelkin.pochtarossii.service.ShippingService;

@Controller
@RequestMapping("/shipments")
public class ShipmentController {
    private final ShippingService shippingService;

    public ShipmentController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping("/track/{id}")
    public ResponseEntity<ShipmentHistoryReturnDTO> getShipmentHistory(@PathVariable int id) {
        ShipmentHistoryReturnDTO dto = shippingService.getShipmentHistory(id);
        return (dto != null) ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public ResponseEntity<ShipmentCreationReturnDTO> registerNewShipment(@RequestBody ShipmentCreationInputDTO shipmentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(shippingService.registerNewShipment(shipmentDto));
    }

    @PutMapping("/update")
    public ResponseEntity<ShipmentEventCreationReturnDTO> updateShipment(@RequestBody ShipmentEventCreationInputDTO shipmentDto) {
        return ResponseEntity.ok(shippingService.registerNextEvent(shipmentDto));
    }
}
