package co.chepito.seguros.seguroschepitoapiprocesador.domain.productos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeguroDomain {

    private UUID seguroId;
    private String nombre;
    private String campo;
    private String responsableLegal;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private String tipo;
    private Set<CoberturaDomain> cobertura = new HashSet<>();
    private Set<ReglasDomain> reglas = new HashSet<>();
    private Set<ClausulaDomain> clausula = new HashSet<>();

}