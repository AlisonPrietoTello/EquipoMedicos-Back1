package com.gts.equipos.repository;

import com.gts.equipos.modelo.Instrumentos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InstrumentosRepository extends JpaRepository<Instrumentos, Integer>{

    @Query("SELECT i FROM Instrumentos i WHERE i.fkEmpresa.idEmpresa = :idEmpresa AND i.idInstrumentos = :idInstrumentos")
    List<Instrumentos> findByEmpresaAndInstrumentos(@Param("idEmpresa") Integer IdEmpresa, @Param("idInstrumentos") Integer IdInstrumentos);
}
