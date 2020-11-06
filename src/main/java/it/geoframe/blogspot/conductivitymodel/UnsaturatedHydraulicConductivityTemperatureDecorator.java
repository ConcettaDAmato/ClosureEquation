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

package it.geoframe.blogspot.conductivitymodel;

import it.geoframe.blogspot.closureequation.ClosureEquation;

/**
 * @author Niccolo` Tubini
 *
 */

public abstract class UnsaturatedHydraulicConductivityTemperatureDecorator extends ConductivityEquation {
	
	
	UnsaturatedHydraulicConductivityTemperatureDecorator(ClosureEquation modelSWRC) {
		super(modelSWRC);
		// TODO Auto-generated constructor stub
	}
	

}