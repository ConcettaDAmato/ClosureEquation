/*
 * GNU GPL v3 License
 *
 * Copyright 2019 Niccolò Tubini
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

/**
 * @author Niccolo` Tubini
 *
 */

public class Ronan1998  extends UnsaturatedHydraulicConductivityTemperatureDecorator {
	
	private ConductivityEquation modelUHC;
	
	
	
	public Ronan1998(ClosureEquation modelSWRC, ConductivityEquation modelUHC) {
		
		super(modelSWRC);
		this.modelUHC = modelUHC;
		
	}

	
	@Override
	public double k(double x, int id, int element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double k(double x, double y, int id, int element) {
		// TODO Auto-generated method stub
		return  this.modelUHC.k(x, y, id, element) * 0.00002414*Math.pow(10, 247.8/(20+133.16)) / (0.00002414*Math.pow(10, 247.8/(y-273.15+133.16)));
}

}
