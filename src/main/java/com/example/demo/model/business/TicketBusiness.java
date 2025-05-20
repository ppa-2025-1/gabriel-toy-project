package com.example.demo.model.business;

import com.example.demo.dto.NewTicket;
import com.example.demo.model.entity.Ticket;
import com.example.demo.model.entity.User;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;

import enums.Situacao;

@Business
public class TicketBusiness {
    private TicketRepository ticketRepository;
    private UserRepository userRepository;

    public TicketBusiness(TicketRepository ticketRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    public void criarTicket(NewTicket newTicket) {
        // BUSINESS RULES
        // DOMAIN RULES
        
        Ticket ticket = new Ticket();
        ticket.setAcao(newTicket.acao());
        ticket.setObjeto(newTicket.objeto());
        ticket.setDetalhamento(newTicket.detalhamento());
        
        ticket.setSituacao(Situacao.valueOf(Situacao.PENDENTE.name()));

        User user = userRepository.findById(newTicket.userId()).get();
            
        ticket.setUser(user);
        
        ticketRepository.save(ticket);
    }
}
