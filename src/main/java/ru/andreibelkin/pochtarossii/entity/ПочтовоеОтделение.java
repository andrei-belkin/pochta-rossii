package ru.andreibelkin.pochtarossii.entity;

import lombok.Data;

@Data
public class ПочтовоеОтделение {
    private int идентификатор;
    private String название, индекс, адрес;
}
