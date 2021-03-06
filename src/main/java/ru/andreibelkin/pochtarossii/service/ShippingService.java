package ru.andreibelkin.pochtarossii.service;

import org.springframework.stereotype.Service;
import ru.andreibelkin.pochtarossii.dto.*;
import ru.andreibelkin.pochtarossii.entity.*;
import ru.andreibelkin.pochtarossii.repository.ShipmentRepository;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShippingService {
    private final ShipmentRepository shipmentRepository;

    public ShippingService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public ShipmentHistoryReturnDTO getShipmentHistory(int id) {
        Optional<Shipment> shipmentOpt = shipmentRepository.find(id);
        if (shipmentOpt.isEmpty())
            return null;
        Shipment shipment = shipmentOpt.get();
        Receiver receiver = shipment.getReceiver();

        List<ShippingEventDTO> shippingEvents = new ArrayList<>();
        for (ShippingEvent event : shipment.getShippingEvents()) {
            shippingEvents.add(new ShippingEventDTO(
                    event.getShipmentStatus(),
                    event.getTimestamp(),
                    event.getDestination().getCompleteName(),
                    event.getDestination().getIndex(),
                    event.getDestination().getAddress()
            ));
        }

        return new ShipmentHistoryReturnDTO(
                id,
                shipment.getShipmentType(),
                shippingEvents,
                receiver.getCompleteName(),
                receiver.getIndex(),
                receiver.getAddress()
        );
    }

    public ShipmentCreationReturnDTO registerNewShipment(ShipmentCreationInputDTO shipmentDto) {
        Shipment createdShipment = shipmentRepository.save(new Shipment(shipmentDto.getShipmentType(), shipmentDto.getReceiver()));
        return new ShipmentCreationReturnDTO(createdShipment.getId());
    }

    public ShipmentEventCreationReturnDTO registerNextEvent(ShipmentEventCreationInputDTO shipmentDto) {
        Optional<Shipment> shipmentOpt = shipmentRepository.find(shipmentDto.getShipmentId());
        if (shipmentOpt.isEmpty())
            return new ShipmentEventCreationReturnDTO(-1, ShippingEvent.ShipmentStatus.????_????????????????????);
        Shipment shipment = shipmentOpt.get();

        ShippingEvent.ShipmentStatus shipmentNextStatus = shipment.getLatestShippingEvent().getShipmentStatus().getNextStatus();
        Destination destination;
        switch (shipmentNextStatus) {
            case ??????????????????????:
            case ??????????????????_??????????????????:
                destination = new Receiver(
                        shipmentDto.getDestinationName(),
                        shipmentDto.getDestinationIndex(),
                        shipmentDto.getDestinationAddress()
                );
                break;
            case ????????????????_????????_??????????:
            case ????????????_????????_??????????:
                destination = new MailPost(
                        shipmentDto.getDestinationName(),
                        shipmentDto.getDestinationIndex(),
                        shipmentDto.getDestinationAddress()
                );
                break;
            case ????_????????????????????:
                throw new NullPointerException(String.format("?????????????????? ???????????? - ?????????????? ???????? ?????????????? ?? ????, ???? ???? ???????????? ???????????????? (%s): %s", shipmentNextStatus, shipment));
            default:
                throw new NullPointerException(String.format("?????????????????? ???????????? - ???? ?????? ?????????????????? ???????????? ?????????????? (%s): %s", shipmentNextStatus, shipment));
        }

        ShippingEvent shippingEvent = new ShippingEvent(
                shipmentNextStatus,
                ZonedDateTime.now(),
                destination,
                shipment
        );
        shipment.addShippingEvent(shippingEvent);
        Shipment updatedShipment = shipmentRepository.update(shipment);

        return new ShipmentEventCreationReturnDTO(updatedShipment.getId(), updatedShipment.getLatestShippingEvent().getShipmentStatus());
    }
}
