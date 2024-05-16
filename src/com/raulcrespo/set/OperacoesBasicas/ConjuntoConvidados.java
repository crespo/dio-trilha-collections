package com.raulcrespo.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvidado) {
        convidadoSet.add(new Convidado(nome, codigoConvidado));
    }

    public boolean removerConvidadoPorCodigoConvite(int codigoConvidado) {
        for (Convidado c : convidadoSet) {
            if (c.getCodigoConvite() == codigoConvidado) {
                return convidadoSet.remove(c);
            }
        }
        return false;
    }

    public int contarConvidados() {
        return convidadoSet.size();
    }

    public void exibirConvidados() {
        System.out.println(convidadoSet);
    }

    public static void main(String[] args) {
        ConjuntoConvidados convidados = new ConjuntoConvidados();

        System.out.println(convidados.contarConvidados());

        convidados.adicionarConvidado("Convidado 1", 1234);
        convidados.adicionarConvidado("Convidado X", 1234);
        convidados.adicionarConvidado("Convidado 2", 1235);
        convidados.adicionarConvidado("Convidado 3", 1236);
        convidados.adicionarConvidado("Convidado 4", 1237);

        convidados.removerConvidadoPorCodigoConvite(1237);
        convidados.exibirConvidados();
        System.out.println(convidados.contarConvidados());
    }
}
