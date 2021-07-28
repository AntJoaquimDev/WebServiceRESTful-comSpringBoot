package com.evento.restful.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.evento.restful.models.Evento;
import com.evento.restful.repository.EventoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value ="API RES Eventos" )
@RestController
@RequestMapping("/evento")
@CrossOrigin(origins = "*")
public class EventoResource {
	@Autowired
	private EventoRepository er;
	
	@ApiOperation(value = "Listar Eventos")
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Evento> listaEventos() {
		Iterable<Evento>listaEventos = er.findAll();
		
		return listaEventos;
	}
	@ApiOperation(value = "Salvar Eventos")
	@PostMapping("/evento")
	public Evento cadstraEvento(@RequestBody @Validated Evento evento) {
		return er.save(evento);
		
	}
	
	@ApiOperation(value = "Deletar Eventos")
	@DeleteMapping("/evento")
	public Evento deletarEvento(@RequestBody Evento evento) {
		er.delete(evento);		
		return evento;
		
	}
	
	
}
