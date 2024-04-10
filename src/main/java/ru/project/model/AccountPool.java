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
    private Long id;
    @Size(max=50)
    @Column(name="branch_code")
    private String branchCode;

    @Size(max=30)
    @Column(name="currency_code")
    private String currencyCode;

    @Size(max=50)
    @Column(name="mdm_code")
    private String mdmCode;

    @Size(max=30)
    @Column(name="priority_code")
    private String priorityCode;

    @Size(max=50)
    @Column(name="registry_type_code")
    private String registryTypeCode;
}
