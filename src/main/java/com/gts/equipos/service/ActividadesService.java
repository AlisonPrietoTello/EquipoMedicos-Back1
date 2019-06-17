package com.gts.equipos.service;

import com.gts.equipos.modelo.Actividades;
import com.gts.equipos.repository.ActividadesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadesService {
    @Autowired
    private ActividadesRepository actividadesRepository;
    
    public List<Actividades> findAllActividades(){
        return actividadesRepository.findAll();
    } 
    
     public List<Actividades> findByIEmpresaAndActividades(Integer IdEmpresa, Integer IdActividades){
        return actividadesRepository.findByIEmpresaAndActividades(IdEmpresa, IdActividades);
    }
     
    public List<Actividades> findByIProtocoloAndActividades(Integer IdActividades, Integer IdProtocolo){
        return actividadesRepository.findByIProtocoloAndActividades(IdActividades, IdProtocolo);
    }
    
     public List<Actividades> findByIEmpresaAndProtoloAndactividades(Integer IdEmpresa, Integer IdProtocolo, Integer IdActividades){
        return actividadesRepository.findByIEmpresaAndProtoloAndactividades(IdEmpresa, IdProtocolo,IdActividades );
    }

    public Optional<Actividades> findActividadesById( Integer id){
        return actividadesRepository.findById(id);
    }

    public Actividades createActividades( Actividades actividades){            
        return actividadesRepository.save(actividades);
    }
    
    //actividades por protocolo
    public List<Actividades> findByActividadesXProtocolo(Integer IdProtocolo){
        return actividadesRepository.findByActividadesXProtocolo( IdProtocolo);
    }
    
    public String updateActividades( Integer idActividades, Actividades actividades){            
        if (actividadesRepository.findById(idActividades) == null)
        {
            return "La actividad no existe.";
        }
        else
        {
             actividadesRepository.save(actividades);
             return "Actividad actualizada.!";
        }      
    }
}