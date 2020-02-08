package ie.provector.jpbce;

import java.util.ArrayList;
import java.util.HashMap;

import ie.provector.jpbce.struct.HSL;
import ie.provector.jpbce.struct.RGB;
import ie.provector.jpbce.struct.Vector;

public class Challenge {
	
	//Basic	
	private String challengeFilename;	
	private String challengeDescriptionFilename;
	private String challengeTranslationPrefix;
	
	private String challengeName;
	private String colonyNameString;
	private String challengeDescriptionString;
	private String objectiveDescriptionString;
	private String objectiveDoneString;
	
	private int difficulty; //1-4
	private PlanetClass planetClass;
	
	private int latitude; //-180..180
	private int longtitude; //-180..180
	
	//Starting Specialization 0..
	private int startWorker; 
	private int startBiologist;
	private int startEngineer;
	private int startMedic;
	private int startGuard;
	private int startConstructor;
	private int startCarrier;
	private int startDriller;
	
	//Starting Resources 0..
	private int startMetal;
	private int startBioplastic;
	private int startMeal;
	private int startSpares;
	private int startMedicalSupplies;
	private int startCoins;
	private int startSemiconductors;
	private int startGun;
	private int startAlcoholicDrink;
	
	//Hazard Risks (None,Low,High)
	private NLHLevel sandstormRisk;
	private NLHLevel meteorRisk;
	private NLHLevel solareFlareRisk;
	private NLHLevel thunderstormRisk;
	private NLHLevel blizzardRisk;
	
	//Energy Sources
	private NLHLevel atmosphereDensity;
	private NLHLevel lightDensity;
	
	//Gameplay Modifiers
	private boolean disableColonistsShips;
	private boolean disableTraderTechs;
	private boolean disableVisitorRequirements;
	private boolean disableVisitorShips;
	private boolean disableTradingShips;
	private boolean disableShipRecycling;
	private boolean disableWorkerMining;
	private boolean disableNoMedicalSuppliesWarning;
	private boolean infiniteTraderBots;
	
	private float disasterFrequency; //0.1 .. 10.0
	private float shipFrequency;
	private float tradingShipFrequency;
	private int intruderMinPrestige; //1..1000
	private int extraIntruders; //0..
	
	private String[] disableInteriorStructures;
	private String[] disableExteriorStructures;
	private String[] disableComponents;
	private String[] disableStructureRequirement;
	private String[] restrictedColonistShips;
	private String[] restrictedTradingShips;
	private String[] unlockTech;
	
	//Environment Modifiers
	private int dayHours;
	private boolean dayHoursSet;
	
	private int nightHours;
	private boolean nightHoursSet;
	
	private boolean removeSatellites;
	
	private int environmentIndex;
	private boolean environmentIndexSet;
	
	private int sunIndex;
	private boolean sunIndexSet;
	
	private int backdropsIndex;
	private boolean backdropsIndexSet;
	
	private float fogIntensityDay;
	private boolean fogIntensityDaySet;
	
	private float fogIntensityNight;
	private boolean fogIntensityNightSet;
	
	private float fogIntensityTwilight;
	private boolean fogIntensityTwilightSet;
	
	private RGB lightColorDay;	
	private RGB lightColorNight;	
	private RGB lightColorTwilight;
	
	private RGB ambientColorDay;
	private RGB ambientColorNight;
	private RGB ambientColorTwilight;
	
	private RGB horizonColorDay;
	private RGB horizonColorNight;
	private RGB horizonColorTwilight;
	
	private RGB skyColorDay;
	private RGB skyColorNight;
	private RGB skyColorTwilight;
	
	//Terrain Modifiers
	private float heightMultiplier;
	private boolean heightMultiplierSet;
	private float craterDensity;
	private boolean craterDensitySet;
	private float distantHeightOffset;
	private boolean distantHeightOffsetSet;
	private float liquidAmount;
	private boolean liquidAmountSet;
	
	private Vector backdropScale;
	
