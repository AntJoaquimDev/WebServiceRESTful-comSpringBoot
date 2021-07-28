package com.evento.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evento.restful.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, String>{

}
