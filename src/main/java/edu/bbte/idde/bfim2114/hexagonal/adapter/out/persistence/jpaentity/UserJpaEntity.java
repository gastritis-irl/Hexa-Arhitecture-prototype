package edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.jpaentity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "users")
@NoArgsConstructor
public class UserJpaEntity extends BaseEntity {

    @Column(unique = true, name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 1000)
    private String password;
}
