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

package it.geoframe.blogspot.closureequation.closureequation;

/**
 * @author Niccolo` Tubini
 *
 */

public class SoilFreezingCharacteristicCurveFactory {
	
	
	public SoilFreezingCharacteristicCurve create(String model) {
		
		SoilFreezingCharacteristicCurve myModel = null;
		
		if(model.equalsIgnoreCase("DallAmico")) {
			myModel = new DallAmicoSFCC();
		}else if(model.equalsIgnoreCase("Lunardini")) {
			myModel = new LunardiniSFCC();
		}else if(model.equalsIgnoreCase("McKenzieLinear")) {
			myModel = new McKenzieLinearSFCC();
		}else if(model.equalsIgnoreCase("None")) {
			myModel = new NoneSFCC();
		}else {
			System.out.println("\tERROR: please check sfccModel name.");
		}
		return myModel;
	}

}
