package ec.edu.epn.encuentraepn.modelo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ec.edu.epn.encuentraepn.DatosDePrueba.reporteActivo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Incremento 4: pruebas de las reglas nuevas de la entidad Reporte (HU-11 Retirar un reporte propio).
 */
class ReporteTest {

    @Test
    @DisplayName("Retirar un reporte activo lo deja en estado RETIRADO")
    void retirarUnReporteActivoLoDejaRetirado() {
        Reporte reporte = reporteActivo();

        reporte.retirar();

        assertEquals(EstadoReporte.RETIRADO, reporte.getEstado());
    }

    @Test
    @DisplayName("Un reporte reservado no se puede retirar y sigue RESERVADO")
    void unReporteReservadoNoSePuedeRetirar() {
        Reporte reporte = reporteActivo();
        reporte.reservar();

        assertThrows(IllegalStateException.class, reporte::retirar);
        assertEquals(EstadoReporte.RESERVADO, reporte.getEstado());
    }
}
