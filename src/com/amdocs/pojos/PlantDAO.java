package com.amdocs.pojos;
import java.util.*;

import com.amdocs.main.Plant;



public interface PlantDAO {
	int addPlant(Plant plant);
	int deletePlant(int plantId)throws PlantNotFoundException;
	boolean updatePlantCost(int plantId, double cost);
	List<Plant> showAllPlants();
	List<Plant> searchByOriginCountryName(String originCountryName) throws PlantNotFoundException;
	List<Plant> searchOutdoorPlantsWithSunlight() throws PlantNotFoundException;
	int countPlantsByWaterSupplyFrequency(String waterSupplyFrequency);
}
