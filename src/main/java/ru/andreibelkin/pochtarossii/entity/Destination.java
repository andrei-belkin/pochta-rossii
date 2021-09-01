package ru.andreibelkin.pochtarossii.entity;

import lombok.Data;

@Data
public abstract class ПунктНазначения {
    private int идентификатор;
    private String индекс, адрес;
}
