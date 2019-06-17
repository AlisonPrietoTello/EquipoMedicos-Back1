package com.gts.equipos.service;

import com.gts.equipos.modelo.Instrumentos;
import com.gts.equipos.repository.InstrumentosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentosService {
    @Autowired
    private InstrumentosRepository instrumentosRepository;
    
    public List<Instrumentos> findAllInstrumentos(){
        return instrumentosRepository.findAll();
    } 
    
    public List<Instrumentos> findByEmpresaAndInstrumentos(Integer idEmpresa, Integer idInstrumentos){
        return instrumentosRepository.findByEmpresaAndInstrumentos(idEmpresa, idInstrumentos);
    }
     
    public Optional<Instrumentos> findInstrumentosById( Integer id){
        return instrumentosRepository.findById(id);
    }

    public Instrumentos cretaeInstrumentos( Instrumentos instrumentos){            
        return instrumentosRepository.save(instrumentos);
    }
    
    public String updateActividades( Integer idInstrumentos, Instrumentos instrumentos){            
        if (instrumentosRepository.findById(idInstrumentos) == null)
        {
            return "El instrumento no existe.";
        }
        else
        {
             instrumentosRepository.save(instrumentos);
             return "Instrumento actualizado.!";
        }      
    }  
}
