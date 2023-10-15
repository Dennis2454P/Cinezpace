package com.zinespace.autocines.controlador;

import com.zinespace.autocines.modelo.Usuario;
import com.zinespace.autocines.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.function.LongFunction;

@Controller
public class UsuarioController {


    @Autowired
    private UsuarioServicio LosServicios;
//METODOS PARA CAMBIOS DE PAGINAS
    @GetMapping("/register")
    public String MostrarRegistroPage(Model variable){
        variable.addAttribute("EnvioDeRegistro", new Usuario());
        return "Registro";
    }

    @GetMapping("/login")
    public String MostrarLogin(Model variable){
        variable.addAttribute("EnvioDeLogin",new Usuario());
        return "Login";
    }
    @GetMapping("/perfil/{id}")
    public String mostrarPerfil(@PathVariable Long id, Model model) {
        Usuario usuarioRegistrado = LosServicios.mostrarUsuario(id);

        if (usuarioRegistrado != null) {

            model.addAttribute("nombres", usuarioRegistrado.getNombre());
            model.addAttribute("apellidos", usuarioRegistrado.getApellido());
            model.addAttribute("telefonos", usuarioRegistrado.getTelefono());
            model.addAttribute("emails", usuarioRegistrado.getEmail());

            return "perfil";
        } else {
            return "perfil";
        }
    }
//METODOS DE ENVIO DE DATOS
    @PostMapping("/register")
    public String register(@ModelAttribute Usuario usuarios) {
        Usuario registrando = LosServicios.RegistrarUser(usuarios.getNombre(), usuarios.getApellido(), usuarios.getTelefono(),usuarios.getEmail(),usuarios.getContrasena());
        return registrando == null ? "errores" : "redirect:/login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute Usuario usuarios, Model model) {

        Usuario autenticando = LosServicios.validarUser(usuarios.getNombre(), usuarios.getContrasena());
        if (autenticando != null) {
            Usuario obtener = LosServicios.mostrarUsuario(autenticando.getId());
            model.addAttribute("Nombre", obtener.getNombre());
            model.addAttribute("apellido", obtener.getApellido());
            model.addAttribute("telefono", obtener.getTelefono());
            model.addAttribute("email", obtener.getEmail());
            model.addAttribute("contrasena", obtener.getContrasena());


            return "perfil";
        } else {
            return "errores";
        }
    }

}
