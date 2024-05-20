package edu.utfpr;

/*
 * Preenche à esquerda uma string com uma string especificada.
 * 
 * str: a string a ser preenchida - pode ser null;
 * size: o tamanho máximo da string preenchida;
 * padStr: a string usada para preencher - null ou vazio é tratado como se fosse um espaço em branco;
 * 
 * O método retorna: uma string preenchida à esquerda,
 * a string original se o preenchimento não for necessário,
 * ou null se uma string com o valor null for dada como entrada.
 */

public class LeftPad {
    public static String leftPad(final String str, final int size, String padStr) {
        
        //string com valor null encontrada
        if(str == null){
            return null;
        }

        //string original
        if(str.length() == size){
            return str;
        }
        
        //pad é null ou vazio, vira espaço em branco
        if(padStr == null || padStr.isEmpty()){
            padStr = " ";
        }
        
        int sizePad = size - str.length();
        StringBuilder left = new StringBuilder();

        while(left.length() < sizePad){
            left.append(padStr);
        }
        left.append(str);

        //String finalStr = left.toString;
        //return finalStr;

        return left.toString();
    }
}