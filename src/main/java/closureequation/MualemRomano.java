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

/**
 * @author Niccolo` Tubini
 *
 */
public class MualemRomano extends ClosureEquation{
	
	private double alpha;
	private double beta;
	private double a;
	private double b;
	private double saturationDegree = -999.0;
	
	public MualemRomano(Rheology rheology) {
		super(rheology);
		// TODO Auto-generated constructor stub
	}
	
	
	public double k(double x, double y, int id, int element) {
		
		saturationDegree = (super.rheology.f(x, y, id) - super.rheology.parameters.thetaR[id])/(super.rheology.parameters.thetaS[id] - super.rheology.parameters.thetaR[id]); 
		if(saturationDegree<1) {
			alpha= ( Math.pow(super.rheology.parameters.par2[id], 2) + Math.log(x/super.rheology.parameters.par4[id]) ) / ( super.rheology.parameters.par2[id]*Math.sqrt(2) );
			beta = ( Math.pow(super.rheology.parameters.par3[id], 2) + Math.log(x/super.rheology.parameters.par5[id]) ) / ( super.rheology.parameters.par3[id]*Math.sqrt(2) );
			a = super.rheology.parameters.par1[id]/super.rheology.parameters.par4[id] * Math.exp(Math.pow(super.rheology.parameters.par2[id],2)/2);
			b = (1-super.rheology.parameters.par1[id])/super.rheology.parameters.par5[id] * Math.exp(Math.pow(super.rheology.parameters.par3[id],2)/2);
			return super.rheology.parameters.kappaSaturation[id] * Math.sqrt(this.saturationDegree)/(4*Math.pow(a+b, 2)) * Math.pow(a*Erf.erfc(alpha) + b*Erf.erfc(beta), 2);
		} else {
			return super.rheology.parameters.kappaSaturation[id];
		}
		
	
	}
	
	public double k(double x, int id, int element) {
		
		return -9999.0;
	
	}
	
}
