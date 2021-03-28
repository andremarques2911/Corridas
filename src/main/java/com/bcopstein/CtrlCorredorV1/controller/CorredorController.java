package com.bcopstein.CtrlCorredorV1.controller;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.dto.CorredorDTO;
import com.bcopstein.CtrlCorredorV1.dto.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.service.CorredorService;

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
@RequestMapping("/corredores")
public class CorredorController {

  @Autowired
  CorredorService corredorService;

  @GetMapping("/")
  @CrossOrigin(origins = "*")
  public List<CorredorDTO> consultaCorredor() {
    return this.corredorService.listarTodos();
  }

  @PostMapping("/")
  @CrossOrigin(origins = "*")
  public boolean cadastraCorredor(@RequestBody final CorredorDTO corredor) {
    return this.corredorService.cadastraCorredor(corredor);
  }

  @GetMapping("/estatisticas")
  @CrossOrigin(origins = "*")
  public EstatisticasDTO estatisticas(@RequestParam final double distancia) {
    return this.corredorService.estatisticas(distancia);
  }

}
