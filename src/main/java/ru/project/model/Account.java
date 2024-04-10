package ru.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Entity
@Table(name="account")
@Setter
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="account_pool_id")
    private Long accountPoolId;

    @Size(max=25)
    @Column(name="account_number")
    private String accountNumber;

    @Column(name="bussy")
    private Boolean busy;
}
