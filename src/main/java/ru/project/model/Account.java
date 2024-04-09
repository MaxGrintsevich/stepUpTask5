package ru.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="account")
@Setter
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="account_pool_id")
    Long accountPoolId;

    @Size(max=25)
    @Column(name="account_number")
    String accountNumber;

    @Column(name="bussy")
    Boolean busy;
}
