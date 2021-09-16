package ru.andreibelkin.pochtarossii.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Receiver extends Destination implements Serializable {
    @OneToMany(mappedBy = "receiver")
    @ToString.Exclude
    private List<Shipment> shipments;

    public Receiver(String completeName, String index, String address) {
        this.setCompleteName(completeName);
        this.setIndex(index);
        this.setAddress(address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Receiver receiver = (Receiver) o;
        return Objects.equals(getId(), receiver.getId());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
