package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.NewTicket;
import com.example.demo.dto.NewUser;
import com.example.demo.model.business.TicketBusiness;
import com.example.demo.model.entity.Ticket;
import com.example.demo.model.entity.User;
import com.example.demo.repository.TicketRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController extends AbstractController {
    private final TicketBusiness ticketBusiness;
    private final TicketRepository ticketRepository;

    public TicketController(TicketBusiness ticketBusiness, TicketRepository ticketRepository) {
        this.ticketBusiness = ticketBusiness;
        this.ticketRepository = ticketRepository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNewTicket(
        @Valid
        @RequestBody
        NewTicket newTicket) {

        ticketBusiness.criarTicket(newTicket);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ticket>> getUsers() {
        return ResponseEntity.ok(ticketRepository.findAll());
    }
}
