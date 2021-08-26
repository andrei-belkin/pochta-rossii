package ru.andreibelkin.pochtarossii.entity;

import lombok.Data;
import ru.andreibelkin.pochtarossii.util.ТипПосылки;

@Data
public class Посылка {
    private int идентификатор;
    private ТипПосылки типПосылки;
    private Получатель получатель;
}
