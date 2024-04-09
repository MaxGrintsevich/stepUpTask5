package ru.project.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Entity
@Table(name="tpp_product")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TppProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="product_code_id")
    Long productCodeId;

    @Column(name="client_id")
    String clientId;

    @Column(name="type")
    String type;

    @Column(name="number")
    String number;

    @Column(name="priority")
    String priority;

    @Column(name="date_of_conclusion")
    Date dateOfConclusion;

    @Column(name="start_date_time")
    Date startDateTime;

    @Column(name="end_date_time")
    Date endDateTime;

    @Column(name="days")
    Long days;

    @Column(name="penalty_rate")
    BigDecimal penaltyRate;

    @Column(name="nso")
    BigDecimal nso;

    @Column(name="threshold_amount")
    BigDecimal thresholdAmount;

    @Column(name="requisite_type")
    String requisiteType;

    @Column(name="interest_rate_type")
    String interestRateType;

    @Column(name="tax_rate")
    BigDecimal taxRate;

    @Column(name="reasone_close")
    String reasonClose;

    @Column(name="state")
    String state;

    /*@Column(name="branch_code")
    @Size(max=50)
    String branchCode;*/

}
