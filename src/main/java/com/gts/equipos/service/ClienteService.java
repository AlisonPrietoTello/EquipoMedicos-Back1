/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.service;

import com.gts.equipos.modelo.Clientes;
import com.gts.equipos.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author laszlo
 */
@Service
public class ClienteService {
        @Autowired
    private ClienteRepository repo;
    
    public List<Clientes> findAllCotizaciones(){
        return repo.findAll();
    } 
    public Optional<Clientes> findCotizacionById(Integer id){
        return repo.findById(id);
    }

    public Clientes createCotizacion( Clientes cliente){            
        return repo.save(cliente);
    }
    
     public String updateCotizacion( Integer idCliente, Clientes cliente){            
        if (   repo.findById(idCliente) == null  )
        {
            return "Cliente No existe.";
        }else {
             repo.save(cliente);
             return "Cliente Actualizado.!";
        }      
    }    
}
