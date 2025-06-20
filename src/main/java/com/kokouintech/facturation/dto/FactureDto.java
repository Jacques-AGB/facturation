package com.kokouintech.facturation.dto;

import lombok.*;

import java.time.LocalDate;

public record FactureDto(String reference, Long clientId) {
}
