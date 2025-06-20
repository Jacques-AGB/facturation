package com.kokouintech.facturation.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FactureDto {
    private String reference;
    private Long clientId;
}
