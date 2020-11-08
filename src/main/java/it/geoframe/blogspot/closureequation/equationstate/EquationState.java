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
package it.geoframe.blogspot.closureequation.equationstate;

import it.geoframe.blogspot.closureequation.closureequation.ClosureEquation;

/**
 * @author Niccolo` Tubini
 *
 */
public abstract class EquationState {
	
	protected ClosureEquation rheology;
	
	public EquationState(ClosureEquation rheology) {
		this.rheology = rheology;
	}
	
	public abstract double stateEquation(double x, double y, int id, int element);

	
	
	public abstract double dStateEquation(double x, double y, int id, int element);
	
	
	
	public abstract double ddStateEquation(double x, double y, int id, int element);
	
	
	
	public abstract double p(double x, double y, int id, int element);
	
	
	public abstract double pIntegral(double x, double y, int id, int element);

	
	public abstract void computeXStar(double y, int id, int element);
	
	
	public abstract double initialGuess(double x, int id, int element);
	
	
	public double q(double x, double y, int id, int element) {
		return p(x, y, id, element) - dStateEquation(x, y, id, element);
	}
	
	
	
	public double qIntegral(double x,double y,  int id, int element) {
		return pIntegral(x, y, id, element) - stateEquation(x, y, id, element);
	}

}
