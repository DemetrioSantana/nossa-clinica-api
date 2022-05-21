package com.nossaclinica.api.utils;

import java.util.ArrayList;
import java.util.List;

public class Questao01 {

	public static void main(String[] args) {
		
		/***
		 * QUESTÃO 01
		 */
		
		//sabe-se que locomotiva é representada pela letra l
		//sabe-se que ferroviário é representado pela letra f
		//sabe-se que vagão é representado pela letra v
		String[] locomotiva = {"l", "f", "f", "f", "f", "v", "v", "v", "v", "v", "v"};
		
		int somaLocomotiva = 0, somaFerroviario = 0, somaVagao = 0;
		for (String loc : locomotiva) {
			somaLocomotiva 		+= loc == "l" ? 1 : 0;
			somaFerroviario 	+= loc == "f" ? 1 : 0;
			somaVagao			+= loc == "v" ? 1 : 0;
		}
		int somaTempo = ((somaLocomotiva * 5) + (somaFerroviario * 15) + (somaVagao * 10));
		System.out.println("A soma total do tempo é: " + somaTempo);
	
	
		/***
		 * QUESTÃO 02
		 */
		

		List<String> metalA = new ArrayList<>();
		int[] metalB={20,35,13,200,110};
		int[] metalC={60,10,13,100,60};
		
		if(metalB.length == metalC.length) {
			for(int i = 0;  i < metalB.length;  i++) {
				if(metalB[i] < 30)
					metalA.add("RUIM");
				else if(metalB[i] > 30 && metalB[i] < 50)
					metalA.add("BOA");
				else if(metalB[i] == 50)
					metalA.add("REGULAR");
				else if(metalB[i] > 50)
					metalA.add("ÓTIMA");
			}
			
			for(String metal : metalA)
				System.out.println(metal);
		}
		
	
	
	}
	
	
	

}
