/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.service;

import com.gts.equipos.modelo.Cotizacion;
import com.gts.equipos.repository.CotizacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author laszlo
 */
@Service
public class CotizacionService {
    @Autowired
    private CotizacionRepository cotizacionRepository;
    
    public List<Cotizacion> findAllCotizaciones(){
        return cotizacionRepository.findAll();
    } 
    public Optional<Cotizacion> findCotizacionById(Integer id){
        return cotizacionRepository.findById(id);
    }

    public Cotizacion createCotizacion( Cotizacion cotizacion){            
        return cotizacionRepository.save(cotizacion);
    }
    
    public List<Cotizacion> findCotizacionesClientesActivos(Integer idEmpresa){
        return cotizacionRepository.findCotizacionesClientesActivos(idEmpresa);
    } 
    
    
}
