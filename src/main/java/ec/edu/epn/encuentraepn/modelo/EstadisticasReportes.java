package ec.edu.epn.encuentraepn.modelo;

import java.util.List;
import java.util.Map;

/**
 * HU-13: cuántos reportes hay por categoría y por zona del campus, de mayor a menor cantidad.
 */
public class EstadisticasReportes {

    private final List<Reporte> reportes;

    public EstadisticasReportes(List<Reporte> reportes) {
        this.reportes = reportes;
    }

    public Map<String, Long> porCategoria() {
        return Map.of();
    }

    public Map<String, Long> porZona() {
        return Map.of();
    }
}
