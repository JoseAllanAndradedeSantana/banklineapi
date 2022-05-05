package com.allan.jaas.banklineapi.model;

import com.allan.jaas.banklineapi.enums.MovimentacaoTipo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dataHora;
    private String descricao;
    private Double valor;

    @Enumerated(EnumType.STRING)
    private MovimentacaoTipo tipo;

    @Column(name = "id_conta")
    private Integer idConta;

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public MovimentacaoTipo getTipo() {
        return tipo;
    }

    public void setTipo(MovimentacaoTipo tipo) {
        this.tipo = tipo;
    }
}