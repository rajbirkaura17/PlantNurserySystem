package com.amdocs.main;


import java.util.*;
import com.amdocs.pojos.PlantDAO;
import com.amdocs.pojos.PlantDAOImpl;
import com.amdocs.pojos.PlantNotFoundException;


public class Main {
	public static void main(String[] args) {
		PlantDAO dao=new PlantDAOImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to the Nursery Plant management System!!");
		boolean f=true;
		do
		{
			System.out.println("1. Add new plant\r\n"
					+ "2. Update plant cost\r\n"
					+ "3. Delete plant\r\n"
					+ "4. View all plants\r\n"
					+ "5. Find plant by origin country name\r\n"
					+ "6. Find outdoor plants which requires sunlight\r\n"
					+ "7. Count plants by water supply frequency\r\n"
					+ "8. Exit\r\n"
					+ "");

			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("Add new plant");
	
					System.out.println("Enter Plant Id");
					int plantId=sc.nextInt();
					System.out.println("Enter Plant name");
					String plantName=sc.next();
					System.out.println("Enter country of origin");
					String originCountryName=sc.next();
					System.out.println("Does the plant require sunlight (true/false)");
					boolean sunlightRequired=sc.nextBoolean();
					System.out.println("Enter Frequency of water supply (daily/alternateDays/weekly");
					String waterSupplyFrequency=sc.next();
					System.out.println("Enter type of plant (indoor/outdoor)");
					String plantType=sc.next();
					System.out.println("Enter cost of plant");
					double cost=sc.nextDouble();
					Plant plant=new Plant(plantId,plantName,originCountryName,sunlightRequired,waterSupplyFrequency,plantType,cost);
					dao.addPlant(plant);
					System.out.println("Plant Added Successfully");
					break;
					
				case 2:
					System.out.println("Update plant cost");
					System.out.println("Enter plant Id: ");
					int plantId2=sc.nextInt();
					System.out.println("Enter new cost: ");
					double newCost=sc.nextDouble();
					boolean flag=false;
					try{
						flag=dao.updatePlantCost(plantId2, newCost);
						if(flag)
							System.out.println("Plant cost updated\n");
						else
							throw new PlantNotFoundException("Plant not found\n");
					} catch (PlantNotFoundException e){
						e.printStackTrace();
					}
					break;
					
				case 3:
					System.out.println("Enter id of plant to delete");
					dao.deletePlant(sc.nextInt());
					break;
					
				case 4:
					System.out.println("All saved plants:\n");
					List<Plant> Plants=dao.showAllPlants();
					for(Plant plant1:Plants)
					{
						System.out.println(plant1);
					}
					break;
					
				case 5:
					System.out.println("Find plant by country name\nEnter country name: ");
					String countryName=sc.next();
					try{
					List<Plant> tempList=dao.searchByOriginCountryName(countryName);
					if(tempList!=null && tempList.size()==0 ){
						throw new PlantNotFoundException("No Plants in this country ");
					}
					else{
					for(Plant plant2:tempList)
					{
						System.out.println(plant2);
					}
					}
					}catch (PlantNotFoundException e){
						e.printStackTrace();
					}
					break;
					
				case 6:
					System.out.println("Find outdoor plants which requires sunlight");
					try{
					List<Plant> outdoorSunlightPlants=dao.searchOutdoorPlantsWithSunlight();
					if(outdoorSunlightPlants!=null && outdoorSunlightPlants.size()==0){
						throw new PlantNotFoundException("No Plants which requires sunlight ");
					}
					else{
					for(Plant plant3:outdoorSunlightPlants)
					{
						System.out.println(plant3);
					}
					}
					}catch (PlantNotFoundException e){
						e.printStackTrace();
					
					}
					break;
					
				case 7:
					System.out.println("Count plants by water supply frequency\nEnter frequency");
					String freq=sc.next();
					int count=dao.countPlantsByWaterSupplyFrequency(freq);
					System.out.println("Number of plants with frequency "+freq+" = "+count);
					break;
					
				case 8:
					System.out.println("Thank you for using this program");
					f=false;
					break;
			}
		} while(f==true);	
	}

}
