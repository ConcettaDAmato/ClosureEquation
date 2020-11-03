/*
 * GNU GPL v3 License
 *
 * Copyright 2019  Niccolo` Tubini
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package interfaceConductivity;

/**
 * A simple design factory to create an InterfaceHydraulicConductivity object.
 * @author Niccolo' Tubini
 */

public class SimpleInterfaceConductivityFactory {


	/**
	 * Creates a new InterfaceConductivity object.
	 * 
	 * @param type of method to compute the conductivity at interfaces
	 * @return InterfaceConductivity
	 */

	public InterfaceConductivity createInterfaceConductivity (String type) {

		if(type.equalsIgnoreCase("Arithmetic Mean") || type.equalsIgnoreCase("ArithmeticMean")){
			return new InterfaceConductivityArithmeticMean();
		} else if(type.equalsIgnoreCase("Harmonic Mean") || type.equalsIgnoreCase("HarmonicMean")){
			return new InterfaceConductivityHarmonicMean();
		} else if(type.equalsIgnoreCase("Geometric Mean") || type.equalsIgnoreCase("GeometricMean")){
			return new InterfaceConductivityGeometricMean();
		} else if(type.equalsIgnoreCase("Max") || type.equalsIgnoreCase("Maximum")){
			return new InterfaceConductivityMax();
		} else if(type.equalsIgnoreCase("Min") || type.equalsIgnoreCase("Minimum")){
			return new InterfaceConductivityMin();
		} else if(type.equalsIgnoreCase("Average")){
			return new InterfaceConductivityAverage();
		} else {
			System.out.println("\t ERROR: please check interfaceConductivityModel name.");
		}
		

		return null;

	}

}
