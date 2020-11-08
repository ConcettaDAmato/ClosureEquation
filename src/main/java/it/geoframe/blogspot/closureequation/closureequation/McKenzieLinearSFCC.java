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
 * McKenzie, Jeffrey M., Clifford I. Voss, and Donald I. Siegel. 
 * "Groundwater flow with energy transport and water–ice phase change: numerical simulations, benchmarks, 
 * and application to freezing in peat bogs." 
 * Advances in water resources 30.4 (2007): 966-983.
 * https://doi.org/10.1016/j.advwatres.2006.08.008
 */
public class McKenzieLinearSFCC extends SoilFreezingCharacteristicCurve {
	
	/*
	 * T_res = super.parameters.meltingTemperature[id]
	 */
	
	@Override
	public double f(double x, int id) {
		
		
		if(x>=273.15) {
			return super.parameters.thetaS[id];
		} else if (x<super.parameters.meltingTemperature[id]){
			return super.parameters.thetaR[id]; 
		} else {
			return super.parameters.thetaR[id] + (super.parameters.thetaS[id]-super.parameters.thetaR[id])/(273.15-super.parameters.meltingTemperature[id]) * (x-super.parameters.meltingTemperature[id]);
		}
	}
	
	
	
	@Override
	public double df(double x, int id) {
		
		if(x>=273.15) {
			return 0.0;
		} else if(x<super.parameters.meltingTemperature[id]) {
			return 0.0;
		} else {
			return (super.parameters.thetaS[id]-super.parameters.thetaR[id])/(273.15-super.parameters.meltingTemperature[id]);
		}
	}
	

	@Override
	public double ddf(double x, int id) {
		
		return 0.0;
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