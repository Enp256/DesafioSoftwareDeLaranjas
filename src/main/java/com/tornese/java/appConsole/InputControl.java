package com.tornese.java.appConsole;

import java.io.Console;

public class InputControl {
    
    static String mensagemErro = "Valor invalido, por favor digite novamente";
    
    public static int lerNumero(String mensagem, int[] valoresValidos){
        // Loop que Valida se o valor digitado esta dentro da lista de valores validos criado na classe de configuração//
        int numero = 0;
        Console cnsl = System.console();
        while(true){
            try {
                numero = Integer.parseInt(cnsl.readLine(mensagem));
                for (int i: valoresValidos) {
                    if(numero == i) 
                        return numero;
                }
                throw new Exception(mensagemErro);
            }
            catch(Exception e) {
                System.out.println(mensagemErro);
            }
        }
    }

    public static int lerNumero(String mensagem){
        // Loop para somente retornar o valor digitado se um numero maior que 0//
        int numero = 0;
        Console cnsl = System.console();
        while(true){
            try {
                numero = Integer.parseInt(cnsl.readLine(mensagem));
                if (numero > 0) 
                    return numero;
                throw new Exception(mensagemErro);
            }
            catch(Exception e) {
                System.out.println(mensagemErro);
            }
        }
    }

    public static String lerString(String[] valoresValidos, String mensagem){
        // Loop para somente retornar o valor digitado se a informação digitada for valida//
        String str;
        Console cnsl = System.console();
        while(true){
            // Valida se o valor digitado esta dentro da lista de valores validos criado na classe de configuração//
            try {
                str = cnsl.readLine(mensagem).toUpperCase();
                for (String i: valoresValidos) {
                    if(str.toUpperCase().equals(i)  ) return str;
                }
                throw new Exception(mensagemErro);
            }
            catch(Exception e) {
                System.out.println(mensagemErro);
            }
        }
    }

    public static String lerString(String mensagem){
        // Loop para somente retornar o valor digitado se for um caracter normal(não aceita numeros ou caracteres especiais)//
        String str;
        Console cnsl = System.console();
        while(true){
            try {
                str = cnsl.readLine(mensagem);
                //if (str.matches("[a-zA-Z]+")) // aceita apenas caracteres A-Z sem acento
                if (str.matches("[a-zA-Z\\u00C0-\\u00FF ]+")) // aceita caracteres A-Z com ou sem acento
                    return str;
                throw new Exception(mensagemErro);
            }
            catch(Exception e) {
                System.out.println(mensagemErro);
            }
        }
    }
}
