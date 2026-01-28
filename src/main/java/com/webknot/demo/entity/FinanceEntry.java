package com.webknot.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "finance_entries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinanceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double amount;

    @NotBlank
    private String category;

    @NotNull
    private LocalDate date;

    @NotBlank
    private String description;

    @NotBlank
    private String type; // INCOME or EXPENSE
}
