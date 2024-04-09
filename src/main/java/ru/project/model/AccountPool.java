package ru.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="account_pool")
@Setter
@Getter
public class AccountPool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Size(max=50)
    @Column(name="branch_code")
    String branchCode;

    @Size(max=30)
    @Column(name="currency_code")
    String currencyCode;

    @Size(max=50)
    @Column(name="mdm_code")
    String mdmCode;

    @Size(max=30)
    @Column(name="priority_code")
    String priorityCode;

    @Size(max=50)
    @Column(name="registry_type_code")
    String registryTypeCode;
}
