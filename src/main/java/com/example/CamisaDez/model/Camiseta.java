package com.example.CamisaDez.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Camiseta {

    private String id;
    private String nomeTime;
    private String liga;
    private Integer anoCamiseta;
    private String nomeJogador;
    private BigDecimal preco;

    // Construtor vazio — usado pelo formulário
    public Camiseta() {}

    // Construtor para INSERT
    public Camiseta(String nomeTime, String liga, Integer anoCamiseta, String nomeJogador, BigDecimal preco) {
        this.nomeTime = nomeTime;
        this.liga = liga;
        this.anoCamiseta = anoCamiseta;
        this.nomeJogador = nomeJogador;
        this.preco = preco;
    }

    // Construtor para SELECT
    public Camiseta(String id, String nomeTime, String liga, Integer anoCamiseta, String nomeJogador, BigDecimal preco) {
        this.id = id;
        this.nomeTime = nomeTime;
        this.liga = liga;
        this.anoCamiseta = anoCamiseta;
        this.nomeJogador = nomeJogador;
        this.preco = preco;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNomeTime() { return nomeTime; }
    public void setNomeTime(String nomeTime) { this.nomeTime = nomeTime; }

    public String getLiga() { return liga; }
    public void setLiga(String liga) { this.liga = liga; }

    public Integer getAnoCamiseta() { return anoCamiseta; }
    public void setAnoCamiseta(Integer anoCamiseta) { this.anoCamiseta = anoCamiseta; }

    public String getNomeJogador() { return nomeJogador; }
    public void setNomeJogador(String nomeJogador) { this.nomeJogador = nomeJogador; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public static Camiseta converter(Map<String,Object> registro){
        UUID id = (UUID) registro.get("id");
        String nomeTime = (String) registro.get("nome_time");
        String liga = (String) registro.get("liga");
        Integer anoCamiseta = (Integer) registro.get("ano_camiseta");
        String nomeJogador = (String) registro.get("nome_jogador");
        BigDecimal preco = (BigDecimal) registro.get("preco");
        return new Camiseta(id.toString(), nomeTime, liga, anoCamiseta, nomeJogador, preco);
    }

    public static ArrayList<Camiseta> converterTodos(List<Map<String,Object>> registros){
        ArrayList<Camiseta> aux = new ArrayList<>();
        for(Map<String,Object> registro : registros){
            aux.add(converter(registro));
        }
        return aux;
    }
}
