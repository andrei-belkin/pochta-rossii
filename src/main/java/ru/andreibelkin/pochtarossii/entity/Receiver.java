package ru.andreibelkin.pochtarossii.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Получатель extends ПунктНазначения {
    private String фамилия, имя, отчество;
    private List<Посылка> посылки;
}