	private float heightOffset;
	private boolean heightOffsetSet;
	private RGB liquidColor;
	private RGB tintTextureFlat1;
	private RGB tintTextureFlat2;
	private RGB tintTextureSlope;
	private RGB tintTextureFoundations;
	
	private RGB tintTextureDetailRocks;
	private RGB tintTextureCentralRocks;
	private RGB tintTextureSideRocks;
	
	private HSL hslTransformTextureFlat1;
	private HSL hslTransformTextureFlat2;
	private HSL hslTransformTextureSlope;
	private HSL hslTransformTextureFoundations;
	
	//Objectives
	
	private int reachPopulation;
	private int reachBots;
	private int reachPrestige;
	private int reachWelfare;
	private int survivalTime;
	private int timeLimit;
	
	private HashMap<String,Integer> accumulateResources;
	private ArrayList<String> keepCharacterAlive;
	private HashMap<String,Integer> buildComponents;
	private HashMap<String,Integer> reachSpecialization;
	private HashMap<String,Integer[]> buildStructures;
	
	
	
	public String getChallengeDescriptionString() {
		return challengeDescriptionString;
	}

	public void setChallengeDescriptionString(String challengeDescriptionString) {
		this.challengeDescriptionString = challengeDescriptionString;
	}

	public String getChallengeTranslationPrefix() {
		return challengeTranslationPrefix;
	}
	
	public void setChallengeTranslationPrefix(String challengeTranslationPrefix) {
		this.challengeTranslationPrefix = challengeTranslationPrefix;
	}
	
	public String getChallengeName() {
		return challengeName;
	}

	public void setChallengeName(String challengeName) {
		this.challengeName = challengeName;
	}

	public String getChallengeFilename() {
		return challengeFilename;
	}

	public void setChallengeFilename(String challengeFilename) {
		this.challengeFilename = challengeFilename;
	}

	public String getChallengeDescriptionFilename() {
		return challengeDescriptionFilename;
	}

