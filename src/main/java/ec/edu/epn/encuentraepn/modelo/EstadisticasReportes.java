package ec.edu.epn.encuentraepn.modelo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * HU-13: cuántos reportes hay por categoría y por zona del campus, de mayor a menor cantidad.
 */
public class EstadisticasReportes {

    private final List<Reporte> reportes;

    public EstadisticasReportes(List<Reporte> reportes) {
        this.reportes = reportes;
    }

    public Map<String, Long> porCategoria() {
        Map<String, Long> conteo = reportes.stream()
                .collect(Collectors.groupingBy(reporte -> reporte.getCategoria().getNombre(), Collectors.counting()));
        Map<String, Long> ordenado = new LinkedHashMap<>();
        conteo.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(entrada -> ordenado.put(entrada.getKey(), entrada.getValue()));
        return ordenado;
    }

    public Map<String, Long> porZona() {
        Map<String, Long> conteo = reportes.stream()
                .collect(Collectors.groupingBy(reporte -> reporte.getUbicacion().getZona(), Collectors.counting()));
        Map<String, Long> ordenado = new LinkedHashMap<>();
        conteo.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(entrada -> ordenado.put(entrada.getKey(), entrada.getValue()));
        return ordenado;
    }
}
