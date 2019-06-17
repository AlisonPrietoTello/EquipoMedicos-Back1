package com.gts.equipos.repository;

import com.gts.equipos.modelo.InstrumentosProtocolo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InstrumentosProtocoloRepository extends JpaRepository<InstrumentosProtocolo, Integer>{
    
    /**
     *
     * @param idEmpresa
     * @param idInstrumento
     * @return 
     */
    @Query("SELECT i FROM InstrumentosProtocolo i where i.fkEmpresa.idEmpresa = :idEmpresa  AND i.fkInstrumento.idInstrumentos= :idInstrumento")
    List<InstrumentosProtocolo> findInstrumentosProtocoloByIdEmpresa_and_IdInstrumento(@Param("idEmpresa") Integer idEmpresa, @Param("idInstrumento") Integer idInstrumento);
    
    /**
     *
     * @param idEmpresa
     * @param idProtocolo
     * @return
     */
    @Query("SELECT i FROM InstrumentosProtocolo i where i.fkEmpresa.idEmpresa = :idEmpresa  AND i.fkProtocolo.idProtocolo = :idProtocolo")
    List<InstrumentosProtocolo> findInstrumentosProtocoloByIdEmpresa_and_IdProtocolo(@Param("idEmpresa") Integer idEmpresa, @Param("idProtocolo") Integer idProtocolo);    
}