	public void setChallengeDescriptionFilename(String challengeDescriptionFilename) {
		this.challengeDescriptionFilename = challengeDescriptionFilename;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public PlanetClass getPlanetClass() {
		return planetClass;
	}

	public void setPlanetClass(PlanetClass planetClass) {
		this.planetClass = planetClass;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(int longtitude) {
		this.longtitude = longtitude;
	}

	public int getStartWorker() {
		return startWorker;
	}

	public void setStartWorker(int startWorker) {
		this.startWorker = startWorker;
	}

	public int getStartBiologist() {
		return startBiologist;
	}

	public void setStartBiologist(int startBiologist) {
		this.startBiologist = startBiologist;
	}

	public int getStartEngineer() {
		return startEngineer;
	}

	public void setStartEngineer(int startEngineer) {
		this.startEngineer = startEngineer;
	}

	public int getStartMedic() {
		return startMedic;
	}
	
	public int getStartGuard() {
		return startGuard;
	}

	public void setStartMedic(int startMedic) {
		this.startMedic = startMedic;
	}
	
	public void setStartGuard(int startGuard) {
		this.startGuard = startGuard;
	}

	public int getStartConstructor() {
		return startConstructor;
	}

	public void setStartConstructor(int startConstructor) {
		this.startConstructor = startConstructor;
	}

	public int getStartCarrier() {
		return startCarrier;
	}

	public void setStartCarrier(int startCarrier) {
		this.startCarrier = startCarrier;
	}

	public int getStartDriller() {
		return startDriller;
	}

	public void setStartDriller(int startDriller) {
		this.startDriller = startDriller;
	}

	public boolean isDayHoursSet() {
		return dayHoursSet;
	}

	public void setDayHoursSet(boolean dayHoursSet) {
		this.dayHoursSet = dayHoursSet;
	}

	public boolean isNightHoursSet() {
		return nightHoursSet;
	}

	public void setNightHoursSet(boolean nightHoursSet) {
		this.nightHoursSet = nightHoursSet;
	}

	public boolean isHeightMultiplierSet() {
		return heightMultiplierSet;
	}

	public void setHeightMultiplierSet(boolean heightMultiplierSet) {
		this.heightMultiplierSet = heightMultiplierSet;
	}

	public boolean isCraterDensitySet() {
		return craterDensitySet;
	}

	public void setCraterDensitySet(boolean craterDensitySet) {
		this.craterDensitySet = craterDensitySet;
	}

	public boolean isDistantHeightOffsetSet() {
		return distantHeightOffsetSet;
	}

	public void setDistantHeightOffsetSet(boolean distantHeightOffsetSet) {
		this.distantHeightOffsetSet = distantHeightOffsetSet;
	}

	public boolean isLiquidAmountSet() {
		return liquidAmountSet;
	}

	public void setLiquidAmountSet(boolean liquidAmountSet) {
		this.liquidAmountSet = liquidAmountSet;
	}

	public boolean isEnvironmentIndexSet() {
		return environmentIndexSet;
	}

	public void setEnvironmentIndexSet(boolean environmentIndexSet) {
		this.environmentIndexSet = environmentIndexSet;
	}

	public boolean isSunIndexSet() {
		return sunIndexSet;
	}

	public void setSunIndexSet(boolean sunIndexSet) {
		this.sunIndexSet = sunIndexSet;
	}

	public boolean isBackdropsIndexSet() {
		return backdropsIndexSet;
	}

	public void setBackdropsIndexSet(boolean backropsIndex) {
		this.backdropsIndexSet = backropsIndex;
	}

	public boolean isFogIntensityDaySet() {
		return fogIntensityDaySet;
	}

	public void setFogIntensityDaySet(boolean fogIntensityDaySet) {
		this.fogIntensityDaySet = fogIntensityDaySet;
	}

	public String getColonyNameString() {
		return colonyNameString;
	}

	public void setColonyNameString(String colonyNameString) {
		this.colonyNameString = colonyNameString;
	}

	public String getObjectiveDescriptionString() {
		return objectiveDescriptionString;
	}

	public void setObjectiveDescriptionString(String objectiveDescriptionString) {
		this.objectiveDescriptionString = objectiveDescriptionString;
	}

	public String getObjectiveDoneString() {
		return objectiveDoneString;
	}

	public void setObjectiveDoneString(String objectiveDoneString) {
		this.objectiveDoneString = objectiveDoneString;
	}

	public boolean isFogIntensityNightSet() {
		return fogIntensityNightSet;
	}

	public void setFogIntensityNightSet(boolean fogIntensityNightSet) {
		this.fogIntensityNightSet = fogIntensityNightSet;
	}

	public boolean isFogIntensityTwilightSet() {
		return fogIntensityTwilightSet;
	}

	public void setFogIntensityTwilightSet(boolean fogIntensityTwilightSet) {
		this.fogIntensityTwilightSet = fogIntensityTwilightSet;
	}

	public int getStartMetal() {
		return startMetal;
	}

	public void setStartMetal(int startMetal) {
		this.startMetal = startMetal;
	}

	public int getStartBioplastic() {
		return startBioplastic;
	}

	public void setStartBioplastic(int startBioplastic) {
		this.startBioplastic = startBioplastic;
	}

	public int getStartMeal() {
		return startMeal;
	}

	public void setStartMeal(int startMeal) {
		this.startMeal = startMeal;
	}

	public int getStartSpares() {
		return startSpares;
	}

	public void setStartSpares(int startSpares) {
		this.startSpares = startSpares;
	}

	public int getStartMedicalSupplies() {
		return startMedicalSupplies;
	}

	public void setStartMedicalSupplies(int startMedicalSupplies) {
		this.startMedicalSupplies = startMedicalSupplies;
	}

	public int getStartCoins() {
		return startCoins;
	}

	public void setStartCoins(int startCoins) {
		this.startCoins = startCoins;
	}

	public int getStartSemiconductors() {
		return startSemiconductors;
	}

	public void setStartSemiconductors(int startSemiconductors) {
		this.startSemiconductors = startSemiconductors;
	}

	public int getStartGun() {
		return startGun;
	}

	public void setStartGun(int startGun) {
		this.startGun = startGun;
	}

	public int getStartAlcoholicDrink() {
		return startAlcoholicDrink;
	}

	public void setStartAlcoholicDrink(int startAlcoholicDrink) {
		this.startAlcoholicDrink = startAlcoholicDrink;
	}

	public NLHLevel getSandstormRisk() {
		return sandstormRisk;
	}

	public void setSandstormRisk(NLHLevel sandstormRisk) {
		this.sandstormRisk = sandstormRisk;
	}

	public NLHLevel getMeteorRisk() {
		return meteorRisk;
	}

	public void setMeteorRisk(NLHLevel meteorRisk) {
		this.meteorRisk = meteorRisk;
	}

	public NLHLevel getSolareFlareRisk() {
		return solareFlareRisk;
	}

	public void setSolareFlareRisk(NLHLevel solareFlareRisk) {
		this.solareFlareRisk = solareFlareRisk;
	}

	public NLHLevel getThunderstormRisk() {
		return thunderstormRisk;
	}

	public void setThunderstormRisk(NLHLevel thunderstormRisk) {
		this.thunderstormRisk = thunderstormRisk;
	}

	public NLHLevel getBlizzardRisk() {
		return blizzardRisk;
	}

	public void setBlizzardRisk(NLHLevel blizzardRisk) {
		this.blizzardRisk = blizzardRisk;
	}

	public NLHLevel getAtmosphereDensity() {
		return atmosphereDensity;
	}

	public void setAtmosphereDensity(NLHLevel atmosphereDensity) {
		this.atmosphereDensity = atmosphereDensity;
	}

	public NLHLevel getLightDensity() {
		return lightDensity;
	}

	public void setLightDensity(NLHLevel lightDensity) {
		this.lightDensity = lightDensity;
	}

	public boolean isDisableColonistsShips() {
		return disableColonistsShips;
	}

	public void setDisableColonistsShips(boolean disableColonistsShips) {
		this.disableColonistsShips = disableColonistsShips;
	}

	public boolean isDisableTraderTechs() {
		return disableTraderTechs;
	}

	public void setDisableTraderTechs(boolean disableTraderTechs) {
		this.disableTraderTechs = disableTraderTechs;
	}

	public boolean isDisableVisitorRequirements() {
		return disableVisitorRequirements;
	}

	public void setDisableVisitorRequirements(boolean disableVisitorRequirements) {
		this.disableVisitorRequirements = disableVisitorRequirements;
	}

	public boolean isDisableVisitorShips() {
		return disableVisitorShips;
	}

	public void setDisableVisitorShips(boolean disableVisitorShips) {
		this.disableVisitorShips = disableVisitorShips;
	}

	public boolean isDisableTradingShips() {
		return disableTradingShips;
	}

	public void setDisableTradingShips(boolean disableTradingShips) {
		this.disableTradingShips = disableTradingShips;
	}

	public boolean isDisableShipRecycling() {
		return disableShipRecycling;
	}

	public void setDisableShipRecycling(boolean disableShipRecycling) {
		this.disableShipRecycling = disableShipRecycling;
	}

	public boolean isDisableWorkerMining() {
		return disableWorkerMining;
	}

	public void setDisableWorkerMining(boolean disableWorkerMining) {
		this.disableWorkerMining = disableWorkerMining;
	}

	public boolean isDisableNoMedicalSuppliesWarning() {
		return disableNoMedicalSuppliesWarning;
	}

	public void setDisableNoMedicalSuppliesWarning(boolean disableNoMedicalSuppliesWarning) {
		this.disableNoMedicalSuppliesWarning = disableNoMedicalSuppliesWarning;
	}

	public boolean isInfiniteTraderBots() {
		return infiniteTraderBots;
	}

	public void setInfiniteTraderBots(boolean infiniteTraderBots) {
		this.infiniteTraderBots = infiniteTraderBots;
	}

	public float getDisasterFrequency() {
		return disasterFrequency;
	}

	public void setDisasterFrequency(float disasterFrequency) {
		this.disasterFrequency = disasterFrequency;
	}

	public float getShipFrequency() {
		return shipFrequency;
	}

	public void setShipFrequency(float shipFrequency) {
		this.shipFrequency = shipFrequency;
	}

	public float getTradingShipFrequency() {
		return tradingShipFrequency;
	}

	public void setTradingShipFrequency(float tradingShipFrequency) {
		this.tradingShipFrequency = tradingShipFrequency;
	}

	public int getIntruderMinPrestige() {
		return intruderMinPrestige;
	}

	public void setIntruderMinPrestige(int intruderMinPrestige) {
		this.intruderMinPrestige = intruderMinPrestige;
	}

	public int getExtraIntruders() {
		return extraIntruders;
	}

	public void setExtraIntruders(int extraIntruders) {
		this.extraIntruders = extraIntruders;
	}

	public String[] getDisableInteriorStructures() {
		return disableInteriorStructures;
	}

	public void setDisableInteriorStructures(String[] disableInteriorStructures) {
		this.disableInteriorStructures = disableInteriorStructures;
	}

	public String[] getDisableExteriorStructures() {
		return disableExteriorStructures;
	}

	public void setDisableExteriorStructures(String[] disableExteriorStructures) {
		this.disableExteriorStructures = disableExteriorStructures;
	}

	public String[] getDisableComponents() {
		return disableComponents;
	}

	public void setDisableComponents(String[] disableComponents) {
		this.disableComponents = disableComponents;
	}

	public String[] getDisableStructureRequirement() {
		return disableStructureRequirement;
	}

	public void setDisableStructureRequirement(String[] disableStructureRequirement) {
		this.disableStructureRequirement = disableStructureRequirement;
	}

	public String[] getRestrictedColonistShips() {
		return restrictedColonistShips;
	}

	public void setRestrictedColonistShips(String[] restrictedColonistShips) {
		this.restrictedColonistShips = restrictedColonistShips;
	}

	public String[] getRestrictedTradingShips() {
		return restrictedTradingShips;
	}

	public void setRestrictedTradingShips(String[] restrictedTradingShips) {
		this.restrictedTradingShips = restrictedTradingShips;
	}

	public String[] getUnlockTech() {
		return unlockTech;
	}

	public void setUnlockTech(String[] unlockTech) {
		this.unlockTech = unlockTech;
	}

	public int getDayHours() {
		return dayHours;
	}

	public void setDayHours(int dayHours) {
		this.dayHours = dayHours;
	}

	public int getNightHours() {
		return nightHours;
	}

	public void setNightHours(int nightHours) {
		this.nightHours = nightHours;
	}

	public boolean isRemoveSatellites() {
		return removeSatellites;
	}

	public void setRemoveSatellites(boolean removeSatellites) {
		this.removeSatellites = removeSatellites;
	}

	public int getEnvironmentIndex() {
		return environmentIndex;
	}

	public void setEnvironmentIndex(int environmentIndex) {
		this.environmentIndex = environmentIndex;
	}

	public int getSunIndex() {
		return sunIndex;
	}

	public void setSunIndex(int sunIndex) {
		this.sunIndex = sunIndex;
	}

	public int getBackdropsIndex() {
		return backdropsIndex;
	}

	public void setBackdropsIndex(int backdropsIndex) {
		this.backdropsIndex = backdropsIndex;
	}

	public float getFogIntensityDay() {
		return fogIntensityDay;
	}

	public RGB getTintTextureFlat2() {
		return tintTextureFlat2;
	}

	public void setTintTextureFlat2(RGB tintTextureFlat2) {
		this.tintTextureFlat2 = tintTextureFlat2;
	}

	public RGB getTintTextureSlope() {
		return tintTextureSlope;
	}

	public void setTintTextureSlope(RGB tintTextureSlope) {
		this.tintTextureSlope = tintTextureSlope;
	}

	public RGB getTintTextureFoundations() {
		return tintTextureFoundations;
	}

	public void setTintTextureFoundations(RGB tintTextureFoundations) {
		this.tintTextureFoundations = tintTextureFoundations;
	}

	public RGB getTintTextureDetailRocks() {
		return tintTextureDetailRocks;
	}

	public void setTintTextureDetailRocks(RGB tintTextureDetailRocks) {
		this.tintTextureDetailRocks = tintTextureDetailRocks;
	}

	public RGB getTintTextureCentralRocks() {
		return tintTextureCentralRocks;
	}

	public void setTintTextureCentralRocks(RGB tintTextureCentralRocks) {
		this.tintTextureCentralRocks = tintTextureCentralRocks;
	}

	public RGB getTintTextureSideRocks() {
		return tintTextureSideRocks;
	}

	public void setTintTextureSideRocks(RGB tintTextureSideRocks) {
		this.tintTextureSideRocks = tintTextureSideRocks;
	}

	public HSL getHslTransformTextureFlat2() {
		return hslTransformTextureFlat2;
	}

	public void setHslTransformTextureFlat2(HSL hslTransformTextureFlat2) {
		this.hslTransformTextureFlat2 = hslTransformTextureFlat2;
	}

	public HSL getHslTransformTextureSlope() {
		return hslTransformTextureSlope;
	}

	public void setHslTransformTextureSlope(HSL hslTransformTextureSlope) {
		this.hslTransformTextureSlope = hslTransformTextureSlope;
	}

	public HSL getHslTransformTextureFoundations() {
		return hslTransformTextureFoundations;
	}

	public void setHslTransformTextureFoundations(HSL hslTransformTextureFoundations) {
		this.hslTransformTextureFoundations = hslTransformTextureFoundations;
	}

	public void setFogIntensityDay(float fogIntensityDay) {
		this.fogIntensityDay = fogIntensityDay;
	}

	public float getFogIntensityNight() {
		return fogIntensityNight;
	}

	public void setFogIntensityNight(float fogIntensityNight) {
		this.fogIntensityNight = fogIntensityNight;
	}

	public float getFogIntensityTwilight() {
		return fogIntensityTwilight;
	}

	public void setFogIntensityTwilight(float fogIntensityTwilight) {
		this.fogIntensityTwilight = fogIntensityTwilight;
	}

	public RGB getLightColorDay() {
		return lightColorDay;
	}

	public void setLightColorDay(RGB lightColorDay) {
		this.lightColorDay = lightColorDay;
	}

	public RGB getLightColorNight() {
		return lightColorNight;
	}

	public void setLightColorNight(RGB lightColorNight) {
		this.lightColorNight = lightColorNight;
	}

	public RGB getLightColorTwilight() {
		return lightColorTwilight;
	}

	public void setLightColorTwilight(RGB lightColorTwilight) {
		this.lightColorTwilight = lightColorTwilight;
	}

	public RGB getAmbientColorDay() {
		return ambientColorDay;
	}

	public void setAmbientColorDay(RGB ambientColorDay) {
		this.ambientColorDay = ambientColorDay;
	}

	public RGB getAmbientColorNight() {
		return ambientColorNight;
	}

	public void setAmbientColorNight(RGB ambientColorNight) {
		this.ambientColorNight = ambientColorNight;
	}

	public boolean isHeightOffsetSet() {
		return heightOffsetSet;
	}

	public void setHeightOffsetSet(boolean heightOffsetSet) {
		this.heightOffsetSet = heightOffsetSet;
	}

	public RGB getAmbientColorTwilight() {
		return ambientColorTwilight;
	}

	public void setAmbientColorTwilight(RGB ambientColorTwilight) {
		this.ambientColorTwilight = ambientColorTwilight;
	}

	public RGB getHorizonColorDay() {
		return horizonColorDay;
	}

	public void setHorizonColorDay(RGB horizonColorDay) {
		this.horizonColorDay = horizonColorDay;
	}

	public RGB getHorizonColorNight() {
		return horizonColorNight;
	}

	public void setHorizonColorNight(RGB horizonColorNight) {
		this.horizonColorNight = horizonColorNight;
	}

	public RGB getHorizonColorTwilight() {
		return horizonColorTwilight;
	}

	public void setHorizonColorTwilight(RGB horizonColorTwilight) {
		this.horizonColorTwilight = horizonColorTwilight;
	}

	public RGB getSkyColorDay() {
		return skyColorDay;
	}

	public void setSkyColorDay(RGB skyColorDay) {
		this.skyColorDay = skyColorDay;
	}

	public RGB getSkyColorNight() {
		return skyColorNight;
	}

	public void setSkyColorNight(RGB skyColorNight) {
		this.skyColorNight = skyColorNight;
	}

	public RGB getSkyColorTwilight() {
		return skyColorTwilight;
	}

	public void setSkyColorTwilight(RGB skyColorTwilight) {
		this.skyColorTwilight = skyColorTwilight;
	}

	public float getHeightMultiplier() {
		return heightMultiplier;
	}

	public void setHeightMultiplier(float heightMultiplier) {
		this.heightMultiplier = heightMultiplier;
	}

	public float getCraterDensity() {
		return craterDensity;
	}

	public void setCraterDensity(float craterDensity) {
		this.craterDensity = craterDensity;
	}

	public float getDistantHeightOffset() {
		return distantHeightOffset;
	}

	public void setDistantHeightOffset(float distantHeightOffset) {
		this.distantHeightOffset = distantHeightOffset;
	}

	public float getLiquidAmount() {
		return liquidAmount;
	}

	public void setLiquidAmount(float liquidAmount) {
		this.liquidAmount = liquidAmount;
	}

	public Vector getBackdropScale() {
		return backdropScale;
	}

	public void setBackdropScale(Vector backdropScale) {
		this.backdropScale = backdropScale;
	}

	public float getHeightOffset() {
		return heightOffset;
	}

	public void setHeightOffset(float heightOffset) {
		this.heightOffset = heightOffset;
	}

	public RGB getLiquidColor() {
		return liquidColor;
	}

	public void setLiquidColor(RGB liquidColor) {
		this.liquidColor = liquidColor;
	}

	public RGB getTintTextureFlat1() {
		return tintTextureFlat1;
	}

	public void setTintTextureFlat1(RGB tintTexture) {
		this.tintTextureFlat1 = tintTexture;
	}

	public HSL getHslTransformTextureFlat1() {
		return hslTransformTextureFlat1;
	}

	public void setHslTransformTextureFlat1(HSL hslTransformTexture) {
		this.hslTransformTextureFlat1 = hslTransformTexture;
	}

	public int getReachPopulation() {
		return reachPopulation;
	}

	public void setReachPopulation(int reachPopulation) {
		this.reachPopulation = reachPopulation;
	}

	public int getReachBots() {
		return reachBots;
	}

	public void setReachBots(int reachBots) {
		this.reachBots = reachBots;
	}

	public int getReachPrestige() {
		return reachPrestige;
	}

	public void setReachPrestige(int reachPrestige) {
		this.reachPrestige = reachPrestige;
	}

	public int getReachWelfare() {
		return reachWelfare;
	}

	public void setReachWelfare(int reachWelfare) {
		this.reachWelfare = reachWelfare;
	}

	public int getSurvivalTime() {
		return survivalTime;
	}

	public void setSurvivalTime(int survivalTime) {
		this.survivalTime = survivalTime;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public HashMap<String, Integer> getAccumulateResources() {
		return accumulateResources;
	}

	public void setAccumulateResources(HashMap<String, Integer> accumulateResources) {
		this.accumulateResources = accumulateResources;
	}

	public ArrayList<String> getKeepCharacterAlive() {
		return keepCharacterAlive;
	}

	public void setKeepCharacterAlive(ArrayList<String> keepCharacterAlive) {
		this.keepCharacterAlive = keepCharacterAlive;
	}

	public HashMap<String, Integer> getBuildComponents() {
		return buildComponents;
	}

	public void setBuildComponents(HashMap<String, Integer> buildComponents) {
		this.buildComponents = buildComponents;
	}

	public HashMap<String, Integer> getReachSpecialization() {
		return reachSpecialization;
	}

	public void setReachSpecialization(HashMap<String, Integer> reachSpecialization) {
		this.reachSpecialization = reachSpecialization;
	}

	public HashMap<String, Integer[]> getBuildStructures() {
		return buildStructures;
	}

	public void setBuildStructures(HashMap<String, Integer[]> buildStructures) {
		this.buildStructures = buildStructures;
	}

	public static enum InteriorStructure {
		Airlock,
		Bar,
		BioDome,
		Cabin,
		Canteen,
		ControlCenter,
		Dorm,
		Factory,
		Lab,
		MultiDome,
		OxygenGenerator,
		ProcessingPlant,
		RoboticsFacility,
		SickBay,
		Storage
	}
	
	public static enum ExteriorStructure {
		AntiMeteorLaser,
		BasePad,
		//Connection,
		LandingPad,
		Mine,
		Monolith,
		PowerCollector,
		Pyramid,
		RadioAntenna,
		Signpost,
		SolarPanel,
		Starport,
		Telescope,
		WaterExtractor,
		WaterTank,
		WindTurbine
	}
	
	public static enum Component {
		Armory,
		ArmsWorkshop,
		BarTable,
		BarTableNoChairs,
		Bed,
		Bench,
		BioplasticProcessor,
		BotAutoRepair,
		BotWorkshop,
		Bunk,
		DecorativePlant,
		DrinkingFountain,
		DrinksMachine,
		ExerciseBar,
		GmOnionPad,
		GmTomatoPad,
		LettucePad,
		MaizePad,
		MealMaker,
		MedicalCabinet,
		MedicinalPad,
		MetalProcessor,
		MushroomPad,
		OakTree,
		OnionPad,
		PeaPad,
		PineTree,
		PotatoPad,
		RadioConsole,
		RadishPad,
		RicePad,
		SecurityConsole,
		SemiconductorFoundry,
		SickBayBed,
		SparesWorkshop,
		Table,
		TableSmall,
		TelescopeConsole,
		TissueSynthesizer,
		TomatoPad,
		Treadmill,
		VideoScreen,
		WheatPad,
		Workbench			   
	}
	
	public static enum Structure {		
		Airlock,
		AntiMeteorLaser,
		Bar,
		BasePad,
		BioDome,
		Cabin,
		Canteen,
		//Connection,
		ControlCenter,
		Dorm,
		Factory,
		Lab,
		LandingPad,
		Mine,
		Monolith,
		MultiDome,
		OxygenGenerator,
		PowerCollector,
		ProcessingPlant,
		Pyramid,
		RadioAntenna,
		RoboticsFacility,
		SickBay,
		Signpost,
		SolarPanel,
		Starport,
		Storage,
		Telescope,
		WaterExtractor,
		WaterTank,
		WindTurbine
	}
	
	public static enum Colonist {
		Biologist,
	    Engineer,
	    Guard,
	    Medic,
	    Worker
	}
	
	public static enum Specialization {
		Biologist,
		Carrier,
		Constructor,
		Driller,
	    Engineer,
	    Guard,
	    Medic,
	    Worker
	}
	
	public static enum Trader {
		Electronics,
		Food,
		Industrial,
		Medical,
		RawMaterial
	}
	
	public static enum Tech {
		ColossalPanel,
		ConstructorBot,
		DrillerBot,
		FarmDome,
		GmOnions,
		GmTomatoes,
		GoliathTurbine,
		MassiveStorage,
		MegaCollector,
		SuperExtractor
	}
	
	public static enum Resource {
		 AlcoholicDrink,
		 Bioplastic,
		 Gun,
		 Meal,
		 MedicalSupplies,
		 MedicinalPlants,
		 Metal,
		 Ore,
		 Semiconductors,
		 Starch,
		 Spares,
		 Vegetables,
		 Vitromeat,
	}
	
	public static enum PlanetClass {
		D,F,M,S
	}
	
	public static enum NLHLevel {
		None,Low,High
	}

	
	
	
	
	
	
	
	

}

