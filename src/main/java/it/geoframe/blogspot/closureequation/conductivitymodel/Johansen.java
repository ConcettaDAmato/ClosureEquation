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
public class Johansen extends ConductivityEquation{
	
	public Johansen(ClosureEquation rheology) {
		super(rheology);
		// TODO Auto-generated constructor stub
	}

	private double iceRatio;
	private double kerstenNumber;
	private double lambdaSat;
	private double lambdaDry;
	
	
	public double k(double x, int id, int element) {
		
		iceRatio = (super.closureEquation.parameters.thetaS[id] - closureEquation.f(x, id))/super.closureEquation.parameters.thetaS[id];
		kerstenNumber = 1.0; // soil is assumed to be always saturated
		
		return Math.pow(super.closureEquation.parameters.thermalConductivitySoilParticles[id], 1-super.closureEquation.parameters.thetaS[id]) * Math.pow(super.closureEquation.parameters.thermalConductivityWater, (1-iceRatio)*super.closureEquation.parameters.thetaS[id]) * Math.pow(super.closureEquation.parameters.thermalConductivityIce, iceRatio*super.closureEquation.parameters.thetaS[id]);
	}


	@Override
	public double k(double x, double y, int id, int element) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
