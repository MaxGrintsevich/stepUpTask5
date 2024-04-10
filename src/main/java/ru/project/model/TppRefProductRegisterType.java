package ru.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
@Builder
@Entity
@Setter
@Getter
@Table(name="tpp_ref_product_register_type")
@NoArgsConstructor
@AllArgsConstructor
public class TppRefProductRegisterType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="internal_id")
    private Long internalId;

    @Column(name="value", nullable=false, unique=true)
    @Size(max=100)
    private String value;

    @Size(max=100)
    @Column(name="register_type_name", nullable = false)
    private String registerTypeName;

    @Size(max=100)
    @Column(name="product_class_code", nullable = false)
    private String productClassCode;

    @Column(name="register_type_start_date")
    private Date registerTypeStartDate;

    @Column(name="register_type_end_date")
    private Date registerTypeEndDate;

    @Size(max=100)
    @Column(name="account_type")
    private String accountType;
}
