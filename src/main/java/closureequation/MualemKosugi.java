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

import org.apache.commons.math3.special.Erf;

import closureequation.ClosureEquation;
import rheology.Rheology;
import rheology.RheologyParameters;

/**
 * @author Niccolo` Tubini
 *
 */
public class MualemKosugi extends ClosureEquation{
	
	final double l = 0.5;   // Kosugi, 1996
	final double gamma = 2; // Kosugi, 1996
	final double eta = 1;   // Kosugi, 1996
	private double saturationDegree = -999.0;
	
	public MualemKosugi(Rheology rheology) {
		super(rheology);
		// TODO Auto-generated constructor stub
	}
	
	
	public double k(double x, double y, int id, int element) {
			
		saturationDegree = (super.rheology.f(x, y, id) - parameters.thetaR[id])/(parameters.thetaS[id] - parameters.thetaR[id]); 
		if(saturationDegree<1) {
			return parameters.kappaSaturation[id] * Math.pow(this.saturationDegree, 0.5)*Math.pow( ( 0.5*Erf.erfc( Math.log(x/super.parameters.par1[id])/(Math.sqrt(2)*super.parameters.par2[id]) + super.parameters.par2[id]/Math.sqrt(2)  ) ),2 );
		} else {
			return parameters.kappaSaturation[id];
		}
		
	
	}
	
	public double k(double x, int id, int element) {
		
		return -9999.0;
	
	}
	
}
