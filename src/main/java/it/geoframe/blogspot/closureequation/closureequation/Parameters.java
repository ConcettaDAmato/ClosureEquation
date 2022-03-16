package it.geoframe.blogspot.closureequation.closureequation;


public class Parameters {
	
	private static Parameters uniqueInstance;
	
	public static Parameters getInstance() {
		/*if (uniqueInstance == null) {
			uniqueInstance = new Variables(waterSuction, temperature);
		}*/
		return uniqueInstance;
	}
	
	public static Parameters getInstance(double waterDensity, double iceDensity, double specificThermalCapacityWater,
			double specificThermalCapacityIce, double thermalConductivityWater, double thermalConductivityIce, double latentHeatFusion, double referenceTemperatureInternalEnergy,
			double referenceTemperatureSWRC, double beta0,
			double[] thetaS, double[] thetaR, double[] soilParticlesDensity, double[] specificThermalCapacitySoilParticles, double[] thermalConductivitySoilParticles,
			double[] meltingTemperature, double[] par1, double[] par2, double[] par3, double[] par4, double[] par5, double[] kappaSaturation,
			double[] alphaSpecificStorage, double[] betaSpecificStorage) {
		if (uniqueInstance == null) {
			uniqueInstance = new Parameters(waterDensity, iceDensity, specificThermalCapacityWater,
					 specificThermalCapacityIce, thermalConductivityWater, thermalConductivityIce, latentHeatFusion, referenceTemperatureInternalEnergy, referenceTemperatureSWRC, beta0,
					 thetaS, thetaR, soilParticlesDensity, specificThermalCapacitySoilParticles, thermalConductivitySoilParticles,
					 meltingTemperature, par1, par2, par3, par4, par5, kappaSaturation, alphaSpecificStorage, betaSpecificStorage);
		}
		return uniqueInstance;
	}
	
	public static Parameters getInstance(double referenceTemperatureSWRC, double beta0, double[] thetaS, double[] thetaR, double[] par1, double[] par2, double[] par3, double[] par4, double[] par5, double[] kappaSaturation,
			double[] alphaSpecificStorage, double[] betaSpecificStorage) {
		if (uniqueInstance == null) {
			uniqueInstance = new Parameters(referenceTemperatureSWRC, beta0, thetaS, thetaR, par1, par2, par3, par4, par5, kappaSaturation, alphaSpecificStorage, betaSpecificStorage);
		}
		return uniqueInstance;
	}
	
	public static Parameters getInstance(double molecularDiffusion,double longitudinalDispersivity,double tortuosityFactor, double referenceTemperatureSWRC, double beta0,
			double[] thetaS, double[] thetaR, double[] par1, double[] par2, double[] par3, double[] par4, double[] par5, double[] kappaSaturation,
			double[] alphaSpecificStorage, double[] betaSpecificStorage) {
		if (uniqueInstance == null) {
			uniqueInstance = new Parameters(molecularDiffusion, longitudinalDispersivity, tortuosityFactor,referenceTemperatureSWRC, beta0,
					 thetaS, thetaR,par1, par2, par3, par4, par5, kappaSaturation, alphaSpecificStorage, betaSpecificStorage);
		}
		return uniqueInstance;
	}

	
	public double waterDensity;
	public double iceDensity;
	public double specificThermalCapacityIce;
	public double specificThermalCapacityWater;
	public double thermalConductivityWater;
	public double thermalConductivityIce;
	public double latentHeatFusion;
	public double referenceTemperatureInternalEnergy;
	public double referenceTemperatureSWRC;
	public double beta0;

	public double[] thetaS;
	public double[] thetaR;
	public double[] soilParticlesDensity;
	public double[] specificThermalCapacitySoilParticles;
	public double[] thermalConductivitySoilParticles;
	public double[] meltingTemperature;
	public double[] par1;
	public double[] par2;
	public double[] par3;
	public double[] par4;
	public double[] par5;
	public double[] kappaSaturation;
	public double[] alphaSpecificStorage;
	public double[] betaSpecificStorage;
	
