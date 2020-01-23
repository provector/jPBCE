package ie.provector.jpbce;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import ie.provector.jpbce.struct.HSL;
import ie.provector.jpbce.struct.RGB;
import ie.provector.jpbce.struct.Vector;

public class ScenarioWriter {

	private ArrayList<String> starting_specializations;
	private ArrayList<String> starting_resources;
	private ArrayList<String> gameplay_modifiers;
	private ArrayList<String> environment_modifiers;
	private ArrayList<String> terrain_modifiers;
	private ArrayList<String> objectives;
	
	Challenge CC;
	
	StringBuilder xml;
	
	private static final String GROUP_ID = "jpbce_test";
	
	public ScenarioWriter(Challenge challengeConfig) {
		this.CC = challengeConfig;
		xml = new StringBuilder();
	}
	
	public String createChallenge(String path) {
		//XML header
		xml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n");
		//Root header
		xml.append("<!-- Generated with Planetbase Challenge Editor by _provector'19 ["+PBCE._VERSION_STRING+"]-->\r\n");
		xml.append("<challenge group_id=\""+GROUP_ID+"\" order=\"1\" difficulty=\""+CC.getDifficulty()+"\">\r\n");
		//Starting location
		xml.append("<starting_location planet_class=\""+CC.getPlanetClass()+"\" latitude=\""+CC.getLatitude()+"\" longitude=\""+CC.getLongtitude()+"\" savegame=\"false\"/>\r\n");
		//Starting Specializations
		starting_specializations = processStartingSpecializations();
		if(starting_specializations.size()>0) {
			xml.append("<starting_specializations>\r\n");
			for(String entry : starting_specializations) {
				xml.append(entry);
			}
			xml.append("</starting_specializations>\r\n");
		}
		//Starting resources
		starting_resources = processStartingResources();
		if(starting_resources.size()>0) {
			xml.append("<starting_resources>\r\n");
			for(String entry : starting_resources) {
				xml.append(entry);
			}
			xml.append("</starting_resources>\r\n");
		}
		//Gameplay modifiers
		gameplay_modifiers = processGameplayModifiers();
		if(gameplay_modifiers.size()>0) {
			xml.append("<gameplay_modifiers>\r\n");
			for(String entry : gameplay_modifiers) {
				xml.append(entry);
			}
			xml.append("</gameplay_modifiers>\r\n");
		}
		
		//Environment modifiers
		environment_modifiers = processEnvironmentModifiers();
		if(environment_modifiers.size()>0) {
			xml.append("<environment_modifiers>\r\n");
			for(String entry : environment_modifiers) {
				xml.append(entry);
			}			
			xml.append("</environment_modifiers>\r\n");
		}
		
		//Terrain modifiers
		terrain_modifiers = processTerrainModifiers();
		if(terrain_modifiers.size()>0) {
			xml.append("<terrain_modifiers>\r\n");
			for(String entry : terrain_modifiers) {
				xml.append(entry);
			}
			xml.append("</terrain_modifiers>\r\n");
		}
		//Objectives
		objectives = processObjectives();
		if(objectives.size()>0) {
			xml.append("<objectives>\r\n");
			for(String entry : objectives) {
				xml.append(entry);
			}			
			xml.append("</objectives>\r\n");
		}
		
		xml.append("</challenge>");
			
			try {
				//write scenario 
				OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(new File(path+CC.getChallengeFilename().toLowerCase())), StandardCharsets.UTF_8);
				fw.write(xml.toString());
				fw.flush();
				fw.close();
				//and desc file
				String textFile = generateTextFile();
				fw = new OutputStreamWriter(new FileOutputStream(new File(path+CC.getChallengeDescriptionFilename().toLowerCase())),StandardCharsets.UTF_8);
				fw.write(textFile);
				fw.flush();
				fw.close();
				return "OK";
			}catch(IOException e) {
				return "ERROR: I/O "+e.getMessage();
			}				
		
	}
	
	
	private String generateTextFile() {
		String challengeName = CC.getChallengeName().replaceAll(" ","_").toLowerCase();
		StringBuilder en = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n");
		en.append("<strings>\r");
		en.append("<string name=\""+GROUP_ID+"\">jPBCE Beta</string>\r\n");
		en.append("\t<string name=\""+challengeName+"_name\">"+CC.getChallengeName()+"</string>\r\n");
		en.append("\t<string name=\""+challengeName+"_base_name\">"+CC.getColonyNameString()+"</string>\r\n");
		en.append("\t<string name=\""+challengeName+"_description\">"+CC.getChallengeDescriptionString()+"</string>\r\n");
		en.append("\t<string name=\""+challengeName+"_objective\">"+CC.getObjectiveDescriptionString()+"</string>\r\n");
		en.append("\t<string name=\""+challengeName+"_done\">"+CC.getObjectiveDoneString()+"</string>\r\n");
		en.append("</strings>\r");
		return en.toString();
	}
	
	private ArrayList<String> processObjectives() {
		ArrayList<String> ol = new ArrayList<>();
		//Build structures table
		if(CC.getBuildStructures()!=null) {
			HashMap<String,Integer[]> smap = CC.getBuildStructures();
			smap.forEach((structure,values)->{
				structure = structure.replaceAll(" ","").replace("-","");
				String size = ""+values[0];
				String number = ""+values[1];
				ol.add("\t<objective type=\"BuildStructures\" param=\""+structure+"\" value=\""+number+"\" size=\""+size+"\"/>\r\n");
			});
		}
		//Resource table
		if(CC.getAccumulateResources()!=null) {
			HashMap<String,Integer> armap = CC.getAccumulateResources();
			armap.forEach((resource,amount)->{
				resource = resource.replaceAll(" ","").replaceAll("-","");
				ol.add("\t<objective type=\"AccumulateResources\" param=\""+resource+"\" value=\""+amount+"\"/>\r\n");
			});
		}
		//Components table
		if(CC.getBuildComponents()!=null) {
			HashMap<String,Integer> cmap = CC.getBuildComponents();
			cmap.forEach((component,amount)->{
				component = component.replaceAll(" ","").replaceAll("-","");
				ol.add("\t<objective type=\"BuildComponents\" param=\""+component+"\" value=\""+amount+"\"/>\r\n");
			});
		}
		//Specialization table
		if(CC.getReachSpecialization()!=null) {
			HashMap<String,Integer> spmap = CC.getReachSpecialization();
			spmap.forEach((specialization,number)->{
				specialization = specialization.replaceAll(" ","").replaceAll("-","");
				ol.add("\t<objective type=\"ReachSpecialization\" param=\""+specialization+"\" value=\""+number+"\"/>\r\n");
			});
		}
		//Characters table
		if(CC.getKeepCharacterAlive()!=null) {
			ArrayList<String> clist = CC.getKeepCharacterAlive();
			clist.forEach(characterName->{
				ol.add("\t<objective type=\"KeepCharacterAlive\" param=\""+characterName+"\"/>\r\n");
			});
		}
		
		if(CC.getReachPopulation()>0) {
			ol.add("\t<objective type=\"ReachPopulation\" value=\""+CC.getReachPopulation()+"\"/>\r\n");
		}
		if(CC.getReachBots()>0) {
			ol.add("\t<objective type=\"ReachBots\" value=\""+CC.getReachBots()+"\"/>\r\n");
		}
		if(CC.getReachPrestige()>0) {
			ol.add("\t<objective type=\"ReachPrestige\" value=\""+CC.getReachPrestige()+"\"/>\r\n");
		}
		if(CC.getReachWelfare()>0) {
			ol.add("\t<objective type=\"ReachWelfare\" value=\""+CC.getReachWelfare()+"\"/>\r\n");
		}
		if(CC.getSurvivalTime()>0) {
			ol.add("\t<objective type=\"SurviveTime\" value=\""+CC.getSurvivalTime()+"\"/>\r\n");
		}
		if(CC.getTimeLimit()>0) {
			ol.add("\t<objective type=\"TimeLimit\" value=\""+CC.getTimeLimit()+"\"/>\r\n");
		}		
		return ol;
	}
	
	private ArrayList<String> processTerrainModifiers() {
		ArrayList<String> tml = new ArrayList<>();
		if(CC.isHeightMultiplierSet()) {
			tml.add("\t<terrain_modifier type=\"HeightMultiplier\" value=\""+CC.getHeightMultiplier()+"\"/>\r\n");
		}
		if(CC.isCraterDensitySet()) {
			tml.add("\t<terrain_modifier type=\"CraterDensity\" value=\""+CC.getCraterDensity()+"\"/>\r\n");
		}
		if(CC.isDistantHeightOffsetSet()) {
			tml.add("\t<terrain_modifier type=\"DistantHeightOffset\" value=\""+CC.getDistantHeightOffset()+"\"/>\r\n");
		}
		if(CC.isLiquidAmountSet()) {
			tml.add("\t<terrain_modifier type=\"LiquidAmount\" value=\""+CC.getLiquidAmount()+"\"/>\r\n");
		}
		
		if(CC.getBackdropScale()!=null) {
			Vector v = CC.getBackdropScale();
			String values = v.x+","+v.y+","+v.z;
			tml.add("\t<terrain_modifier type=\"BackdropScale\" value=\""+values+"\"/>\r\n");
		}
		
		if(CC.isHeightOffsetSet()) {
			tml.add("\t<terrain_modifier type=\"HeightOffset\" value=\""+CC.getHeightOffset()+"\"/>\r\n");
		}
		if(CC.getLiquidColor()!=null) {
			RGB color = CC.getLiquidColor();
			String values = color.r+","+color.g+","+color.b;
			tml.add("\t<terrain_modifier type=\"LiquidColor\" value=\""+values+"\"/>\r\n");
		}
		if(CC.getTintTextureFlat1()!=null) {
			RGB color = CC.getTintTextureFlat1();
			String values = color.r+","+color.g+","+color.b;
			tml.add("\t<terrain_modifier type=\"TintTexture\" param=\"Flat1\" value=\""+values+"\"/>\r\n");
		}
		if(CC.getTintTextureFlat2()!=null) {
			RGB color = CC.getTintTextureFlat2();
			String values = color.r+","+color.g+","+color.b;
			tml.add("\t<terrain_modifier type=\"TintTexture\" param=\"Flat2\" value=\""+values+"\"/>\r\n");
		}
		if(CC.getTintTextureSlope()!=null) {
			RGB color = CC.getTintTextureSlope();
			String values = color.r+","+color.g+","+color.b;
			tml.add("\t<terrain_modifier type=\"TintTexture\" param=\"Slope\" value=\""+values+"\"/>\r\n");
		}
		if(CC.getTintTextureFoundations()!=null) {
			RGB color = CC.getTintTextureFoundations();
			String values = color.r+","+color.g+","+color.b;
			tml.add("\t<terrain_modifier type=\"TintTexture\" param=\"Foundations\" value=\""+values+"\"/>\r\n");
		}
		if(CC.getTintTextureDetailRocks()!=null) {
			RGB color = CC.getTintTextureDetailRocks();
			String values = color.r+","+color.g+","+color.b;
			tml.add("\t<terrain_modifier type=\"TintTexture\" param=\"DetailRocks\" value=\""+values+"\"/>\r\n");
		}
		if(CC.getTintTextureCentralRocks()!=null) {
			RGB color = CC.getTintTextureCentralRocks();
			String values = color.r+","+color.g+","+color.b;
			tml.add("\t<terrain_modifier type=\"TintTexture\" param=\"CentralRocks\" value=\""+values+"\"/>\r\n");
		}
		if(CC.getTintTextureSideRocks()!=null) {
			RGB color = CC.getTintTextureSideRocks();
			String values = color.r+","+color.g+","+color.b;
			tml.add("\t<terrain_modifier type=\"TintTexture\" param=\"SideRocks\" value=\""+values+"\"/>\r\n");
		}
		
		
		if(CC.getHslTransformTextureFlat1()!=null) {
			HSL color = CC.getHslTransformTextureFlat1();
			String values = (int) color.hue+","+(int) color.saturation+","+(int) color.luminence; //Not sure if game will accept float
			tml.add("\t<terrain_modifier type=\"HslTransformTexture\" param=\"Flat1\" value=\""+values+"\"/>\r\n");
		}
		if(CC.getHslTransformTextureFlat2()!=null) {
			HSL color = CC.getHslTransformTextureFlat2();
			String values = (int) color.hue+","+(int) color.saturation+","+(int) color.luminence; //Not sure if game will accept float
			tml.add("\t<terrain_modifier type=\"HslTransformTexture\" param=\"Flat2\" value=\""+values+"\"/>\r\n");
		}	
		if(CC.getHslTransformTextureSlope()!=null) {
			HSL color = CC.getHslTransformTextureSlope();
			String values = (int) color.hue+","+(int) color.saturation+","+(int) color.luminence; //Not sure if game will accept float
			tml.add("\t<terrain_modifier type=\"HslTransformTexture\" param=\"Slope\" value=\""+values+"\"/>\r\n");
		}	
		if(CC.getHslTransformTextureFoundations()!=null) {
			HSL color = CC.getHslTransformTextureFoundations();
			String values = (int) color.hue+","+(int) color.saturation+","+(int) color.luminence; //Not sure if game will accept float
			tml.add("\t<terrain_modifier type=\"HslTransformTexture\" param=\"Foundations\" value=\""+values+"\"/>\r\n");
		}	
		return tml;
	}
	
	private ArrayList<String> processEnvironmentModifiers() {
		ArrayList<String> eml = new ArrayList<>();
		if(CC.isDayHoursSet()) {
			eml.add("\t<environment_modifier type=\"DayHours\" value=\""+CC.getDayHours()+"\"/>\r\n");
		}
		if(CC.isNightHoursSet()) {
			eml.add("\t<environment_modifier type=\"NightHours\" value=\""+CC.getNightHours()+"\"/>\r\n");
		}
		if(CC.isRemoveSatellites()) {
			eml.add("\t<environment_modifier type=\"RemoveSatellites\"/>\r\n");
		}
		
		if(CC.isEnvironmentIndexSet()) {
			eml.add("\t<environment_modifier type=\"EnvironmentMapIndex\" value=\""+CC.getEnvironmentIndex()+"\"/>\r\n");
		}
		if(CC.isSunIndexSet()) {
			eml.add("\t<environment_modifier type=\"SunIndex\" value=\""+CC.getSunIndex()+"\"/>\r\n");
		}
		if(CC.isBackdropsIndexSet()) {
			eml.add("\t<environment_modifier type=\"BackdropsIndex\" value=\""+CC.getBackdropsIndex()+"\"/>\r\n");
		}
		
		if(CC.isFogIntensityDaySet()) {
			eml.add("\t<environment_modifier type=\"FogIntensityDay\" value=\""+CC.getFogIntensityDay()+"\"/>\r\n");
		}
		if(CC.isFogIntensityNightSet()) {
			eml.add("\t<environment_modifier type=\"FogIntensityNight\" value=\""+CC.getFogIntensityNight()+"\"/>\r\n");
		}
		if(CC.isFogIntensityTwilightSet()) {
			eml.add("\t<environment_modifier type=\"FogIntensityTwilight\" value=\""+CC.getFogIntensityTwilight()+"\"/>\r\n");
		}
		
		if(CC.getLightColorDay()!=null) {
			RGB color = CC.getLightColorDay();
			String values = color.r+","+color.g+","+color.b;
			eml.add("\t<environment_modifier type=\"LightColorDay\" value=\""+values+"\"/>\r\n");
		}
		if(CC.getLightColorNight()!=null) {
			RGB color = CC.getLightColorNight();
			String values = color.r+","+color.g+","+color.b;
			eml.add("\t<environment_modifier type=\"LightColorNight\" value=\""+values+"\"/>\r\n");
		}
		if(CC.getLightColorTwilight()!=null) {
			RGB color = CC.getLightColorTwilight();
			String values = color.r+","+color.g+","+color.b;
			eml.add("\t<environment_modifier type=\"LightColorTwilight\" value=\""+values+"\"/>\r\n");
		}
		
		if(CC.getAmbientColorDay()!=null) {
			RGB color = CC.getAmbientColorDay();
			String values = color.r+","+color.g+","+color.b;
			eml.add("\t<environment_modifier type=\"AmbientColorDay\" value=\""+values+"\"/>\r\n");
		}
		if(CC.getAmbientColorNight()!=null) {
			RGB color = CC.getAmbientColorNight();
			String values = color.r+","+color.g+","+color.b;
			eml.add("\t<environment_modifier type=\"AmbientColorNight\" value=\""+values+"\"/>\r\n");
		}
		if(CC.getAmbientColorTwilight()!=null) {
			RGB color = CC.getAmbientColorTwilight();
			String values = color.r+","+color.g+","+color.b;
			eml.add("\t<environment_modifier type=\"AmbientColorTwilight\" value=\""+values+"\"/>\r\n");
		}
		
		if(CC.getHorizonColorDay()!=null) {
			RGB color = CC.getHorizonColorDay();
			String values = color.r+","+color.g+","+color.b;
			eml.add("\t<environment_modifier type=\"HorizonColorDay\" value=\""+values+"\"/>\r\n");
		}
		if(CC.getHorizonColorNight()!=null) {
			RGB color = CC.getHorizonColorNight();
			String values = color.r+","+color.g+","+color.b;
			eml.add("\t<environment_modifier type=\"HorizonColorNight\" value=\""+values+"\"/>\r\n");
		}
		if(CC.getHorizonColorTwilight()!=null) {
			RGB color = CC.getHorizonColorTwilight();
			String values = color.r+","+color.g+","+color.b;
			eml.add("\t<environment_modifier type=\"HorizonColorTwilight\" value=\""+values+"\"/>\r\n");
		}
		
		if(CC.getSkyColorDay()!=null) {
			RGB color = CC.getSkyColorDay();
			String values = color.r+","+color.g+","+color.b;
			eml.add("\t<environment_modifier type=\"SkyColorDay\" value=\""+values+"\"/>\r\n");
		}
		if(CC.getSkyColorNight()!=null) {
			RGB color = CC.getSkyColorNight();
			String values = color.r+","+color.g+","+color.b;
			eml.add("\t<environment_modifier type=\"SkyColorNight\" value=\""+values+"\"/>\r\n");
		}
		if(CC.getSkyColorTwilight()!=null) {
			RGB color = CC.getSkyColorTwilight();
			String values = color.r+","+color.g+","+color.b;
			eml.add("\t<environment_modifier type=\"SkyColorTwilight\" value=\""+values+"\"/>\r\n");
		}
		return eml;
	}
	
	private ArrayList<String> processGameplayModifiers() {
		ArrayList<String> gml = new ArrayList<>();
		if(CC.getSandstormRisk()!=null) {
			gml.add("\t<gameplay_modifier type=\"SandstormRisk\" param=\""+CC.getSandstormRisk()+"\"/>\r\n");
		}
		if(CC.getMeteorRisk()!=null) {
			gml.add("\t<gameplay_modifier type=\"MeteorRisk\" param=\""+CC.getMeteorRisk()+"\"/>\r\n");
		}
		if(CC.getSolareFlareRisk()!=null) {
			gml.add("\t<gameplay_modifier type=\"SolarFlareRisk\" param=\""+CC.getSolareFlareRisk()+"\"/>\r\n");
		}
		if(CC.getThunderstormRisk()!=null) {
			gml.add("\t<gameplay_modifier type=\"ThunderstormRisk\" param=\""+CC.getThunderstormRisk()+"\"/>\r\n");
		}
		if(CC.getBlizzardRisk()!=null) {
			gml.add("\t<gameplay_modifier type=\"BlizzardRisk\" param=\""+CC.getBlizzardRisk()+"\"/>\r\n");
		}
		if(CC.getAtmosphereDensity()!=null) {
			gml.add("\t<gameplay_modifier type=\"AtmosphereDensity\" param=\""+CC.getAtmosphereDensity()+"\"/>\r\n");
		}
		if(CC.getLightDensity()!=null) {
			gml.add("\t<gameplay_modifier type=\"LightAmount\" param=\""+CC.getLightDensity()+"\"/>\r\n");
		}
		
		if(CC.isDisableColonistsShips()) {
			gml.add("\t<gameplay_modifier type=\"DisableColonistShips\"/>\r\n");
		}
		if(CC.isDisableTraderTechs()) {
			gml.add("\t<gameplay_modifier type=\"DisableTraderTechs\"/>\r\n");
		}
		if(CC.isDisableVisitorRequirements()) {
			gml.add("\t<gameplay_modifier type=\"DisableVisitorRequirements\"/>\r\n");
		}
		if(CC.isDisableVisitorShips()) {
			gml.add("\t<gameplay_modifier type=\"DisableVisitorShips\"/>\r\n");
		}
		if(CC.isDisableTradingShips()) {
			gml.add("\t<gameplay_modifier type=\"DisableTradingShips\"/>\r\n");
		}
		if(CC.isDisableShipRecycling()) {
			gml.add("\t<gameplay_modifier type=\"DisableColonyShipRecycling\"/>\r\n");
		}
		if(CC.isDisableWorkerMining()) {
			gml.add("\t<gameplay_modifier type=\"DisableWorkerMining\"/>\r\n");
		}
		if(CC.isDisableNoMedicalSuppliesWarning()) {
			gml.add("\t<gameplay_modifier type=\"DisableNoMedicalSuppliesWarning\"/>\r\n");
		}
		if(CC.isInfiniteTraderBots()) {
			gml.add("\t<gameplay_modifier type=\"InfiniteTraderBots\"/>\r\n");
		}
		
		if(CC.getDisasterFrequency()>0) {
			gml.add("\t<gameplay_modifier type=\"DisasterFrequency\" param=\""+CC.getDisasterFrequency()+"\"/>\r\n");		
		}
		if(CC.getShipFrequency()>0) {
			gml.add("\t<gameplay_modifier type=\"ShipFrequency\" param=\""+CC.getShipFrequency()+"\"/>\r\n");
		}
		if(CC.getTradingShipFrequency()>0) {
			gml.add("\t<gameplay_modifier type=\"TradingShipFrequency\" param=\""+CC.getTradingShipFrequency()+"\"/>\r\n");
		}
		if(CC.getIntruderMinPrestige()>0) {
			gml.add("\t<gameplay_modifier type=\"IntruderMinPrestige\" param=\""+CC.getIntruderMinPrestige()+"\"/>\r\n");
		}
		if(CC.getExtraIntruders()>0) {
			gml.add("\t<gameplay_modifier type=\"ExtraIntruders\" param=\""+CC.getExtraIntruders()+"\"/>\r\n");
		}
		
		//TODO: it can be shortened
		if(CC.getDisableInteriorStructures()!=null || CC.getDisableExteriorStructures()!=null) {
			ArrayList<String> paramList = new ArrayList<>();
			if(CC.getDisableInteriorStructures()!=null) {
				for(String structure : CC.getDisableInteriorStructures()) {
					structure = structure.replaceAll(" ","").replaceAll("-","");
					paramList.add(structure);
				}
			}//endIF
			if(CC.getDisableExteriorStructures()!=null) {
				for(String structure : CC.getDisableExteriorStructures()) {
					structure = structure.replaceAll(" ","").replaceAll("-","");
					paramList.add(structure);
				}
			}
			paramList.forEach(structure->{
				gml.add("\t<gameplay_modifier type=\"DisableStructure\" param=\""+structure+"\"/>\r\n");
			});
			
		}
		
		if(CC.getDisableComponents()!=null) {
			
			for(String component : CC.getDisableComponents()) {
				component = component.replaceAll(" ","").replaceAll("-","");
				gml.add("\t<gameplay_modifier type=\"DisableComponent\" param=\""+component+"\"/>\r\n");
			}			
		}
		
		if(CC.getDisableStructureRequirement()!=null) {
		
			String[] structures = CC.getDisableStructureRequirement();
			boolean allStructures = Arrays.stream(structures).anyMatch("ALL"::equals);
			if(allStructures) {
				gml.add("\t<gameplay_modifier type=\"DisableStructureRequirements\"/>\r\n");
			}else {
				for(String structure : structures) {
					structure = structure.replaceAll(" ","").replaceAll("-","");
					gml.add("\t<gameplay_modifier type=\"DisableStructureRequirements\" param=\""+structure+"\"/>\r\n");
				}//endFOR				
			}//endELSE
		}
		
		if(CC.getRestrictedColonistShips()!=null) {
			StringBuilder paramList = new StringBuilder();
			for(String colonist : CC.getRestrictedColonistShips()) {
				paramList.append(colonist+",");
			}
			paramList.deleteCharAt(paramList.length()-1); //remove last comma		
			gml.add("\t<gameplay_modifier type=\"RestrictedColonistShips\" param=\""+paramList.toString()+"\"/>\r\n");
		}
		
		if(CC.getRestrictedTradingShips()!=null) {
			StringBuilder paramList = new StringBuilder();
			for(String trader : CC.getRestrictedTradingShips()) {
				paramList.append(trader+",");
			}
			paramList.deleteCharAt(paramList.length()-1); //remove last comma		
			gml.add("\t<gameplay_modifier type=\"RestrictedTradingShips\" param=\""+paramList.toString()+"\"/>\r\n");
		}
		
		if(CC.getUnlockTech()!=null) {
			for(String tech : CC.getUnlockTech()) {
				tech = tech.replaceAll(" ","").replaceAll("-","");
				gml.add("\t<gameplay_modifier type=\"UnlockTech\" param=\""+tech+"\"/>\r\n");
			}			
		}
		
		return gml;
	}
	
	private ArrayList<String> processStartingResources(){
		ArrayList<String> rl = new ArrayList<>();
		if(CC.getStartMetal()>0) {
			rl.add("\t<starting_resource type=\"Metal\" amount=\""+CC.getStartMetal()+"\"/>\r\n");
		}
		if(CC.getStartBioplastic()>0) {
			rl.add("\t<starting_resource type=\"Bioplastic\" amount=\""+CC.getStartBioplastic()+"\"/>\r\n");
		}
		if(CC.getStartMeal()>0) {
			rl.add("\t<starting_resource type=\"Meal\" amount=\""+CC.getStartMeal()+"\"/>\r\n");
		}
		if(CC.getStartSpares()>0) {
			rl.add("\t<starting_resource type=\"Spares\" amount=\""+CC.getStartSpares()+"\"/>\r\n");
		}
		if(CC.getStartMedicalSupplies()>0) {
			rl.add("\t<starting_resource type=\"MedicalSupplies\" amount=\""+CC.getStartMedicalSupplies()+"\"/>\r\n");
		}
		if(CC.getStartCoins()>0) {
			rl.add("\t<starting_resource type=\"Coins\" amount=\""+CC.getStartCoins()+"\"/>\r\n");
		}
		if(CC.getStartSemiconductors()>0) {
			rl.add("\t<starting_resource type=\"Semiconductors\" amount=\""+CC.getStartSemiconductors()+"\"/>\r\n");
		}
		if(CC.getStartGun()>0) {
			rl.add("\t<starting_resource type=\"Gun\" amount=\""+CC.getStartGun()+"\"/>\r\n");
		}
		if(CC.getStartAlcoholicDrink()>0) {
			rl.add("\t<starting_resource type=\"AlcoholicDrink\" amount=\""+CC.getStartAlcoholicDrink()+"\"/>\r\n");
		}
		return rl;
	};
	
	private ArrayList<String> processStartingSpecializations() {
		ArrayList<String> sl = new ArrayList<>();
		if(CC.getStartWorker()>0) {
			sl.add("\t<starting_specialization type=\"Worker\" amount=\""+CC.getStartWorker()+"\"/>\r\n");
		}
		if(CC.getStartBiologist()>0) {
			sl.add("\t<starting_specialization type=\"Biologist\" amount=\""+CC.getStartBiologist()+"\"/>\r\n");
		}
		if(CC.getStartEngineer()>0) {
			sl.add("\t<starting_specialization type=\"Engineer\" amount=\""+CC.getStartEngineer()+"\"/>\r\n");
		}
		if(CC.getStartMedic()>0) {
			sl.add("\t<starting_specialization type=\"Medic\" amount=\""+CC.getStartMedic()+"\"/>\r\n");
		}
		if(CC.getStartConstructor()>0) {
			sl.add("\t<starting_specialization type=\"Constructor\" amount=\""+CC.getStartConstructor()+"\"/>\r\n");
		}
		if(CC.getStartCarrier()>0) {
			sl.add("\t<starting_specialization type=\"Carrier\" amount=\""+CC.getStartCarrier()+"\"/>\r\n");
		}
		if(CC.getStartDriller()>0) {
			sl.add("\t<starting_specialization type=\"Driller\" amount=\""+CC.getStartDriller()+"\"/>\r\n");
		}		
		return sl;
	}
}
