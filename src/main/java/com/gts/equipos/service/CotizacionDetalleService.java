/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.service;

import com.gts.equipos.modelo.CotizacionDetalle;
import com.gts.equipos.repository.CotizacionDetalleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author laszlo
 */
@Service
public class CotizacionDetalleService {
    @Autowired
    private CotizacionDetalleRepository repo;
    
    public List<CotizacionDetalle> findAllCotizaciones(){
        return repo.findAll();
    } 
    public Optional<CotizacionDetalle> findCotizacionById(Integer id){
        return repo.findById(id);
    }

    public CotizacionDetalle createCotizacion( CotizacionDetalle cotitizacionDetalle){            
        return repo.save(cotitizacionDetalle);
    }
    
     public String updateCotizacion( Integer idCliente, CotizacionDetalle cotitizacionDetalle){            
        if (   repo.findById(idCliente) == null  )
        {
            return "Cliente No existe.";
        }else {
             repo.save(cotitizacionDetalle);
             return "Cliente Actualizado.!";
        }      
    } 
}
