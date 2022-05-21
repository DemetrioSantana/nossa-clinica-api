package com.nossaclinica.api.utils;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public class Test {

	public static void main(String[] args) {
		String nome = "Thália Maria de Sousa";
		String userName = createUserName(nome);
		
		List<BigDecimal> valores = new ArrayList<BigDecimal>();
		valores.add(new BigDecimal(150.00));
		valores.add(new BigDecimal(10.00));
		valores.add(new BigDecimal(115.00));
		valores.add(new BigDecimal(86.00));
		
		Double desconto = new Double(0.95);
		
		Double valorCalculado = valores.stream()
				.mapToDouble(a -> Double.parseDouble(String.valueOf(a)))
				.sum();
        
		System.out.println("SOMA = "+ valorCalculado);
		System.out.println("DESCONTO = "+ desconto);
		
		System.out.println("VALOR CALCULADO = "+ String.valueOf(valorCalculado) + " * " + String.valueOf(desconto) + " = " + (valorCalculado * desconto));
		
		
		
        System.out.println("USER NAME: "+userName); 

	}
	
	public static String createUserName(String nome) {
		String userName = "";
	
		char[] caractater = nome.toCharArray();
		String firstName = new String();
		int cont = 0;
		String lastName = "";
		for(char l : caractater) {
			if (l != ' ' && cont == 0) 
				firstName += l;
			if (cont > 0)
				lastName += l;
			if (l == ' ') {
				cont++;
				lastName = new String();
			}
		}
		
		userName = removerAcentos(firstName.toLowerCase())+"."+removerAcentos(lastName.toLowerCase());
		
		criarSenha(nome);
		return userName;
	}
	
	private static void criarSenha(String nome) {
		
		char[] caractater = nome.toCharArray();
		String iniciais = new String();
		int cont = 0;
		for(char l : caractater) {
			if (l != ' ' && cont == 0) 
				iniciais += l;
			cont++;
			if (l == ' ') {
				cont = 0;
			}
		}
		
		System.out.println("PASSWORD: "+removerAcentos(iniciais)+"@"+UUID.randomUUID().toString().substring(0, 5));
	}
	
	public static String removerAcentos(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	
	
	public class user {
		@Getter @Setter
		private String nome;
		@Getter @Setter
		private String senha;
		
		
		
				
	}

}
