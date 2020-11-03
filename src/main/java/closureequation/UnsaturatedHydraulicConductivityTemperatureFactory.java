/*
 * GNU GPL v3 License
 *
 * Copyright 2019 Niccolo` Tubini
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

/**
 * 
 */
package closureequation;

import rheology.Rheology;

/**
 * @author Niccolo` Tubini
 *
 */

public class UnsaturatedHydraulicConductivityTemperatureFactory {
	
	UnsaturatedHydraulicConductivityTemperatureDecorator unsaturatedHydraulicConductivityTemperature = null;
	
	public UnsaturatedHydraulicConductivityTemperatureDecorator create(String type, Rheology modelSWRC,
																		ClosureEquation modelUHC) {
		
		if( type.equalsIgnoreCase("Ronan") || type.equalsIgnoreCase("Ronan1998") ) {
			unsaturatedHydraulicConductivityTemperature = new Ronan1998(modelSWRC, modelUHC);
		} else if ( type.equalsIgnoreCase("Hornberger") || type.equalsIgnoreCase("Hornberger1998") ) {
			unsaturatedHydraulicConductivityTemperature = new Hornberger1998(modelSWRC, modelUHC);
		} else if ( type.equalsIgnoreCase("No temperature") || type.equalsIgnoreCase("notemperature") ) {
			unsaturatedHydraulicConductivityTemperature = new NoTemperature(modelSWRC, modelUHC);
		}
		
		return unsaturatedHydraulicConductivityTemperature;
		
	}
}
