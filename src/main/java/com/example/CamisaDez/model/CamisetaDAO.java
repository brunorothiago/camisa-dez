package com.example.CamisaDez.model;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class CamisetaDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirCamiseta(Camiseta camiseta) {
        String sql = "INSERT INTO camisetas (nome_time, liga, ano_camiseta, nome_jogador, preco)" +
                     " VALUES (?,?,?,?,?)";
        Object[] obj = new Object[5];
        obj[0] = camiseta.getNomeTime();
        obj[1] = camiseta.getLiga();
        obj[2] = camiseta.getAnoCamiseta();
        obj[3] = camiseta.getNomeJogador();
        obj[4] = camiseta.getPreco();
        jdbc.update(sql, obj);
    }

    public Camiseta mostrarCamiseta(String uuid){
        String sql = "SELECT * FROM camisetas WHERE id=?::uuid";
        return Camiseta.converter(jdbc.queryForMap(sql, uuid));
    }

    public ArrayList<Camiseta> listarCamisetas(){
        String sql = "SELECT * FROM camisetas ORDER BY ano_camiseta DESC, nome_time ASC";
        return Camiseta.converterTodos(jdbc.queryForList(sql));
    }
}
