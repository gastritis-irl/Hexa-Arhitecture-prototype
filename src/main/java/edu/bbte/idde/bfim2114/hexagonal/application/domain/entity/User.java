package edu.bbte.idde.bfim2114.hexagonal.application.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseEntity{

    private String password;
    private String email;
    private String role;
}
