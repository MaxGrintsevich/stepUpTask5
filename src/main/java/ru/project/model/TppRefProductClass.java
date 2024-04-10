package ru.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Builder
@Entity
@Setter
@Getter
@Table(name="tpp_ref_product_class")
@NoArgsConstructor
@AllArgsConstructor
public class TppRefProductClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="internal_id")
    private Long internalId;

    @Column(unique = true)
    @NotBlank
    @Size(max=100)
    private String value;

    @Size(max=50)
    @Column(name="gbi_code")
    private String gbiCode;

    @Size(max=100)
    @Column(name="gbi_name")
    private String gbiName;

    @Size(max=50)
    @Column(name="")
    private String productRowCode;

    @Size(max=100)
    @Column(name="")
    private String productRowName;

    @Size(max=50)
    @Column(name="")
    private String subclassCode;

    @Size(max=100)
    @Column(name="subclass_name")
    private String subclassName;

}
