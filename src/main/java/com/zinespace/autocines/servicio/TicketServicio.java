package com.zinespace.autocines.servicio;

import com.zinespace.autocines.modelo.Ticket;
import com.zinespace.autocines.repositorio.TicketRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TicketServicio {

    @Autowired
    private TicketRepositorio TicketRepositorio;
    public Ticket crearTicket(Ticket ticket) {
        // Agregar lógica de validación o procesamiento aquí si es necesario
        return TicketRepositorio.save(ticket);
    }

    public List<Ticket> listarTickets() {
        return TicketRepositorio.findAll();
    }

    public Ticket getTicketById(Long id) {
        return TicketRepositorio.findById(id).orElse(null);
    }

}
