package ie.provector.jpbce.struct;

import ie.provector.jpbce.ui.CheckedComboBox.CheckableItem;

public class Entities {
	
	public static CheckableItem[] AllStructures = {			
			  new CheckableItem("ALL"),
		      new CheckableItem("Airlock"),
		      new CheckableItem("Anti-Meteor Laser"),
		      new CheckableItem("Bar"),
		      new CheckableItem("Base Pad"),
		      new CheckableItem("Bio-Dome"),
		      new CheckableItem("Cabin"),
		      new CheckableItem("Canteen"),
		      new CheckableItem("Control Center"),
		      new CheckableItem("Dorm"),
		      new CheckableItem("Factory"),
		      new CheckableItem("Lab"),
		      new CheckableItem("Landing Pad"),
		      new CheckableItem("Mine"),
		      new CheckableItem("Monolith"),
		      new CheckableItem("Multi-Dome"),
		      new CheckableItem("Oxygen Generator"),
		      new CheckableItem("Power Collector"),
		      new CheckableItem("Processing Plant"),
		      new CheckableItem("Pyramid"),
		      new CheckableItem("Radio Antenna"),
		      new CheckableItem("Robotics Facility"),
		      new CheckableItem("Sick Bay"),
		      new CheckableItem("Signpost"),
		      new CheckableItem("Solar-Panel"),
		      new CheckableItem("Starport"),
		      new CheckableItem("Storage"),
		      new CheckableItem("Telescope"),
		      new CheckableItem("Water Extractor"),
		      new CheckableItem("Water Tank"),
		      new CheckableItem("Wind Turbine")
	 };

	 public static CheckableItem[] InternalStructures = {
		      new CheckableItem("Airlock"),
		      new CheckableItem("Bar"),
		      new CheckableItem("Bio-Dome"),
		      new CheckableItem("Cabin"),
		      new CheckableItem("Canteen"),
		      new CheckableItem("Control Center"),
		      new CheckableItem("Dorm"),
		      new CheckableItem("Factory"),
		      new CheckableItem("Lab"),
		      new CheckableItem("Multi-Dome"),
		      new CheckableItem("Oxygen Generator"),
		      new CheckableItem("Processing Plant"),
		      new CheckableItem("Robotics Facility"),
		      new CheckableItem("Sick Bay"),
		      new CheckableItem("Storage")
	 };
	 
	 public static CheckableItem[] ExternalStructures = {
		      new CheckableItem("Anti-Meteor Laser"),
		      new CheckableItem("Base Pad"),
		      new CheckableItem("Landing Pad"),
		      new CheckableItem("Mine"),
		      new CheckableItem("Monolith"),
		      new CheckableItem("Power Collector"),
		      new CheckableItem("Pyramid"),
		      new CheckableItem("Radio Antenna"),
		      new CheckableItem("Signpost"),
		      new CheckableItem("Solar-Panel"),
		      new CheckableItem("Starport"),
		      new CheckableItem("Telescope"),
		      new CheckableItem("Water Extractor"),
		      new CheckableItem("Water Tank"),
		      new CheckableItem("Wind Turbine")
	 };
	 
	 
	 public static CheckableItem[] Components = {
			  new CheckableItem("Armory"),
			  new CheckableItem("Arms Workshop"),
			  new CheckableItem("Bar Table"),
			  new CheckableItem("Bar TableNoChairs"),
			  new CheckableItem("Bed"),
			  new CheckableItem("Bench"),
			  new CheckableItem("Bioplastic Processor"),
			  new CheckableItem("Bot Auto-Repair"),
			  new CheckableItem("Bot Workshop"),
			  new CheckableItem("Bunk"),
			  new CheckableItem("Decorative Plant"),
			  new CheckableItem("Drinking Fountain"),
			  new CheckableItem("Drinks Machine"),
			  new CheckableItem("Exercise Bar"),
			  new CheckableItem("Gm Onion Pad"),
			  new CheckableItem("Gm Tomato Pad"),
			  new CheckableItem("Lettuce Pad"),
			  new CheckableItem("Maize Pad"),
			  new CheckableItem("Meal Maker"),
			  new CheckableItem("Medical Cabinet"),
			  new CheckableItem("Medicinal Pad"),
			  new CheckableItem("Metal Processor"),
			  new CheckableItem("Mushroom Pad"),
			  new CheckableItem("Oak Tree"),
			  new CheckableItem("Onion Pad"),
			  new CheckableItem("Pea Pad"),
			  new CheckableItem("Pine Tree"),
			  new CheckableItem("Potato Pad"),
			  new CheckableItem("Radio Console"),
			  new CheckableItem("Radish Pad"),
			  new CheckableItem("Rice Pad"),
			  new CheckableItem("Security Console"),
			  new CheckableItem("Semiconductor Foundry"),
			  new CheckableItem("Sick Bay Bed"),
			  new CheckableItem("Spares Workshop"),
			  new CheckableItem("Table"),
			  new CheckableItem("Table Small"),
			  new CheckableItem("Telescope Console"),
			  new CheckableItem("Tissue Synthesizer"),
			  new CheckableItem("Tomato Pad"),
			  new CheckableItem("Treadmill"),
			  new CheckableItem("Video Screen"),
			  new CheckableItem("Wheat Pad"),
			  new CheckableItem("Workbench")			     
	 };
	 
