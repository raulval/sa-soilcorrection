package edu.utfpr.cp.dacom.sa.soilcorrection.correcao;

import edu.utfpr.cp.dacom.sa.soilcorrection.fonte.IFonteNutriente;
import edu.utfpr.cp.dacom.sa.soilcorrection.nutriente.NutrienteAdicional;

import java.util.Set;

public interface ICorrecaoNutriente<T extends IFonteNutriente> {
    
    default double calculaCusto(
            double custoFonte,
            double qtdeAplicar) {

        if (custoFonte <= 0) {
            throw new IllegalArgumentException();
        }

        if (qtdeAplicar <= 0) {
            throw new IllegalArgumentException();
        }

        return custoFonte * qtdeAplicar / 1000;
    }

    default Set<NutrienteAdicional> getNutrientesAdicionais(
            double qtdeAplicar,
            T fonteNutriente) {

        fonteNutriente
            .getNutrientesAdicionais()
            .forEach(
                item -> 
                        item.setCorrecaoAdicional(
                                item.getTeorNutriente() * qtdeAplicar)
            );

        return fonteNutriente.getNutrientesAdicionais();
    }

    default double calculaEficienciaNutriente(
            double qtdeNutrienteAdicionar,
            double eficienciaNutriente) {

        if (qtdeNutrienteAdicionar <= 0) {
            throw new IllegalArgumentException();
        }

        if (eficienciaNutriente <= 0) {
            throw new IllegalArgumentException();
        }

        return qtdeNutrienteAdicionar / eficienciaNutriente;
    }
}
