package com.bcopstein.CtrlCorredorV1;

import com.bcopstein.CtrlCorredorV1.entity.CorredorEntity;
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
        // EventoEntity evento1 = this.eventoService.save(EventoEntity.builder()
        //     .nome("Evento 1").dia(24).mes(3).ano(2021).distancia(200).horas(2).minutos(10).segundos(55).build());

        log.info("Terminou de popular");
    }
}
