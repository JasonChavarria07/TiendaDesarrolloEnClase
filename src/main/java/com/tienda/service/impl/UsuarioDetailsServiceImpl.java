package com.tienda.service.impl;

import com.tienda.dao.UsuarioDao;
import com.tienda.domain.Usuario;
import com.tienda.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService{

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private HttpSession session;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        //Se busca el usuario que tiene el username pasado por párametro
        Usuario usuario = usuarioDao.findByUsername(username);
                
        // Se valida si se recuperó un usuario o sino lanza un error
        if (usuario==null){
           throw new UsernameNotFoundException(username);
        }
        
    }
    
}
