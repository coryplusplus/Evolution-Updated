package world;

import java.util.HashMap;
import java.util.Random;

import constants.Constants;

import area.Area;


public class World

{







   public static HashMap<Integer, Area> areaIDMap;





   public World()

   {

       areaIDMap = new HashMap<Integer, Area>();

       _initAreas();

   }







   public void _initAreas()

   {

       createAreas();

       mapAreas();

   }







   private void createAreas()

   {

       createAreaOne();

       createAreaTwo();

       createAreaThree();

       createAreaFour();

       createAreaFive();

       createAreaSix();

       createAreaSeven();

       createAreaEight();

       createAreaNine();

       createAreaTen();



   }



   private void mapAreas()

   {

       mapAreaOne();

       mapAreaTwo();

       mapAreaThree();

       mapAreaFour();

       mapAreaFive();

       mapAreaSix();

       mapAreaSeven();

       mapAreaEight();

       mapAreaNine();

       mapAreaTen();



   }



////////////////////////AREA CREATE METHODS////////////////////////////

   private void createAreaOne()

   {

       String description = "<html>You are in the dead center of a beautiful forest grove.<br>" +
       "Within this thicket of trees lies a solem stump surrounded by a suspicious circle of mushrooms.<br>" +
       "The air smells crisp with the scent of pine and damp soil. Even though you have never been<br> here before" +
       "you realize immediately that this is a sacred place and should be \"respect\"ed.<br>" +
       "There are four paths leading out of this area, each lined with an assortment of pebbles.</html>";
       Area area = new Area(description,Constants.FIRST_AREA_ID);

       areaIDMap.put(Constants.FIRST_AREA_ID, area);

   }



   private void createAreaTwo()

   {

   	String description = "<html>As you follow the path leading deeper into<br> the woods you notice a group of butterflies<br>" +
   			"hoovering over something in the distance. What is even<br>stranger is that you feel as if something is watching you.<br>" +
   			"To the east you notice a small path made through the<br> bramble. To the west blows a sinister wind carrying whispers <br>" +
   			"of the darkness that lies ahead.</html>";
       Area area = new Area(description,Constants.SECOND_AREA_ID);

       areaIDMap.put(Constants.SECOND_AREA_ID, area);

   }



   private void createAreaThree()

   {

   	String description = "<html>You enter through the small rabbit <br>sized hole and are astonished at what you find on the inside.<br>" +
   			"Intricate designs crafted in briar lay before you <br>and deep in the distance you see a rabbit sized throne!<br>" +
                       "Sitting most elegantly on the throne is the <br>rabbit King Orthax, and with a curious grin he waves for you to come over.<br>" +
   			"None of this is making sense, but it seems that <br>once you possess a specific creature, you are then able to communicate<br>" +
   			"with other creatures of the same type. Careful <br>though, you also may become prey.</html>";
       Area area = new Area(description,Constants.THIRD_AREA_ID);

       areaIDMap.put(Constants.THIRD_AREA_ID, area);

   }



   private void createAreaFour()

   {

       Area area = new Area("This is area four",Constants.FOURTH_AREA_ID);

       areaIDMap.put(Constants.FOURTH_AREA_ID, area);

   }



   private void createAreaFive()

   {

       Area area = new Area("<html>The first thing you notice about this area is the smell.<br>" +
       		"In every direction, the stench is almost unbearable! Through your now watering eyes<br>" +
       		"you notice a creature staring back at you from the distance. You have entered<br>" +
       		"his home and he is not pleased at all...</html>",Constants.FIFTH_AREA_ID);

       areaIDMap.put(Constants.FIFTH_AREA_ID, area);

   }



   private void createAreaSix()

   {

       Area area = new Area("This is area six",Constants.SIXTH_AREA_ID);

       areaIDMap.put(Constants.SIXTH_AREA_ID, area);

   }



   private void createAreaSeven()

   {

       Area area = new Area("This is area seven",Constants.SEVENTH_AREA_ID);

       areaIDMap.put(Constants.SEVENTH_AREA_ID, area);

   }



   private void createAreaEight()

   {

       Area area = new Area("This is area eigth",Constants.EIGHTH_AREA_ID);

       areaIDMap.put(Constants.EIGHTH_AREA_ID, area);

   }



   private void createAreaNine()

