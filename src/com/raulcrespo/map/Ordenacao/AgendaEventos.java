package com.raulcrespo.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {
    private Map<LocalDate, Evento> agendaEventosMap;

    public AgendaEventos() {
        this.agendaEventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        agendaEventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> agendaEventosTreeMap = new TreeMap<>(agendaEventosMap);
        System.out.println(agendaEventosTreeMap);
    }

    public void proximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> agendaEventosTreeMap = new TreeMap<>(agendaEventosMap);

        LocalDate dataPesquisada = null;
        Evento proximoEvento = null;
        for(Map.Entry<LocalDate, Evento> entry : agendaEventosTreeMap.entrySet()) {
            dataPesquisada = entry.getKey();
            if(dataPesquisada.isEqual(dataAtual) || dataPesquisada.isAfter(dataAtual)) {
                proximoEvento = entry.getValue();
                System.out.println("O próximo evento: " + proximoEvento + " acontecerá na data " + dataPesquisada);
                break;
            }
        }
    }



    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JULY, 15), "Evento 1", "Atracao 1");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JULY, 9), "Evento 2", "Atracao 2");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.MAY, 18), "Evento 3", "Atracao 3");

        agendaEventos.exibirAgenda();
        agendaEventos.proximoEvento();
    }
}
