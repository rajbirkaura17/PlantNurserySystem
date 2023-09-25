package com.amdocs.pojos;

import java.util.*;

import com.amdocs.main.Plant;


public class PlantDAOImpl implements PlantDAO {
	List<Plant> Plants= new ArrayList<>();

	@Override
	public int addPlant(Plant plant) {
		Plants.add(plant);
		return plant.getPlantId();
	}

	@Override
	public int deletePlant(int plantId) {
		for(Plant plant:Plants)
		{
			if(plant.getPlantId()==plantId)
			{
				Plants.remove(plant);
				break;
			}
		}
		return plantId;
	}

	@Override
	public boolean updatePlantCost(int plantId, double cost) {
		for(Plant plant:Plants)
		{
			if(plant.getPlantId()==plantId)
			{
				plant.setCost(cost);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Plant> showAllPlants() {
		return Plants;
	}

	@Override
	public List<Plant> searchByOriginCountryName(String originCountryName) throws PlantNotFoundException {
		List<Plant> tempList = new ArrayList<>();
		for(Plant plant:Plants)
		{
			if(plant.getOriginCountryName().equals(originCountryName))
			{
				System.out.println(plant);
				tempList.add(plant);
			}
		}
		return tempList;
	}

	@Override
	public List<Plant> searchOutdoorPlantsWithSunlight() throws PlantNotFoundException {
		List<Plant> tempList = new ArrayList<>();
		for(Plant plant:Plants)
		{
			if(plant.isSunlightRequired() && plant.getPlantType().equals("outdoor")) //is true if sunlight is required and type is "outdoor"
			{
				System.out.println(plant);
				tempList.add(plant);
			}
		}
		return tempList;
	}

	@Override
	public int countPlantsByWaterSupplyFrequency(String waterSupplyFrequency) {
		int count = 0;
		for(Plant plant:Plants)
		{
			if(plant.getWaterSupplyFrequency().equals(waterSupplyFrequency))
				count++;
		}
		return count;
	}
}
