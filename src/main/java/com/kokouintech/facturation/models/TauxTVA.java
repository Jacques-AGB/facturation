package com.kokouintech.facturation.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum TauxTVA {
    TVA_1(0.0),
    TVA_2(5.5),
    TVA_3(10.0),
    TVA_4(20.0);

    private final double valeur;

    TauxTVA(double valeur){
        this.valeur = valeur;
    }

}
