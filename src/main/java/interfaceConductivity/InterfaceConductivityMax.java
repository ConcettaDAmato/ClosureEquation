package interfaceConductivity;
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
 * Compute conductivity at control volume interface as the maximum of k[i] and k[i+1]
 * @author Niccolo' Tubini
 */

public class InterfaceConductivityMax extends InterfaceConductivity {

	@Override
	public double compute(double value1, double value2, double volume1, double volume2) {

		return Math.max(value1, value2);
		
	}

}
