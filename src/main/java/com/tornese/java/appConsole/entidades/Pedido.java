package com.tornese.java.appConsole.entidades;

public class Pedido {
    private Cliente cliente;
    private int qtdCaixas;
    private double valorTotal;
    private int totalDeLaranjas = 0;
    private double valorTotalAlterado = 0;
    private int parcelas = 0;
    private int porcentagemAcrescimo = 0;
    private double lucroAReceber = 0;

    public double getLucroAReceber() {
        return lucroAReceber;
    }

    public int getTotalDeLaranjas() {
        return totalDeLaranjas;
    }

    public void setTotalDeLaranjas(int qtdCaixas, double valorLaranja, int qtdDeLaranjaPorCaixas) {
        this.totalDeLaranjas = qtdCaixas * qtdDeLaranjaPorCaixas;
        this.setValorTotal(totalDeLaranjas * valorLaranja);
    }

    public double getValorTotalAlterado() {
        return valorTotalAlterado;
    }

    public void setValorTotalAlterado(double valorTotalAlterado) {
        this.valorTotalAlterado = valorTotalAlterado;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getQtdCaixas() {
        return qtdCaixas;
    }

    public void setQtdCaixas(int qtdCaixas) {
        this.qtdCaixas = qtdCaixas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
        this.valorTotalAlterado = this.valorTotal;
    }

    public void alterarValorParaPagamentoAVista(double valorParaDesconto, int qtdCaixas, int qtdCaixasPromocao, int porcentagemDesconto) {
        if (this.valorTotal > valorParaDesconto || qtdCaixas == qtdCaixasPromocao) 
            this.valorTotalAlterado -= (valorTotal * porcentagemDesconto / 100);// valorTotal - (resultado: o valor a ser descontado)
        
    }

    public void acrescentaJuros(int porcentagemAcrescimoPadrao) {
        this.porcentagemAcrescimo = porcentagemAcrescimoPadrao;
        if (this.parcelas <= 5){
            switch (this.parcelas) {
                case 2:
                    this.porcentagemAcrescimo = 5;
                    break;
                case 3:
                    this.porcentagemAcrescimo = 8;
                    break;
                case 4:
                    this.porcentagemAcrescimo = 10;
                    break;
                case 5:
                    this.porcentagemAcrescimo = 13;
                    break;
            }
        }
        this.valorTotalAlterado += (this.valorTotal * this.porcentagemAcrescimo / 100);// valorTotal + (resultado: o valor a ser acrescentado)
    }
    public void calculaLucroAReceber(int porcetagemLucro){
        this.lucroAReceber = this.valorTotalAlterado * porcetagemLucro / 100;
    }

    public double valorComDesconto() {
        return this.valorTotal - this.valorTotalAlterado;
    }

    public double valorDoJuros() {
        return this.valorTotalAlterado - this.valorTotal;
    }

    public double valorDaParcela() {
        return this.valorTotalAlterado / this.parcelas;
    }
}
