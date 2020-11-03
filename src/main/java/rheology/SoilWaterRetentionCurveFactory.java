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

package rheology;

/**
 * @author Niccolo` Tubini
 *
 */

public class SoilWaterRetentionCurveFactory {
	
	
	public SoilWaterRetentionCurve create(String model) {
		
		SoilWaterRetentionCurve myModel = null;
		
		if(model.equalsIgnoreCase("Van Genuchten") || model.equalsIgnoreCase("VanGenuchten") || model.equalsIgnoreCase("VG")) {
			myModel = new SWRCVanGenuchten();
		}else if(model.equalsIgnoreCase("Brooks Corey") || model.equalsIgnoreCase("BrooksCorey") || model.equalsIgnoreCase("BC")) {
			myModel = new SWRCBrooksCorey();
		}else if(model.equalsIgnoreCase("Kosugi")) {
			myModel = new SWRCKosugi();
		}else if(model.equalsIgnoreCase("Romano")) {
			myModel = new SWRCRomano();
		}else {
			System.out.println("\n\n\tERROR: please check swrcModel name.");
		}

		return myModel;
	}

}
