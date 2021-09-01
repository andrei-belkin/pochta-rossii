package ru.andreibelkin.pochtarossii.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ПочтовоеОтделение extends ПунктНазначения {
    private String название;
}
