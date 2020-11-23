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
public class MualemBrooksCorey extends ConductivityEquation{
	
	private double saturationDegree = -999.0;
	
	public MualemBrooksCorey(ClosureEquation closureEquation) {
		super(closureEquation);
	}
	
	
	public double k(double x, double y, int id, int element) {
			
		saturationDegree = (super.closureEquation.f(x, y, id) - super.closureEquation.parameters.thetaR[id])/(super.closureEquation.parameters.thetaS[id] -super.closureEquation.parameters.thetaR[id]); 
		if(saturationDegree<1) {
			return super.closureEquation.parameters.kappaSaturation[id] * Math.pow(saturationDegree, 3+2/super.closureEquation.parameters.par1[id]);
		} else {
			return super.closureEquation.parameters.kappaSaturation[id];
		}
		
	
	}
	
	public double k(double x, int id, int element) {
		
		return -9999.0;
	
	}
	
}
