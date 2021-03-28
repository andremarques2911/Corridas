package com.bcopstein.CtrlCorredorV1;

import java.time.LocalTime;

import com.bcopstein.CtrlCorredorV1.entity.CorredorEntity;
import com.bcopstein.CtrlCorredorV1.entity.EventoEntity;
import com.bcopstein.CtrlCorredorV1.service.CorredorService;
import com.bcopstein.CtrlCorredorV1.service.EventoService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Profile("!unit-test")
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final CorredorService corredorService;
    private final EventoService eventoService;

    public CommandLineAppStartupRunner(CorredorService corredorService, EventoService eventoService) {
        this.corredorService = corredorService;
        this.eventoService = eventoService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Começou a popular");

        CorredorEntity corredor1 = this.corredorService.save(CorredorEntity.builder()
            .cpf("9999999999").nome("Antares").dia(20).mes(10).ano(1980).genero("Masculino").build());
        this.eventoService.save(EventoEntity.builder()
            .nome("Evento 1").dia(24).mes(3).ano(2018).distancia(200).tempo(LocalTime.of(2, 00)).build());
        this.eventoService.save(EventoEntity.builder()
          .nome("Evento 2").dia(24).mes(3).ano(2019).distancia(200).tempo(LocalTime.of(1, 30)).build());
        this.eventoService.save(EventoEntity.builder()
          .nome("Evento 3").dia(24).mes(3).ano(2020).distancia(200).tempo(LocalTime.of(1, 0)).build());
        this.eventoService.save(EventoEntity.builder()
          .nome("Evento 4").dia(24).mes(3).ano(2021).distancia(200).tempo(LocalTime.of(0, 30)).build());

        log.info("Terminou de popular");
    }
}
