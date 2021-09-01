package ru.andreibelkin.pochtarossii.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import ru.andreibelkin.pochtarossii.util.ТипПосылки;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Посылка {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int идентификатор;
    private ТипПосылки типПосылки;
    @Column(name = "receiver")
    @OneToOne(mappedBy = "идентификатор")
    private int получатель;
    private ПочтовоеОтделение почтовоеОтделение;
    private List<ПроисшествиеПосылки> происшествияПосылки;

    public Посылка(ТипПосылки типПосылки, Получатель получатель) {
        this.типПосылки = типПосылки;
        this.получатель = получатель;
    }

    /**
     *
     * @param происшествие Что произошло с посылкой - была послана, прибыла, убыла, была получена
     */
    public void добавитьПроисшествие(ПроисшествиеПосылки происшествие) {
        происшествияПосылки.add(происшествие);
    }
}
