package com.example.CamisaDez.model;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CamisetaDAO {

    private final JdbcTemplate jdbc;

    public CamisetaDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void inserirCamiseta(Camiseta camiseta) {
        String sql = "INSERT INTO camisetas (id, nome_time, liga, ano_camiseta, nome_jogador, preco)" +
                     " VALUES (?,?,?,?,?,?)";
        Object[] obj = new Object[6];
        obj[0] = UUID.randomUUID();
        obj[1] = camiseta.getNomeTime();
        obj[2] = camiseta.getLiga();
        obj[3] = camiseta.getAnoCamiseta();
        obj[4] = camiseta.getNomeJogador();
        obj[5] = camiseta.getPreco();
        jdbc.update(sql, obj);
    }

    public Camiseta mostrarCamiseta(String uuid){
        String sql = "SELECT * FROM camisetas WHERE id = CAST(? AS UUID)";
        return Camiseta.converter(jdbc.queryForMap(sql, uuid));
    }

    public ArrayList<Camiseta> listarCamisetas(){
        String sql = "SELECT * FROM camisetas ORDER BY ano_camiseta DESC, nome_time ASC";
        return Camiseta.converterTodos(jdbc.queryForList(sql));
    }
}
