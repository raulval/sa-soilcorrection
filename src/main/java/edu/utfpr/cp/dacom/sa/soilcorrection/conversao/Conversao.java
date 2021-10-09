package edu.utfpr.cp.dacom.sa.soilcorrection.conversao;

public interface Conversao<T, R> {

    R converte(T valor);
}
