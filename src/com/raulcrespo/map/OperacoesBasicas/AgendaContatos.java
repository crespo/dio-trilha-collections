package com.raulcrespo.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if(!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContatos() {
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if(!agendaContatoMap.isEmpty()) {
            numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agenda = new AgendaContatos();

        agenda.adicionarContato("Raul", 1234);
        agenda.adicionarContato("Raul 1", 12345);
        agenda.adicionarContato("Raul 3", 12346);
        agenda.adicionarContato("Raul 4", 12347);
        agenda.adicionarContato("Raul 4", 12348);
        agenda.adicionarContato("Raul 5", 12349);
        agenda.adicionarContato("Raul 6", 12340);

        agenda.exibirContatos();

        System.out.println(agenda.pesquisarPorNome("Raul 5"));

        agenda.removerContato("Raul 6");
        agenda.exibirContatos();
    }
}
