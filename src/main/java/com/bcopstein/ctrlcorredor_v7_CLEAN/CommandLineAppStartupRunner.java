package com.bcopstein.ctrlcorredor_v7_CLEAN;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import com.bcopstein.ctrlcorredor_v7_CLEAN.aplicacao.casosDeUso.CadastraCorredoresUC;
import com.bcopstein.ctrlcorredor_v7_CLEAN.aplicacao.casosDeUso.CadastraEventoUC;
import com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.entidades.Corredor;
import com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.entidades.Evento;
import com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.entidades.utils.CustomDate;
import com.bcopstein.ctrlcorredor_v7_CLEAN.negocio.entidades.utils.CustomTime;

@Component
@Slf4j
@Profile("!unit-test")
public class CommandLineAppStartupRunner implements CommandLineRunner {

  private final CadastraCorredoresUC cadastraCorredoresUC;
  private final CadastraEventoUC cadastraEventoUC;

  public CommandLineAppStartupRunner(CadastraCorredoresUC cadastraCorredoresUC, CadastraEventoUC cadastraEventoUC) {
    this.cadastraCorredoresUC = cadastraCorredoresUC;
    this.cadastraEventoUC = cadastraEventoUC;
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("Começou a popular");

    Corredor corredor = new Corredor("9999999999", "Antares", LocalDate.of(1980, 10, 20), "masculino");
    this.cadastraCorredoresUC.run(corredor);

    this.cadastraEventoUC.run(new Evento(1L, "Poa Day Run", new CustomDate(22, 5, 2019), 5, new CustomTime(0, 35, 32), corredor));
    this.cadastraEventoUC.run(new Evento(2L, "Poa Night Run", new CustomDate(12, 6, 2019), 5, new CustomTime(0, 31, 10), corredor));
    this.cadastraEventoUC.run(new Evento(3L, "Winter Day Run", new CustomDate(9, 7, 2019), 5, new CustomTime(0, 29, 17), corredor));
    this.cadastraEventoUC.run(new Evento(4L, "Summer Night Run", new CustomDate(18, 12, 2019), 5, new CustomTime(0, 32, 25), corredor));

    log.info("Terminou de popular");
  }
}
