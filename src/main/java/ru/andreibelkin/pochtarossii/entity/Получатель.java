package ru.andreibelkin.pochtarossii.entity;

import lombok.Data;

@Data
public class Получатель {
    private int идентификатор;
    private String фамилия, имя, отчество;
}
