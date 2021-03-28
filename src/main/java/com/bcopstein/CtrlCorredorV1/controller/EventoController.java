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
import org.springframework.web.bind.annotation.RequestParam;

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

  @GetMapping("/all")
  @CrossOrigin(origins = "*")
  public List<EventoEntity> searchByDistancia(@RequestParam double distancia) {
    return this.eventoService.findByDistancia(distancia);
  }

  @PostMapping("/")
  @CrossOrigin(origins = "*")
  public boolean informaEvento(@RequestBody final EventoDTO evento) {
    return this.eventoService.cadastraEvento(evento);
  }

}
