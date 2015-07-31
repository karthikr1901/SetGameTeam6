/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetGame;

/**
 *
 * @author Gajaraj Sekar
 */
public class Card {
	private String shading;
	private String symbols;
	private String color;
	private String number;
	
	public Card(String shading,String symbols,String color,String number){
		this.shading=shading;
		this.symbols=symbols;
		this.color=color;
		this.number=number;
	}

	public String getShading() {
		return shading;
	}

	public String getSymbols() {
		return symbols;
	}

	public String getColor() {
		return color;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return shading +symbols + color + number;
	}	
}

