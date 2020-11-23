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
package it.geoframe.blogspot.closureequation.conductivitymodel;

import it.geoframe.blogspot.closureequation.closureequation.ClosureEquation;
import it.geoframe.blogspot.closureequation.conductivitymodel.ConductivityEquation;

/**
 * @author Niccolo` Tubini
 *
 */
public class SoilThermalConductivityCosenza extends ConductivityEquation{
	
	public SoilThermalConductivityCosenza(ClosureEquation closureEquation) {
		super(closureEquation);
		// TODO Auto-generated constructor stub
	}

	private double thermalConductivityAir = 0.023;
	
	public double k(double x, int id, int element) {

		return -9999.0;
	}


	@Override
	public double k(double x, double y, int id, int element) {
		// TODO Auto-generated method stub
		return Math.pow( (1-super.closureEquation.parameters.thetaS[id])*Math.sqrt(super.closureEquation.parameters.thermalConductivitySoilParticles[id]) + super.closureEquation.f(y, x, id)*Math.sqrt(super.closureEquation.parameters.thermalConductivityWater) + (super.closureEquation.parameters.thetaS[id]-super.closureEquation.f(y, x, id))*Math.sqrt(thermalConductivityAir), 2);

	}
	
	
}
