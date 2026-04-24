package com.example.CamisaDez.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamisetaService {

    @Autowired
    CamisetaDAO camisetaDAO;

    public void inserirCamiseta(Camiseta camiseta) {
        camisetaDAO.inserirCamiseta(camiseta);
    }

    public Camiseta mostrarCamiseta(String uuid){
        return camisetaDAO.mostrarCamiseta(uuid);
    }

    public ArrayList<Camiseta> listarCamisetas(){
        return camisetaDAO.listarCamisetas();
    }
}
