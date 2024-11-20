package co.chepito.seguros.seguroschepitoapiprocesador.data.entity.productos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name="seguro")
public class SeguroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "seguro_id", nullable = false)
    private UUID seguroId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "campo", nullable = false )
    private String campo;

    @Column(name = "responsable_legal", nullable = false)
    private String responsableLegal;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private Date fechaFin;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "seguro_cobertura",
            joinColumns = @JoinColumn(name = "seguro_id", referencedColumnName = "seguro_id"),
            inverseJoinColumns = @JoinColumn(name = "cobertura_id", referencedColumnName = "cobertura_id")
    )
    private Set<CoberturaEntity> cobertura = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "seguro_reglas",
            joinColumns = @JoinColumn(name = "seguro_id", referencedColumnName = "seguro_id"),
            inverseJoinColumns = @JoinColumn(name = "reglas_id", referencedColumnName = "reglas_id")
    )
    private Set<ReglasEntity> reglas = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "seguro_clausula",
            joinColumns = @JoinColumn(name = "seguro_id", referencedColumnName = "seguro_id"),
            inverseJoinColumns = @JoinColumn(name = "clausula_id", referencedColumnName = "clausula_id")
    )
    private Set<ClausulaEntity> clausula = new HashSet<>();

}