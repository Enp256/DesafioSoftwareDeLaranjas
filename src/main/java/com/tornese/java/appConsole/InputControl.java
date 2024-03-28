package com.tornese.java.appConsole;

import java.io.Console;

public class InputControl {
    
    static String mensagemErro = "Valor invalido, por favor digite novamente";
    
    public static int lerNumero(String mensagem, int[] valoresValidos){
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
        int numero = 0;
        Console cnsl = System.console();
        while(true){
            try {
                numero = Integer.parseInt(cnsl.readLine(mensagem));
                return numero;
            }
            catch(Exception e) {
                System.out.println(mensagemErro);
            }
        }
    }

    public static String lerString(String[] valoresValidos, String mensagem){
        String str;
        Console cnsl = System.console();
        while(true){
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
        String str;
        Console cnsl = System.console();
        while(true){
            try {
                str = cnsl.readLine(mensagem);
                if (str.matches("[a-zA-Z]+"))
                    return str;
                throw new Exception(mensagemErro);
            }
            catch(Exception e) {
                System.out.println(mensagemErro);
            }
        }
    }
}
