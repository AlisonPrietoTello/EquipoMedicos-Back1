package com.gts.equipos.repository;

import com.gts.equipos.modelo.Actividades;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ActividadesRepository extends JpaRepository<Actividades, Integer>{
    
     @Query("SELECT a FROM Actividades a WHERE a.fkEmpresa.idEmpresa = :idEmpresa AND a.idActividades = :idActividades")
    List<Actividades> findByIEmpresaAndActividades(@Param("idEmpresa") Integer IdEmpresa, @Param("idActividades") Integer idActividades);
    
    
    @Query("SELECT a FROM Actividades a WHERE a.idActividades = :idActividades AND a.fkProtocolo.idProtocolo= :idProtocolo")
    List<Actividades> findByIProtocoloAndActividades(@Param("idActividades") Integer idActividades, @Param("idProtocolo") Integer idProtocolo);
    
    @Query("SELECT a FROM Actividades a WHERE a.fkEmpresa.idEmpresa =:idEmpresa AND a.fkProtocolo.idProtocolo = :idProtocolo AND a.idActividades = :idActividades")
    List<Actividades> findByIEmpresaAndProtoloAndactividades(@Param("idEmpresa") Integer idEmpresa, @Param("idProtocolo") Integer idProtocolo, @Param("idActividades") Integer idActividades );
  
      @Query("SELECT a FROM Actividades a WHERE a.fkProtocolo.idProtocolo = :idPrptocolo")
    List<Actividades> findByActividadesXProtocolo(@Param("idPrptocolo") Integer idPrptocolo);
}
