package com.gts.equipos.repository;

import com.gts.equipos.modelo.Parametro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ParametroRepository extends JpaRepository<Parametro, Integer>{

    @Query("SELECT p FROM Parametro p WHERE p.fkEmpresa = :idEmpresa AND p.idParametro = :idParametro")
    List<Parametro> findByEmpresaAndParametro(@Param("idEmpresa") Integer IdEmpresa, 
                                              @Param("idParametro") Integer IdParametro);
    
    @Query("SELECT p FROM Parametro p WHERE p.fkGrupo = :idGrupo AND p.idParametro = :idParametro")
    List<Parametro> findByGrupoAndParametro(@Param("idGrupo") Integer IdGrupo, 
                                            @Param("idParametro") Integer IdParametro);

    @Query("SELECT p FROM Parametro p WHERE p.fkEmpresa = :idEmpresa AND p.fkGrupo = :idGrupo")
    List<Parametro> findByEmpresaAndGrupo(@Param("idEmpresa") Integer IdEmpresa, 
                                          @Param("idGrupo") Integer IdGrupo);
    
    @Query("SELECT p FROM Parametro p WHERE p.fkEmpresa = :idEmpresa AND p.fkGrupo = :idGrupo AND p.idParametro = :idParametro")
    List<Parametro> findByEmpresaAndGrupoAndParametro(@Param("idEmpresa") Integer IdEmpresa, 
                                                      @Param("idGrupo") Integer IdGrupo,
                                                      @Param("idParametro") Integer IdParametro);
    
    @Query("SELECT p FROM Parametro p WHERE p.fkEmpresa = :idEmpresa")
    List<Parametro>findByParametroXEMpresa(@Param("idEmpresa") Integer idEmpresa);
    
    
}