   {

       Area area = new Area("This is area nine",Constants.NINTH_AREA_ID);

       areaIDMap.put(Constants.NINTH_AREA_ID, area);

   }



   private void createAreaTen()

   {

       Area area = new Area("This is area ten",Constants.TENTH_AREA_ID);

       areaIDMap.put(Constants.TENTH_AREA_ID, area);

   }



////////////////////////END AREA CREATE METHODS////////////////////////////

 



////////////////////////AREA MAP METHODS///////////////////////////////////





   private void mapAreaOne()

   {

       Area area = areaIDMap.get(Constants.FIRST_AREA_ID);

       area.areaMap.put(Constants.North, areaIDMap.get(Constants.SECOND_AREA_ID));

       area.areaMap.put(Constants.South, areaIDMap.get(Constants.FIFTH_AREA_ID));

       area.areaMap.put(Constants.East, areaIDMap.get(Constants.FOURTH_AREA_ID));

       area.areaMap.put(Constants.West, areaIDMap.get(Constants.SIXTH_AREA_ID));

       area.paths = Constants.NorthSouthEastAndWest;

   }



   private void mapAreaTwo()

   {

       Area area = areaIDMap.get(Constants.SECOND_AREA_ID);

       area.areaMap.put(Constants.South, areaIDMap.get(Constants.FIRST_AREA_ID));

       area.areaMap.put(Constants.East, areaIDMap.get(Constants.THIRD_AREA_ID));

       area.areaMap.put(Constants.West, areaIDMap.get(Constants.TENTH_AREA_ID));

       area.paths = Constants.SouthEastAndWest;

   }



   private void mapAreaThree()

   {

       Area area = areaIDMap.get(Constants.THIRD_AREA_ID);

       area.areaMap.put(Constants.South, areaIDMap.get(Constants.FOURTH_AREA_ID));

       area.areaMap.put(Constants.West, areaIDMap.get(Constants.SECOND_AREA_ID));

       area.paths = Constants.SouthAndWest;

   }



   private void mapAreaFour()

   {

       Area area = areaIDMap.get(Constants.FOURTH_AREA_ID);

       area.areaMap.put(Constants.North, areaIDMap.get(Constants.THIRD_AREA_ID));

       area.areaMap.put(Constants.West, areaIDMap.get(Constants.FIRST_AREA_ID));

       area.paths = Constants.NorthAndWest;

   }



   private void mapAreaFive()

   {

       Area area = areaIDMap.get(Constants.FIFTH_AREA_ID);

       area.areaMap.put(Constants.North, areaIDMap.get(Constants.FIRST_AREA_ID));

       area.paths = Constants.North;

   }



   private void mapAreaSix()

   {

       Area area = areaIDMap.get(Constants.SIXTH_AREA_ID);

       area.areaMap.put(Constants.East, areaIDMap.get(Constants.FIRST_AREA_ID));

       area.areaMap.put(Constants.West, areaIDMap.get(Constants.SEVENTH_AREA_ID));

       area.paths = Constants.EastAndWest;

   }



   private void mapAreaSeven()

   {

       Area area = areaIDMap.get(Constants.SEVENTH_AREA_ID);

       area.areaMap.put(Constants.North, areaIDMap.get(Constants.EIGHTH_AREA_ID));

       area.areaMap.put(Constants.East, areaIDMap.get(Constants.SIXTH_AREA_ID));

       area.paths = Constants.NorthAndEast;

   }



   private void mapAreaEight()

   {

       Area area = areaIDMap.get(Constants.EIGHTH_AREA_ID);

       area.areaMap.put(Constants.North, areaIDMap.get(Constants.NINTH_AREA_ID));

       area.areaMap.put(Constants.South, areaIDMap.get(Constants.SEVENTH_AREA_ID));

       area.paths = Constants.NorthAndSouth;

   }



   private void mapAreaNine()

   {

       Area area = areaIDMap.get(Constants.NINTH_AREA_ID);

       area.areaMap.put(Constants.East, areaIDMap.get(Constants.TENTH_AREA_ID));

       area.areaMap.put(Constants.South, areaIDMap.get(Constants.EIGHTH_AREA_ID));

       area.paths = Constants.SouthAndEast;

   }



   private void mapAreaTen()

