package com.kokouintech.facturation.dto;

import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter @Builder
public class ClientDto {
    private String nom;
    private String email;
    private String siret;
}