	 public static CheckableItem[] Colonists = {
		      new CheckableItem("Biologist"),
		      new CheckableItem("Engineer"),
		      new CheckableItem("Guard"),
		      new CheckableItem("Medic"),
		      new CheckableItem("Worker")
	 };
	 
	 public static CheckableItem[] TradingShips = {
		      new CheckableItem("Electronics"),
		      new CheckableItem("Food"),
		      new CheckableItem("Industrial"),
		      new CheckableItem("Medical"),
		      new CheckableItem("RawMaterial")
	 };
	 
	 public static CheckableItem[] Technologies = {
			 new CheckableItem("Colossal Panel"),
			 new CheckableItem("Constructor Bot"),
			 new CheckableItem("Driller Bot"),
			 new CheckableItem("Farm Dome"),
			 new CheckableItem("Gm Onions"),
			 new CheckableItem("Gm Tomatoes"),
			 new CheckableItem("Goliath Turbine"),
			 new CheckableItem("Massive Storage"),
			 new CheckableItem("Mega Collector"),
			 new CheckableItem("Super Extractor")
	 };
	 
	 /*
	   		TechGoliathTurbine
			TechColossalPanel
			TechMassiveStorage
			TechFarmDome
			TechMegaCollector
			TechSuperExtractor
			TechConstructorBot
			TechDrillerBot
			TechGmTomatoes
			TechGmOnions
	  */
	 
	 public static String[] Objectives = {
			new String("Accumulate Resources"),
			new String("Build Structures"),
			new String("Build Components"),
			new String("Keep Character Alive"),
			new String("Reach Specialization")
	 };
	 
	 public static String[] AllStructuresString = {
		     new String("Airlock"),
		     new String("Anti-Meteor Laser"),
		     new String("Bar"),
		     new String("Base Pad"),
		     new String("Bio-Dome"),
		     new String("Cabin"),
		     new String("Canteen"),
		     new String("Control Center"),
		     new String("Dorm"),
		     new String("Factory"),
		     new String("Lab"),
		     new String("Landing Pad"),
		     new String("Mine"),
		     new String("Monolith"),
		     new String("Multi-Dome"),
		     new String("Oxygen Generator"),
		     new String("Power Collector"),
		     new String("Processing Plant"),
		     new String("Pyramid"),
		     new String("Radio Antenna"),
		     new String("Robotics Facility"),
		     new String("Sick Bay"),
		     new String("Signpost"),
		     new String("Solar-Panel"),
		     new String("Starport"),
		     new String("Storage"),
		     new String("Telescope"),
		     new String("Water Extractor"),
		     new String("Water Tank"),
		     new String("Wind Turbine")	 
	 };
	 public static String[] DifficultyString =  {
			 new String("Easy"),
			 new String("Normal"),
			 new String("Hard"),
			 new String("Challenging")
	 };
	 
	 public static String[] ResourcesString = {
			 new String("Alcohol"),
			 new String("Bioplastic"),
			 new String("Gun"),
			 new String("Meal"),
			 new String("Medical Supplies"),
			 new String("Medicinal Plants"),
			 new String("Metal"),
			 new String("Ore"),
			 new String("Semiconductors"),
			 new String("Starch"),
			 new String("Spares"),
			 new String("Vegetables"),
			 new String("Vitromeat"),
	 };
	 
	 public static String[] AllComponentsString = {
			 new String("Armory"),
			 new String("Arms Workshop"),
			 new String("Bar Table"),
			 new String("Bar TableNoChairs"),
			 new String("Bed"),
			 new String("Bench"),
			 new String("Bioplastic Processor"),
			 new String("Bot Auto-Repair"),
			 new String("Bot Workshop"),
			 new String("Bunk"),
			 new String("Decorative Plant"),
			 new String("Drinking Fountain"),
			 new String("Drinks Machine"),
			 new String("Exercise Bar"),
			 new String("Gm Onion Pad"),
			 new String("Gm Tomato Pad"),
			 new String("Lettuce Pad"),
			 new String("Maize Pad"),
			 new String("Meal Maker"),
			 new String("Medical Cabinet"),
			 new String("Medicinal Pad"),
			 new String("Metal Processor"),
			 new String("Mushroom Pad"),
			 new String("Oak Tree"),
			 new String("Onion Pad"),
			 new String("Pea Pad"),
			 new String("Pine Tree"),
			 new String("Potato Pad"),
			 new String("Radio Console"),
			 new String("Radish Pad"),
			 new String("Rice Pad"),
			 new String("Security Console"),
			 new String("Semiconductor Foundry"),
			 new String("Sick Bay Bed"),
			 new String("Spares Workshop"),
			 new String("Table"),
			 new String("Table Small"),
			 new String("Telescope Console"),
			 new String("Tissue Synthesizer"),
			 new String("Tomato Pad"),
			 new String("Treadmill"),
			 new String("Video Screen"),
			 new String("Wheat Pad"),
			 new String("Workbench")			     
	 };
	 
	 public static String[] SpecializationsString = {
			 new String("Biologist"),
			 new String("Carrier Bot"), //Carrier
			 new String("Constructor Bot"), //Constructor
			 new String("Driller"), //Driller
			 new String("Engineer"),
			 new String("Guard"),
			 new String("Medic"),
			 new String("Worker") 
	 };
	 
	 
}
