package ru.andreibelkin.pochtarossii.entity;

import lombok.Data;
import ru.andreibelkin.pochtarossii.util.СостояниеПосылки;

import java.time.ZonedDateTime;

@Data
public class ПроисшествиеПосылки {
    private СостояниеПосылки состояниеПосылки;
    private ZonedDateTime датаИВремя;
    private ПунктНазначения пунктНазначения;
}
