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
package rheology;

/**
 * @author Niccolo` Tubini
 *
 * Dall'Amico, M., et al. "Energy conservative algorithm for phase 
 * change in freezing unsaturated soils using the hydrological model GEOtop."
 * EGUGA (2009): 7455.
 * https://doi.org/10.5194/tc-5-469-2011, 2011
 */
public class DallAmicoSFCC extends SoilFreezingCharacteristicCurve {
	
	private double m;
	private double tmp;
	
	@Override
	public double f(double x, int id) {
		
		m = 1-1/super.parameters.par2[id];
		
		if(x>=super.parameters.meltingTemperature[id]) {
			return super.parameters.thetaS[id];
		} else {
			tmp = super.parameters.par1[id]*super.parameters.latentHeatFusion/(9.81*super.parameters.meltingTemperature[id]);
			return super.parameters.thetaR[id] + (super.parameters.thetaS[id]-super.parameters.thetaR[id])
					*Math.pow( 1.0 + Math.pow(tmp*Math.abs(x-super.parameters.meltingTemperature[id]), super.parameters.par2[id]), -m); 
		}
	}
	
	
	
	@Override
	public double df(double x, int id) {
		m = 1-1/super.parameters.par2[id];
		
		if(x>=super.parameters.meltingTemperature[id]) {
			return 0.0;
		} else {
			tmp = super.parameters.par1[id]*super.parameters.latentHeatFusion/(9.81*super.parameters.meltingTemperature[id]);
			return (super.parameters.thetaS[id]-super.parameters.thetaR[id])*m*super.parameters.par2[id]*tmp
					*Math.pow( 1.0 + Math.pow(tmp*Math.abs(x-super.parameters.meltingTemperature[id]), super.parameters.par2[id]), -m-1.0)
					*Math.pow(tmp*Math.abs(x-super.parameters.meltingTemperature[id]), super.parameters.par2[id]-1.0); 
		}
	}
	

	@Override
	public double ddf(double x, int id) {
		m = 1-1/super.parameters.par2[id];
		
		if(x>=super.parameters.meltingTemperature[id]) {
			return 0.0;
		} else {
			tmp = super.parameters.par1[id]*super.parameters.latentHeatFusion/(9.81*super.parameters.meltingTemperature[id]);
			return (super.parameters.thetaS[id]-super.parameters.thetaR[id])*m*super.parameters.par2[id]*Math.pow(tmp*Math.abs(x-super.parameters.meltingTemperature[id]),super.parameters.par2[id]) *
					Math.pow( 1.0 + Math.pow(tmp*Math.abs(x-super.parameters.meltingTemperature[id]), super.parameters.par2[id]), -m-2.0) *
					( Math.pow(tmp, 2.0)*(m+1.0)*super.parameters.par2[id]*Math.pow(tmp*Math.abs(x-super.parameters.meltingTemperature[id]), super.parameters.par2[id]-2.0) + 
					  - Math.pow(tmp, 2.0)*(1.0+Math.pow(tmp*Math.abs(x-super.parameters.meltingTemperature[id]), super.parameters.par2[id]))*Math.pow(tmp*Math.abs(x-super.parameters.meltingTemperature[id]), -2.0)*(super.parameters.par2[id]-1.0) );
		}
	}



	@Override
	public double f(double x, double y, int i) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public double df(double x, double y, int i) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public double ddf(double x, double y, int i) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}