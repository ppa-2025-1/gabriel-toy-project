package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.example.demo.model.entity.Ticket;

public interface TicketRepository extends BaseRepository<Ticket, Integer> {
    Optional<Ticket> findById(Integer id);
}
