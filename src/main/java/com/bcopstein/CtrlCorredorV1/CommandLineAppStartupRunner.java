package com.bcopstein.CtrlCorredorV1;

import java.time.LocalDate;
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
            .cpf("9999999999").nome("Antares").dataNascimento(LocalDate.of(1980, 10, 20)).genero("Masculino").build());
        this.eventoService.save(EventoEntity.builder().nome("Evento 1").dataEvento(LocalDate.of(2018, 3, 24)).distancia(200).tempo(LocalTime.of(2, 00)).build());
        this.eventoService.save(EventoEntity.builder().nome("Evento 2").dataEvento(LocalDate.of(2019, 3, 24)).distancia(200).tempo(LocalTime.of(1, 30)).build());
        this.eventoService.save(EventoEntity.builder().nome("Evento 3").dataEvento(LocalDate.of(2020, 3, 24)).distancia(200).tempo(LocalTime.of(1, 0)).build());
        this.eventoService.save(EventoEntity.builder().nome("Evento 4").dataEvento(LocalDate.of(2021, 3, 24)).distancia(200).tempo(LocalTime.of(0, 30)).build());
        this.eventoService.save(EventoEntity.builder().nome("Evento 5").dataEvento(LocalDate.of(2021, 3, 25)).distancia(200).tempo(LocalTime.of(2, 00)).build());

        log.info("Terminou de popular");
    }
}
