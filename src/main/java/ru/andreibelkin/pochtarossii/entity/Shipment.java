package ru.andreibelkin.pochtarossii.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Shipment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private ShipmentType shipmentType;
    @ManyToOne(targetEntity = Receiver.class, optional = false)
    private Receiver receiver;

    @OneToMany(targetEntity = ShippingEvent.class, mappedBy = "shipment")
    @ToString.Exclude
    private List<ShippingEvent> shippingEvents;

    public Shipment(ShipmentType shipmentType, Receiver receiver) {
        this.shipmentType = shipmentType;
        this.receiver = receiver;
    }

    public void addShippingEvent(ShippingEvent shippingEvent) {
        if (shippingEvents == null)
            shippingEvents = new ArrayList<>();
        shippingEvents.add(shippingEvent);
    }

    public ShippingEvent getLatestShippingEvent() {
        return this.getShippingEvents().get(this.getShippingEvents().size() - 1);
    }

    public enum ShipmentType {
        ПИСЬМО, ПОСЫЛКА, БАНДЕРОЛЬ, ОТКРЫТКА
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Shipment shipment = (Shipment) o;
        return Objects.equals(id, shipment.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
