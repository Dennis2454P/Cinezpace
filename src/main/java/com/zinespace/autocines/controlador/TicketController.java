package com.zinespace.autocines.controlador;


import com.zinespace.autocines.modelo.Ticket;
import com.zinespace.autocines.servicio.TicketServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/Ticket")
public class TicketController {

    @Autowired
    private TicketServicio TicketServicio;

    @PostMapping("/tickets")
    public Ticket crearTicket(@RequestBody Ticket ticket){
        return TicketServicio.crearTicket(ticket);
    }
    @GetMapping("/tickets")
    public List<Ticket> listarTickets(){
        return TicketServicio.listarTickets();
    }


    @GetMapping ("/tickets/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return TicketServicio.getTicketById(id);
    }


}








