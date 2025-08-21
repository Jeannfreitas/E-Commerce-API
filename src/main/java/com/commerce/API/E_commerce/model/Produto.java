package com.commerce.API.E_commerce.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    private String descricao;

    @NotNull
    private Double preco;

    private Integer estoque;

    @OneToMany(mappedBy = "produto")
    private List<ItemPedido> itens = new ArrayList<>();
}


