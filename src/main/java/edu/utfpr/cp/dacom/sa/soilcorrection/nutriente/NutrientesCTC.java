package edu.utfpr.cp.dacom.sa.soilcorrection.nutriente;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public record NutrientesCTC (
    double fosforo,
    double potassio,
    double calcio,
    double magnesio,
    double enxofre,
    double aluminio,
    double aluminioHidrogenio) {}
