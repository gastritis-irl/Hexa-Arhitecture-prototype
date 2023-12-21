package edu.bbte.idde.bfim2114.hexagonal.application.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class HardwarePart extends BaseEntity {

    private String name;
    private String manufacturer;
    private String category;
    private String price;
    private String description;
    private User user;
}
