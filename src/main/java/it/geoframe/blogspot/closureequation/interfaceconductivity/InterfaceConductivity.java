package it.geoframe.blogspot.closureequation.interfaceconductivity;
/*
 * GNU GPL v3 License
 *
 * Copyright 2019  Niccolo` Tubini
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
 * Compute conductivity coefficient (hydraulic, thermal) at control volume interface
 * It is possible to compute conductivity K(i+1/2) as:
 * - the average of k[i] and k[i+1]
 * - the max(k[i],k[i+1])
 * - the min(k[i],k[i+1])
 * @author Niccolo' Tubini
 */
public abstract class InterfaceConductivity {
		
	public abstract double compute(double value1, double value2, double volume1, double volume2);
	
}
