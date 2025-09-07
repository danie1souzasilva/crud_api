package br.com.crud.crud_api;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import jakarta.validation.constraints.Pattern;


@Data
@Entity(name = "Usuario")
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @NonNull
    public String nome;
    @NonNull
    public String email;
    @NonNull
    @Pattern(regexp = "\\d{6}", message = "A senha deve conter 6 caracteres")
    public String senha;

    public Usuario() {}
}
