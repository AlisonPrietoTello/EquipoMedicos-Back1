/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gts.equipos.modelo.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    
    public Usuario findByUsername(String username);
    
    @Query("select u from Usuario u where u.username=?1")
    public Usuario findByUsername2(String username);
    
}
