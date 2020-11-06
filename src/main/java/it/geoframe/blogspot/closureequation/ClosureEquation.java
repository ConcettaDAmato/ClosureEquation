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
package it.geoframe.blogspot.closureequation;

/**
 * @author Niccolo` Tubini
 *
 */
public abstract class ClosureEquation {
	
	public Parameters parameters;
	
	public ClosureEquation() {
		parameters = Parameters.getInstance();
	}
	
	public abstract double f(double x, double y, int i);

	public abstract double f(double x, int i);	
	
	
	public abstract double df(double x, double y, int i);
	
	public abstract double df(double x, int i);
	
	
	public abstract double ddf(double x, double y, int i);
	
	public abstract double ddf(double x, int i);
	
}
