package ru.andreibelkin.pochtarossii.repository;

import org.springframework.stereotype.Repository;
import ru.andreibelkin.pochtarossii.entity.Shipment;

import java.util.Optional;

@Repository
public interface ShipmentRepository {
    Shipment save(Shipment shipment);
    Shipment update(Shipment shipment);
    Optional<Shipment> find(int shipmentId);
}
