package es.cic.taller.ejercicio09.mus;

import java.util.ArrayList;
import java.util.List;

public class Tapete {
	private Carta carta1;
	private Carta carta2;
	private Carta carta3;
	private Carta carta4;
	
	public Carta getCarta1() {
		return carta1;
	}
	public void setCarta1(Carta carta1) {
		this.carta1 = carta1;
	}
	public Carta getCarta2() {
		return carta2;
	}
	public void setCarta2(Carta carta2) {
		this.carta2 = carta2;
	}
	public Carta getCarta3() {
		return carta3;
	}
	public void setCarta3(Carta carta3) {
		this.carta3 = carta3;
	}
	public Carta getCarta4() {
		return carta4;
	}
	public void setCarta4(Carta carta4) {
		this.carta4 = carta4;
	}
	
	public int getPuntuacion() {
		return 
				carta1.getNumero().getValor() +
				carta2.getNumero().getValor() + 
				carta3.getNumero().getValor() + 
				carta4.getNumero().getValor();
	}
	
	public static int compararMayor(Tapete tapete1, Tapete tapete2) {
		List<Carta> listaCartasTapete1 = getCartasOrdenas(tapete1);
		List<Carta> listaCartasTapete2 = getCartasOrdenas(tapete2);
		
		int resultado = 0;
		
		for (int i = 0 ; i< listaCartasTapete1.size(); i++) {
			int numero1 = listaCartasTapete1.get(i).getNumero().getNumero();
			int numero2 = listaCartasTapete2.get(i).getNumero().getNumero();
			
			if (noSonIguales(numero1, numero2)) {
				resultado = numero2 - numero1;
				break;
			}
		}
		return resultado;		
	}	
	
	public static int compararMenor(Tapete tapete1, Tapete tapete2) {
		List<Carta> listaCartasTapete1 = getCartasOrdenas(tapete1);
		List<Carta> listaCartasTapete2 = getCartasOrdenas(tapete2);
		
		int resultado = 0;
		
		for (int i = listaCartasTapete1.size()-1 ; i>=0; i--) {
			int numero1 = listaCartasTapete1.get(i).getNumero().getNumero();
			int numero2 = listaCartasTapete2.get(i).getNumero().getNumero();
			
			if (noSonIguales(numero1, numero2)) {
				resultado = numero1 - numero2;
				break;
			}
		}
		return resultado;		
	}
	public static int compararPares(Tapete tapete1, Tapete tapete2) {
		List<Carta> listaCartasTapete1 = getCartasOrdenas(tapete1);
		List<Carta> listaCartasTapete2 = getCartasOrdenas(tapete2);
		return miramosLosPares(listaCartasTapete1, listaCartasTapete2);
	}
	private static int miramosLosPares(List<Carta> listaCartasTapete1, List<Carta> listaCartasTapete2) {
		int pares1=0;
		int pares2=0;
		int numeroMayor1=0;
		int numeroMayor2=0;
		for (int i=0;i<listaCartasTapete1.size();i++) {
			int j;
		for (j=i+1;j<listaCartasTapete1.size();j++) {
			int primerNumero=numeroRealDeLaCarta(listaCartasTapete1, i);
			int segundoNumero=numeroRealDeLaCarta(listaCartasTapete1, j);
			if (laCartaTienePareja(primerNumero, segundoNumero)){
				++pares1;
				if (cualEsLaCartaMayor(numeroMayor1, primerNumero)){
					numeroMayor1=primerNumero;
				}
			}
			int primerNumero2=numeroRealDeLaCarta(listaCartasTapete2, i);
			int segundoNumero2=numeroRealDeLaCarta(listaCartasTapete2, j);
			if (laCartaTienePareja(primerNumero2, segundoNumero2)){
				++pares2;
				if (cualEsLaCartaMayor(numeroMayor2, primerNumero2)){
					numeroMayor2=primerNumero2;
				}
		}
		}	
		}if(pares1==2) {
			pares1=6;
		}if (pares2==2) {
			pares2=6;
		}
		if (noSonIguales(pares1, pares2)) {
			return pares1-pares2;
		}
		if (noSonIguales(numeroMayor1, numeroMayor2)) {
			return numeroMayor1-numeroMayor2;
		} int u=0;
		int v=0;
		for (int i=0;i<listaCartasTapete1.size();i++) {
			u+=numeroRealDeLaCarta(listaCartasTapete1, i);
			v+=numeroRealDeLaCarta(listaCartasTapete1, i);
			if (noSonIguales(u, v)) {
				return u-v;
			}
		} return +1;
	}
	private static boolean noSonIguales(int pares1, int pares2) {
		return pares1!=pares2;
	}
	private static boolean cualEsLaCartaMayor(int numeroMayor1, int primerNumero) {
		return primerNumero>numeroMayor1;
	}
	private static int numeroRealDeLaCarta(List<Carta> listaCartasTapete1, int i) {
		return Numero.getNumeroReal(listaCartasTapete1.get(i).getNumero().getNumero());
	}
	private static boolean laCartaTienePareja(int primerNumero, int segundoNumero) {
		return primerNumero==segundoNumero;
	}
   
	
	private static List<Carta> getCartasOrdenas(Tapete tapete) {
		List<Carta> listaCartas = new ArrayList<>();
		listaCartas.add(tapete.getCarta1());
		listaCartas.add(tapete.getCarta2());
		listaCartas.add(tapete.getCarta3());
		listaCartas.add(tapete.getCarta4());
		
		for (int i = 0; i < listaCartas.size() - 1; i++) {
			int indiceMayor = i;
			for (int j = i + 1; j < listaCartas.size(); j++) {
				if (listaCartas.get(j).getNumero().getNumero() > 
					listaCartas.get(indiceMayor).getNumero().getNumero()) {
					indiceMayor = j;
				}
				
			}
			Carta aux = listaCartas.get(i);
			listaCartas.set(i, listaCartas.get(indiceMayor));
			listaCartas.set(indiceMayor, aux);

		}
		return listaCartas;
	}
	
}
