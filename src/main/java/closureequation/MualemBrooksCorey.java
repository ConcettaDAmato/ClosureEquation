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

import closureequation.ClosureEquation;
import rheology.Rheology;

/**
 * @author Niccolo` Tubini
 *
 */
public class MualemBrooksCorey extends ClosureEquation{
	
	private double saturationDegree = -999.0;
	
	public MualemBrooksCorey(Rheology rheology) {
		super(rheology);
	}
	
	
	public double k(double x, double y, int id, int element) {
			
		saturationDegree = (super.rheology.f(x, y, id) - super.rheology.parameters.thetaR[id])/(super.rheology.parameters.thetaS[id] -super. rheology.parameters.thetaR[id]); 
		if(saturationDegree<1) {
			return super.rheology.parameters.kappaSaturation[id] * Math.pow(saturationDegree, 3+2/super.rheology.parameters.par1[id]);
		} else {
			return super.rheology.parameters.kappaSaturation[id];
		}
		
	
	}
	
	public double k(double x, int id, int element) {
		
		return -9999.0;
	
	}
	
}