	public double molecularDiffusion;
	public double longitudinalDispersivity;
	public double tortuosityFactor;
	
		
	private Parameters(double waterDensity, double iceDensity, double specificThermalCapacityWater,
			double specificThermalCapacityIce, double thermalConductivityWater, double thermalConductivityIce, double latentHeatFusion, double referenceTemperatureInternalEnergy, double referenceTemperatureSWRC, double beta0,
			double[] thetaS, double[] thetaR, double[] soilParticlesDensity, double[] specificThermalCapacitySoilParticles, double[] thermalConductivitySoilParticles,
			double[] meltingTemperature, double[] par1, double[] par2, double[] par3, double[] par4, double[] par5, double[] kappaSaturation,
			double[] alphaSpecificStorage, double[] betaSpecificStorage) {
		this.waterDensity = waterDensity;
		this.iceDensity = iceDensity;
		this.specificThermalCapacityIce = specificThermalCapacityIce;
		this.specificThermalCapacityWater = specificThermalCapacityWater;
		this.thermalConductivityWater = thermalConductivityWater;
		this.thermalConductivityIce = thermalConductivityIce;
		this.latentHeatFusion = latentHeatFusion;
		this.referenceTemperatureInternalEnergy = referenceTemperatureInternalEnergy;
		this.referenceTemperatureSWRC = referenceTemperatureSWRC;
		this.beta0 = beta0;
		this.thetaS = thetaS.clone();
		this.thetaR = thetaR.clone();
		this.soilParticlesDensity = soilParticlesDensity.clone();
		this.specificThermalCapacitySoilParticles = specificThermalCapacitySoilParticles.clone();
		this.thermalConductivitySoilParticles = thermalConductivitySoilParticles.clone();
		this.meltingTemperature = meltingTemperature.clone();
		this.par1 = par1.clone();
		this.par2 = par2.clone();
		this.par3 = par3.clone();
		this.par4 = par4.clone();
		this.par5 = par5.clone();
		this.kappaSaturation = kappaSaturation.clone();
		this.alphaSpecificStorage = alphaSpecificStorage.clone();
		this.betaSpecificStorage = betaSpecificStorage.clone();
		
		
	}

	
	private Parameters(double referenceTemperatureSWRC, double beta0, double[] thetaS, double[] thetaR, double[] par1, double[] par2, double[] par3, double[] par4, double[] par5, double[] kappaSaturation,
			double[] alphaSpecificStorage, double[] betaSpecificStorage) {
		this.waterDensity = -9999.0;
		this.iceDensity = -9999.0;
		this.specificThermalCapacityIce = -9999.0;
		this.specificThermalCapacityWater = -9999.0;
		this.thermalConductivityWater = -9999.0;
		this.thermalConductivityIce = -9999.0;
		this.latentHeatFusion = -9999.0;
		this.referenceTemperatureSWRC = referenceTemperatureSWRC;
		this.beta0 = beta0;
		this.thetaS = thetaS.clone();
		this.thetaR = thetaR.clone();
		this.soilParticlesDensity = null;
		this.specificThermalCapacitySoilParticles = null;
		this.thermalConductivitySoilParticles = null;
		this.meltingTemperature = null;
		this.par1 = par1.clone();
		this.par2 = par2.clone();
		this.par3 = par3.clone();
		this.par4 = par4.clone();
		this.par5 = par5.clone();
		this.kappaSaturation = kappaSaturation.clone();
		this.alphaSpecificStorage = alphaSpecificStorage.clone();
		this.betaSpecificStorage = betaSpecificStorage.clone();
		
		
	}
	
	private Parameters(double molecularDiffusion,double longitudinalDispersivity,double tortuosityFactor, double referenceTemperatureSWRC, double beta0,
			double[] thetaS, double[] thetaR, double[] par1, double[] par2, double[] par3, double[] par4, double[] par5, double[] kappaSaturation,
			double[] alphaSpecificStorage, double[] betaSpecificStorage) {
		
		this.molecularDiffusion = molecularDiffusion;
		this.longitudinalDispersivity = longitudinalDispersivity;
		this.tortuosityFactor = tortuosityFactor;
		this.referenceTemperatureSWRC = referenceTemperatureSWRC;
		this.beta0 = beta0;
		this.thetaS = thetaS.clone();
		this.thetaR = thetaR.clone();
		this.par1 = par1.clone();
		this.par2 = par2.clone();
		this.par3 = par3.clone();
		this.par4 = par4.clone();
		this.par5 = par5.clone();
		this.kappaSaturation = kappaSaturation.clone();
		this.alphaSpecificStorage = alphaSpecificStorage.clone();
		this.betaSpecificStorage = betaSpecificStorage.clone();
		
		
	}


}