   {

       Area area = areaIDMap.get(Constants.TENTH_AREA_ID);

       area.areaMap.put(Constants.East, areaIDMap.get(Constants.SECOND_AREA_ID));

       area.areaMap.put(Constants.West, areaIDMap.get(Constants.NINTH_AREA_ID));

       area.paths = Constants.EastAndWest;

   }

  

   //area parameter is area we are currently in

   public Area GetNextAreaRandom(Area area)

   {

       Random rand = new Random();

       int i = 0;

       switch(area.paths)

       {

       case Constants.North:

        i = rand.nextInt(2);

        if(i==0)

               return area.areaMap.get(Constants.North);

        if(i==1)

         return area;

       case Constants.South:

        if(i==0)

               return area.areaMap.get(Constants.South);

        if(i==1)

         return area;



       case Constants.East:

        if(i==0)

               return area.areaMap.get(Constants.East);

        if(i==1)

         return area;



       case Constants.West:

        if(i==0)

               return area.areaMap.get(Constants.West);

        if(i==1)

         return area;





       case Constants.NorthAndSouth:

        i = rand.nextInt(3);

        if(i == 0)

         return area.areaMap.get(Constants.North);

        if(i == 1)

         return area.areaMap.get(Constants.South);

        if(i == 2)

         return area;

       case Constants.NorthAndEast:

        i = rand.nextInt(3);

        if(i == 0)

         return area.areaMap.get(Constants.North);

        if(i == 1)

         return area.areaMap.get(Constants.East);

        if(i == 2)

         return area;

       case Constants.NorthAndWest:

        i = rand.nextInt(3);

        if(i == 0)

         return area.areaMap.get(Constants.North);

        if(i == 1)

         return area.areaMap.get(Constants.West);

        if(i == 2)

         return area;

       case Constants.SouthAndEast:

        i = rand.nextInt(3);

        if(i == 0)

         return area.areaMap.get(Constants.East);

        if(i == 1)

         return area.areaMap.get(Constants.South);

        if(i == 2)

         return area;

       case Constants.SouthAndWest:

        i = rand.nextInt(3);

        if(i == 0)

         return area.areaMap.get(Constants.West);

        if(i == 1)

         return area.areaMap.get(Constants.South);

        if(i == 2)

         return area;

       case Constants.EastAndWest:

        i = rand.nextInt(3);

        if(i == 0)

         return area.areaMap.get(Constants.East);

        if(i == 1)

         return area.areaMap.get(Constants.West);

        if(i == 2)

         return area;

       case Constants.NorthSouthAndEast:

        i = rand.nextInt(4);

        if(i == 0)

         return area.areaMap.get(Constants.North);

        if(i == 1)

         return area.areaMap.get(Constants.South);

        if(i == 2)

         return area.areaMap.get(Constants.East);

        if(i == 3)

         return area;

       case Constants.NorthSouthAndWest:

        i = rand.nextInt(4);

        if(i == 0)

         return area.areaMap.get(Constants.North);

        if(i == 1)

         return area.areaMap.get(Constants.South);

        if(i == 2)

         return area.areaMap.get(Constants.West);

        if(i == 3)

         return area;

       case Constants.NorthEastAndWest:

        i = rand.nextInt(4);

        if(i == 0)

         return area.areaMap.get(Constants.North);

        if(i == 1)

         return area.areaMap.get(Constants.East);

        if(i == 2)

         return area.areaMap.get(Constants.West);

        if(i == 3)

         return area;

       case Constants.SouthEastAndWest:

        i = rand.nextInt(4);

        if(i == 0)

         return area.areaMap.get(Constants.West);

        if(i == 1)

         return area.areaMap.get(Constants.South);

        if(i == 2)

         return area.areaMap.get(Constants.East);

        if(i == 3)

         return area;



       case Constants.NorthSouthEastAndWest:

        i = rand.nextInt(5);

        if(i == 0)

         return area.areaMap.get(Constants.West);

        if(i == 1)

         return area.areaMap.get(Constants.South);

        if(i == 2)

         return area.areaMap.get(Constants.North);

        if(i == 3)

         return area.areaMap.get(Constants.East);

        if(i == 4)

         return area;

       }

      

       return area;



    

   }



////////////////////////END AREA MAP METHODS///////////////////////////////////



}