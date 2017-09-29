package be.pxl.computerstore;

import java.util.Scanner;

import be.pxl.computerstore.data.Warehouse;
import be.pxl.computerstore.hardware.ComputerCase;
import be.pxl.computerstore.hardware.ComputerPart;
import be.pxl.computerstore.hardware.ComputerSystem;
import be.pxl.computerstore.hardware.Peripheral;
import be.pxl.computerstore.hardware.Processor;
import be.pxl.computerstore.util.TooManyPeripheralsException;

public class ComputerSystemConfigurator {

	public static void main(String[] args) throws TooManyPeripheralsException {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Stel hier je computer samen!");
		ComputerSystem computerSystem = new ComputerSystem();
		while (computerSystem.getComputerCase() == null) {
			System.out.println("Kies uw behuizing (geef artikelnummer): ");
			displayComputerCases();
			String artikelnummer = keyboard.nextLine();
			ComputerPart chosen = getComputerComponent(artikelnummer);
			if (chosen instanceof ComputerCase) {
				computerSystem.setComputerCase((ComputerCase) chosen);
			}
		}
		while (computerSystem.getProcessor() == null) {
			System.out.println("Kies uw processor (geef artikelnummer): ");
			displayProcessors();
			String artikelnummer = keyboard.nextLine();
			ComputerPart chosen = getComputerComponent(artikelnummer);
			if (chosen instanceof Processor) {
				computerSystem.setProcessor((Processor) chosen);
			}
		}
		boolean choosePeripheral = true;

		do {
			System.out.println("Kies een randapparaat (geef artikelnummer): ");
			displayPeripherals();
			String artikelnummer = keyboard.nextLine();
			ComputerPart chosen = getComputerComponent(artikelnummer);
			if (chosen instanceof Peripheral) {
				computerSystem.addPeripheral((Peripheral) chosen);
			}
			System.out.println("Wil u nog een randaparaat toevoegen (j/n)?");
			choosePeripheral = keyboard.nextLine().equals("j");
		} while(choosePeripheral);
		// TODO catch TooManyPeripheralsException
		System.out.println("De door u gekozen computer:");
		System.out.println(computerSystem);
		keyboard.close();
	}

	public static void displayComputerCases() {
		for (ComputerPart component : Warehouse.computerParts) {
			if (component instanceof ComputerCase) {
				System.out.println(component.getShortDescription());
			}
		}
	}
	
	public static void displayProcessors() {
		for (ComputerPart component : Warehouse.computerParts) {
			if (component instanceof Processor) {
				System.out.println(component.getShortDescription());
			}
		}
	}
	
	public static void displayPeripherals() {
		for (ComputerPart component : Warehouse.computerParts) {
			if (component instanceof Peripheral) {
				System.out.println(component.getShortDescription());
			}
		}
	}

	public static ComputerPart getComputerComponent(String artikelnummer) {
		for (ComputerPart component : Warehouse.computerParts) {
			if (component.getArticleNumber().equals(artikelnummer)) {
				return component;
			}
		}
		return null;
	}

	
}
