package com.raulcrespo.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContato {
    private Set<Contato> contatoSet;

    public AgendaContato() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numeroTelefone) {
        contatoSet.add(new Contato(nome, numeroTelefone));
    }

    public void exibirContatos() {
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarContatoPorNome(String nome) {
        Set<Contato> contatosPesquisados = new HashSet<>();
        for (Contato c : contatoSet) {
            if (c.getNome().startsWith(nome)) {
                contatosPesquisados.add(c);
            }
        }

        return contatosPesquisados;
    }

    public void atualizarNumeroContato(String nome, int numeroTelefone) {
        for (Contato c : contatoSet) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                c.setNumeroTelefone(numeroTelefone);
                return;
            }
        }
    }

    public static void main(String[] args) {
        AgendaContato contatos = new AgendaContato();

        contatos.exibirContatos();

        contatos.adicionarContato("Raul", 123);
        contatos.adicionarContato("Raul", 12357576);
        contatos.adicionarContato("Raul 1", 123);
        contatos.adicionarContato("Raul 2", 123);
        contatos.adicionarContato("Raul 3", 123);
        contatos.adicionarContato("Knightmare", 123);

        contatos.exibirContatos();

        System.out.println(contatos.pesquisarContatoPorNome("Raul"));

        contatos.atualizarNumeroContato("Raul", 876);
        contatos.exibirContatos();
    }

}
