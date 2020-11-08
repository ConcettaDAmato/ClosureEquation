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
package it.geoframe.blogspot.closureequation.closureequation;



/**
 * @author Niccolo` Tubini
 *
 * Van Genuchten SWRC
 */
public class SWRCVanGenuchten extends SoilWaterRetentionCurve {

	private double m;

	@Override
	public double f(double x, double y, int id) {

		m = 1-1/super.parameters.par1[id];

		if(x>0.0) {
			return super.parameters.thetaS[id] +
					9.81*(super.parameters.alphaSpecificStorage[id] + super.parameters.thetaS[id]*super.parameters.betaSpecificStorage[id])*x;
		} else {
			
			return super.parameters.thetaR[id] + (super.parameters.thetaS[id]-super.parameters.thetaR[id])
					*Math.pow( 1.0 + Math.pow(Math.abs(super.parameters.par2[id]*x), super.parameters.par1[id]), -m); 
		}
	}



	@Override
	public double df(double x, double y, int id) {
		m = 1-1/super.parameters.par1[id];

		if(x>0.0) {
			return 9.81*( super.parameters.alphaSpecificStorage[id] + super.parameters.thetaS[id]*super.parameters.betaSpecificStorage[id] );
		} else {
			return super.parameters.par2[id]*super.parameters.par1[id]*this.m*(super.parameters.thetaS[id] - super.parameters.thetaR[id]) / Math.pow(1.0 + Math.pow(Math.abs(super.parameters.par2[id]*x), super.parameters.par1[id]), this.m + 1.0)*Math.pow(Math.abs(super.parameters.par2[id]*x), super.parameters.par1[id] - 1.0);
		}
	}


	@Override
	public double ddf(double x, double y, int id) {
		
		return -9999.0;
		
	}



	@Override
	public double f(double x, int i) {

		return -9999.0;
		
	}



	@Override
	public double df(double x, int i) {

		return -9999.0;
		
	}



	@Override
	public double ddf(double x, int i) {

		return 0;
		
	}


}