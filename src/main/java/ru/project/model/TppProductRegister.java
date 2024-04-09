package ru.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tpp_product_register")
@Setter
@Getter
@AllArgsConstructor
public class TppProductRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="product_id")
    Long productId;

    @Column(name="type", nullable = false)
    @Size(max=100)
    String type;

    @Column(name="account")
    Long account;

    @Size(max=30)
    @Column(name="currency_code")
    String currencyCode;

    @Size(max=50)
    @Column(name="state")
    String state;

    @Size(max=25)
    @Column(name="account_number")
    String accountNumber;
}
