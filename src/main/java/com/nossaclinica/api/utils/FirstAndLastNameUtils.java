package com.nossaclinica.api.utils;

public class FirstAndLastNameUtils {
	 public String get(String nome) {
	        char[] caractater = nome.toCharArray();
	        nome = new String();
	        int cont = 0;
	        String sobrenome = "", aux = "";
	        for(char l : caractater) {

	            if (l != ' ' && cont == 0)
	                nome += l;

	            if (cont > 0 && l != ' ')
	                aux += l;

	            if (l != ' ')
	                sobrenome = aux;

	            if (l == ' ') {
	                aux = new String();
	                cont++;
	            }
	        }
	        return nome + " " + sobrenome;
	    }


}
