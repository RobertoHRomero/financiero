package com.contaduria.movimientofinanciero.entities

import lombok.*
import org.hibernate.validator.constraints.Range
import org.jetbrains.annotations.NotNull
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table( uniqueConstraints = [(UniqueConstraint(columnNames = ["number","year","codeOrganism"]))])
class AdministrativeDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0

    @NotNull
    @Range(min=1000,max=9999)
    var codeOrganism:Int = 0

    @NotNull
    @Positive(message="el número debe ser positivo mayor a cero")
    var number:Int = 0

    @NotNull
    @Range(min=2016,max=2099,message = "el año del Expediente no debe ser inferior a 2016, ni superior a 2099")
    var year:Int =0

    @NotBlank(message="La descripción no debe estar vacía")
    var description:String =" "

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "administrative_document_id")
    var fundRequests: List<FundRequest> = arrayListOf<FundRequest>()


//Expedientes

}