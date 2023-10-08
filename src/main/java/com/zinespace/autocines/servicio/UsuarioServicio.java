package com.zinespace.autocines.servicio;

import com.zinespace.autocines.modelo.Usuario;
import com.zinespace.autocines.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
 @Autowired
    private UsuarioRepository DataBasexd;


 public Usuario RegistrarUser(String nombre,String apellido,int telefono, String email, String contrasena){
     Usuario user = new Usuario();
     user.setNombre(nombre);
     user.setApellido(apellido);
        user.setTelefono(telefono);
        user.setEmail(email);
        user.setContrasena(contrasena);
     return DataBasexd.save(user);
 }
 public Usuario validarUser(String nombre, String contrasena ){
     return DataBasexd.findByNombreAndContrasena(nombre,contrasena).orElse(null);

 }
public Usuario mostrarUsuario(Long id){
     return DataBasexd.findByid(id);
}


}