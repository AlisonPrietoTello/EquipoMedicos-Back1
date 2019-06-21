/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.service;


import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gts.equipos.modelo.Usuario;
import com.gts.equipos.repository.UsuarioRepository;


@Service
public class UsuarioService implements IUsuarioService, UserDetailsService{
	
	private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);
    
	@Autowired
    private UsuarioRepository usuarioDao;
    
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	    Usuario usuario = usuarioDao.findByUsername(username);

	    if (usuario == null) {
	      logger.error("Error en el Login: no existe el usuario '" + username + "' En el Sistema!");
	      throw new UsernameNotFoundException("Error en el Login: no existe el usuario '" + username + "' En el Sistema!");
	    }

	    List<GrantedAuthority> authorities = usuario.getRoles()
	      .stream()
	      .map(role -> new SimpleGrantedAuthority(role.getNombre()))
	      .peek(authority -> logger.info("Role :" + authority.getAuthority()))
	      .collect(Collectors.toList());

	    return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	  }

	  @Override
	  @Transactional
	  public Usuario findByUsername(String username) {
	    return usuarioDao.findByUsername(username);
	  }



}
