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
public class SWRCVanGenuchtenDallAmico extends SoilWaterRetentionCurve {

	private double m;
	private double meltingTemperature;
	private double tmp;
	private double psiT;
	
	
	@Override
	public double f(double x, double y, int id) {

		m = 1-1/super.parameters.par1[id];
		meltingTemperature = 273.15 + 9.81*273.15/super.parameters.latentHeatFusion*x;
		if(y>meltingTemperature) {
			if(x>=0) {
				return super.parameters.thetaS[id];
			} else {
				return super.parameters.thetaR[id] + (super.parameters.thetaS[id]-super.parameters.thetaR[id])
						*Math.pow( 1.0 + Math.pow(Math.abs(super.parameters.par2[id]*x), super.parameters.par1[id]), -m); 
			}
		} else {
			psiT = x + super.parameters.latentHeatFusion/(9.81*meltingTemperature)*(y-meltingTemperature);
			if(psiT>=0) {
				return super.parameters.thetaS[id];
			} else {
				return super.parameters.thetaR[id] + (super.parameters.thetaS[id]-super.parameters.thetaR[id])
						*Math.pow( 1.0 + Math.pow(Math.abs(super.parameters.par2[id]*psiT), super.parameters.par1[id]), -m); 
			}
		}
		
	}



	@Override
	public double df(double x, double y, int id) {
		
		m = 1-1/super.parameters.par1[id];
		meltingTemperature = 273.15 + 9.81*273.15/super.parameters.latentHeatFusion*x;
		if(y>meltingTemperature) {
			if(x>=0) {
				return 0.0;
			} else {
				return 0.0; 
			}
		} else {
			psiT = x+super.parameters.latentHeatFusion/(9.81*meltingTemperature)*(y-meltingTemperature);
			tmp = super.parameters.latentHeatFusion/(9.81*meltingTemperature);
			if(psiT>=0) {
				return 0.0;
			} else {
//				return (super.parameters.thetaS[id]-super.parameters.thetaR[id])*m*super.parameters.par1[id]*super.parameters.par2[id]*tmp
//						*Math.pow( 1.0 + Math.pow(Math.abs(super.parameters.par2[id]*(x+tmp*(y-meltingTemperature))), super.parameters.par1[id]), -m-1)
//						*Math.pow(Math.abs(super.parameters.par2[id]*(x+tmp*(y-meltingTemperature))), super.parameters.par1[id]-1); 
				return (super.parameters.thetaS[id]-super.parameters.thetaR[id])*m*super.parameters.par1[id]*super.parameters.par2[id]*tmp
						*Math.pow( 1.0 + Math.pow(Math.abs(super.parameters.par2[id]*psiT), super.parameters.par1[id]), -m-1)
						*Math.pow(Math.abs(super.parameters.par2[id]*psiT), super.parameters.par1[id]-1); 
			}
		}
		
	}


	@Override
	public double ddf(double x, double y, int id) {
		
		m = 1-1/super.parameters.par1[id];
		meltingTemperature = 273.15 + 9.81*273.15/super.parameters.latentHeatFusion*x;
		if(y>meltingTemperature) {
			if(x>0) {
				return 0.0;
			} else {
				return 0.0; 
			}
		} else {
			psiT = x+super.parameters.latentHeatFusion/(9.81*meltingTemperature)*(y-meltingTemperature);
			tmp = super.parameters.latentHeatFusion/(9.81*meltingTemperature);
			if(psiT>=0) {
				return 0.0;
			} else {
//				return (super.parameters.thetaS[id]-super.parameters.thetaR[id])*m*super.parameters.par1[id] * Math.pow( Math.abs(super.parameters.par2[id]*(x+tmp*(y-meltingTemperature))), super.parameters.par1[id] ) * Math.pow(1+Math.pow(Math.abs(super.parameters.par2[id]*(x+tmp*(y-meltingTemperature))),super.parameters.par1[id]), -m-2)*
//						(  super.parameters.par1[id]*Math.pow(super.parameters.par2[id]*tmp,2)*(m+1) * Math.pow(Math.abs(super.parameters.par2[id]*(x+tmp*(y-meltingTemperature))),super.parameters.par1[id]-2) -
//								(super.parameters.par1[id]-1)*Math.pow(super.parameters.par2[id]*tmp,2) * Math.pow(Math.abs(super.parameters.par2[id]*tmp*(y-meltingTemperature)),-2) * (1+Math.pow(Math.abs(super.parameters.par2[id]*(x+tmp*(y-meltingTemperature))),super.parameters.par1[id]))   ); 
				return (super.parameters.thetaS[id]-super.parameters.thetaR[id])*m*super.parameters.par1[id] * Math.pow( Math.abs(super.parameters.par2[id]*psiT), super.parameters.par1[id] ) * Math.pow(1+Math.pow(Math.abs(super.parameters.par2[id]*psiT),super.parameters.par1[id]), -m-2) *
						(  super.parameters.par1[id]*Math.pow(super.parameters.par2[id]*tmp,2)*(m+1) * Math.pow(Math.abs(super.parameters.par2[id]*psiT),super.parameters.par1[id]-2) -
								(super.parameters.par1[id]-1)*Math.pow(super.parameters.par2[id]*tmp,2) * Math.pow(Math.abs(super.parameters.par2[id]*psiT),-2) * (1+Math.pow(Math.abs(super.parameters.par2[id]*psiT),super.parameters.par1[id]))   ); 
			}
		}
		
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