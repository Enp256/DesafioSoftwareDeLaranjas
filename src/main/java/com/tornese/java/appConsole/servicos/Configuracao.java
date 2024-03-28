package com.tornese.java.appConsole.servicos;

public class Configuracao {
    private double valorLaranja = 0.50;
    private int qtdCaixasPromocao = 3;
    private int qtdDeLaranjaPorCaixas = 50;
    private int procetagemLucro = 40;
    private int porcentagemDesconto = 10;
    private int porcentagemAcrescimo = 15;
    private int maximoparcelas = 12;
    private double valorParaDesconto = 100;
    private int[] continuarOuSair = {0,1};
    private String[] aVistaOuParcelado = {"A","P"};

    public String[] getaVistaOuParcelado() {
        return aVistaOuParcelado;
    }

    public int[] getContinuarOuSair() {
        return continuarOuSair;
    }

    public double getValorLaranja() {
        return valorLaranja;
    }

    public int getQtdCaixasPromocao() {
        return qtdCaixasPromocao;
    }

    public int getQtdDeLaranjaPorCaixas() {
        return qtdDeLaranjaPorCaixas;
    }

    public int getProcetagemLucro() {
        return procetagemLucro;
    }

    public int getPorcentagemDesconto() {
        return porcentagemDesconto;
    }

    public int getPorcentagemAcrescimo() {
        return porcentagemAcrescimo;
    }

    public int getMaximoparcelas() {
        return maximoparcelas;
    }

    public double getValorParaDesconto() {
        return valorParaDesconto;
    }


}
