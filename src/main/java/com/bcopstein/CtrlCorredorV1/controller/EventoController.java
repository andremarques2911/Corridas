package com.bcopstein.CtrlCorredorV1.controller;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.dto.EventoDTO;
import com.bcopstein.CtrlCorredorV1.entity.EventoEntity;
import com.bcopstein.CtrlCorredorV1.service.EventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/eventos")
public class EventoController {

  @Autowired
  EventoService eventoService;

  @GetMapping("/")
  @CrossOrigin(origins = "*")
  public List<EventoDTO> consultaEventos() {
    return this.eventoService.listarTodos();
  }

  @PostMapping("/")
  @CrossOrigin(origins = "*")
  public boolean informaEvento(@RequestBody final EventoEntity evento) {
    // this.jdbcTemplate.update(
    //   "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES (?,?,?,?,?,?,?,?,?)",
    //   evento.getId(), evento.getNome(), evento.getDia(), evento.getMes(), evento.getAno(),
    //   evento.getDistancia(), evento.getHoras(), evento.getMinutos(), evento.getSegundos());

    return true;
  }

}
