package ru.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="agreement")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="product_id")
    Long productId;

    @Column(name="general_agreement_id")
    String generalAgreementId;

    @Column(name="supplementary_agreement_id")
    String supplementaryAgreementId;

    @Column(name="arrangement_type")
    String arrangementType;

    @Column(name="sheduler_job_id")
    Long schedulerJobId;

    @Column(name="number")
    String number;

    @Column(name="opening_date")
    Date openingDate;

    @Column(name="closing_date")
    Date closingDate;

    @Column(name="cancel_date")
    Date cancelDate;

    @Column(name="validity_duration")
    Long validityDuration;

    @Column(name="cancellation_reason")
    String cancellationReason;

    @Column(name="status")
    String status;

    @Column(name="interest_calculation_date")
    Date interestCalculationDate;

    @Column(name="interest_rate")
    BigDecimal interestRate;

    @Column(name="coefficient")
    BigDecimal coefficient;

    @Column(name="coefficient_action")
    String coefficientAction;

    @Column(name="minimum_interest_rate")
    BigDecimal minimumInterestRate;

    @Column(name="minimum_interest_rate_coefficient")
    BigDecimal minimumInterestRateCoefficient;

    @Column(name="minimum_interest_rate_coefficient_action")
    String minimumInterestRateCoefficientAction;

    @Column(name="maximal_interest_rate")
    BigDecimal maximalInterestRate;

    @Column(name="maximal_interest_rate_coefficient")
    BigDecimal maximalInterestRateCoefficient;

    @Column(name="maximal_interest_rate_coefficient_action")
    String maximalInterestRateCoefficientAction;

}
