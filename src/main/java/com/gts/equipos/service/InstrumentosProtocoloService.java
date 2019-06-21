package com.gts.equipos.service;

import com.gts.equipos.modelo.InstrumentosProtocolo;
import com.gts.equipos.repository.InstrumentosProtocoloRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentosProtocoloService {

    @Autowired
    private InstrumentosProtocoloRepository instrumentosProtocoloRepository;    
    
    public List<InstrumentosProtocolo> findAllInstrumentosProtocolo(){
        return instrumentosProtocoloRepository.findAll();
    } 
     
    public Optional<InstrumentosProtocolo> findInstrumentosProtocoloById( Integer id){
        return instrumentosProtocoloRepository.findById(id);
    }    
    
    public InstrumentosProtocolo cretaeInstrumentosProtocolo( InstrumentosProtocolo instrumentosProtocolo){
            
        return instrumentosProtocoloRepository.save(instrumentosProtocolo);
    }
    
    public String updateInstrumentosProtocolo( Integer idInstProt, InstrumentosProtocolo instrumentosProtocolo){            
        if (instrumentosProtocoloRepository.findById(idInstProt) == null  )
        {
            return "Este registro No existe.";
        }else {
             instrumentosProtocoloRepository.save(instrumentosProtocolo);
             return "Intrumento Potocolo actualizado.!";
        }      
    }
    
    
    public List<InstrumentosProtocolo> findInstrumentosProtocoloByIdEmpresa_and_IdInstrumento( Integer idEmpresa,  Integer idInstrumento){
        return instrumentosProtocoloRepository.findInstrumentosProtocoloByIdEmpresa_and_IdInstrumento(idEmpresa, idInstrumento);
    }
    
    public List<InstrumentosProtocolo> findInstrumentosProtocoloByIdEmpresa_and_IdProtocolo( Integer idEmpresa,  Integer IdProtocolo){
        return instrumentosProtocoloRepository.findInstrumentosProtocoloByIdEmpresa_and_IdProtocolo(idEmpresa, IdProtocolo);
    }
    
    
}
