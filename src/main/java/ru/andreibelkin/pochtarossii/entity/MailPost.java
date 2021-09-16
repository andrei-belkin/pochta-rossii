package ru.andreibelkin.pochtarossii.entity;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class MailPost extends Destination implements Serializable {
    public MailPost(String name, String index, String address) {
        this.setCompleteName(name);
        this.setIndex(index);
        this.setAddress(address);
    }
}
