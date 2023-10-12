package com.zinespace.autocines.repositorio;

import com.zinespace.autocines.modelo.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketRepositorio extends JpaRepository<Ticket , Long> {
    }
