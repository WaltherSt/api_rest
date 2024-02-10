package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "paciente")
public class Patient {
    @Id
    @NotNull
    private Long cedula;

    @NotBlank
    private String nombres;

    @NotBlank/**/
    private String apellidos;

    @NotBlank
    @Size(min = 7, max = 10)
    private String telefono;

    @NotBlank
    @Email
    private String correo;

    @NotBlank
    private String direccion;


}

