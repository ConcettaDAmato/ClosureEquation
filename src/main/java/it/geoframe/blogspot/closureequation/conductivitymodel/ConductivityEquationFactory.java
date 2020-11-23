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

package it.geoframe.blogspot.closureequation.conductivitymodel;

import it.geoframe.blogspot.closureequation.closureequation.ClosureEquation;

public class ConductivityEquationFactory {
	
	
	public ConductivityEquation create(String model, ClosureEquation closureEquation) {
		
		ConductivityEquation myModel = null;
		
		if(model.equalsIgnoreCase("Johansen")) {
			myModel = new Johansen(closureEquation);
		} else if (model.equalsIgnoreCase("Mualem Van Genuchten") || model.equalsIgnoreCase("MualemVanGenuchten") || model.equalsIgnoreCase("Mualem VG") ) {
			myModel = new MualemVanGenuchten(closureEquation);
		} else if (model.equalsIgnoreCase("Mualem Brooks Corey") || model.equalsIgnoreCase("MualemBrooksCorey") || model.equalsIgnoreCase("Mualem BC") ) {
			myModel = new MualemBrooksCorey(closureEquation);
		} else if (model.equalsIgnoreCase("Mualem Kosugi") || model.equalsIgnoreCase("MualemKosugy") ) {
			myModel = new MualemKosugi(closureEquation);
		} else if (model.equalsIgnoreCase("Mualem Romano") || model.equalsIgnoreCase("MualemRomano") ) {
			myModel = new MualemRomano(closureEquation);
		} else if (model.equalsIgnoreCase("Soil Thermal Conductivity Cosenza") || model.equalsIgnoreCase("SoilThermalConductivityCosenza") || model.equalsIgnoreCase("Cosenza")) {
			myModel = new SoilThermalConductivityCosenza(closureEquation);
		} else if (model.equalsIgnoreCase("Water Thermal Conductivity") || model.equalsIgnoreCase("WaterThermalConductivity") || model.equalsIgnoreCase("Water")) {
			myModel = new WaterThermalConductivity(closureEquation);
		}  else {
			System.out.println("\n\n\tERROR: please check the name for the unsaturated hydraulic conductivity model.");
		}
		return myModel;
	}

}
