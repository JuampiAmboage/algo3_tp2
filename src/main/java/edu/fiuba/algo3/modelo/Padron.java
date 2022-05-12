package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Padron implements Id {
    private String valor;

    public Padron(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Padron padron = (Padron) o;
        return valor.toUpperCase().equals(padron.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
