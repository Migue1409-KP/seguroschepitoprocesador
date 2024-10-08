package co.chepito.seguros.seguroschepitoapiprocesador.domain.usuario.reglas.validaciones;

import co.chepito.seguros.seguroschepitoapiprocesador.domain.usuario.reglas.Validacion;
import co.chepito.seguros.seguroschepitoapiprocesador.utils.UtilidadTexto;
import org.springframework.stereotype.Service;

@Service
public class ValidacionCorreoUsuario implements Validacion<String> {

    @Override
    public void execute(String correo) {

        validarObligatoriedad(correo);
        validarLogitud(correo);
        validarFormato(correo);
    }
    private final void validarObligatoriedad(final String correo) {
        if(UtilidadTexto.esVacio(correo)) {
            throw new RuntimeException("El correo no puede esatr vacio");
        }
    }

    private final void validarLogitud(final String correo) {
        if(!UtilidadTexto.tieneLongitudValida(correo, 11,40)) {
            throw new RuntimeException("La longitud debe estar entre 11 a 40 caracteres");
        }
    }

    private final void validarFormato(final String correo) {
        if(!UtilidadTexto.contieneLetrasDigitosDominio(correo)) {
            throw new RuntimeException("El correo debe tener un formato valido");
        }
    }


}
