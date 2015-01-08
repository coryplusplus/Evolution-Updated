package utils;

import java.util.Enumeration;

import ai.AI;
import area.Area;
import character.Character;
import constants.Constants;

public class DisplayUtils

{

 

    private static final String North =

    "Only possible direction is North\n";

    private static final String South =

    "Only possible direction is South\n";

    private static final String East =

    "Only possible direction is East\n";

    private static final String West =

    "Only possible direction is North\n";

 

    private static final String NorthAndSouth =

        "Possible directions: North and South\n";

    private static final String NorthAndEast =

        "Possible directions: North and East\n";

    private static final String NorthAndWest =

        "Possible directions: North and West\n";

    private static final String SouthAndEast =

        "Possible directions: South and East\n";

    private static final String SouthAndWest =

        "Possible directions: South and West\n";

    private static final String EastAndWest =

        "Possible directions: East and West\n";

 

    private static final String NorthSouthAndEast =

        "Possible directions: North, South, and East\n";

    private static final String NorthSouthAndWest =

        "Possible directions: North, South, and West\n";

    private static final String NorthEastAndWest =

        "Possible directions: North, East, and West\n";

    private static final String SouthEastAndWest =

        "Possible directions: South, East, and West\n";

 

    private static final String NorthSouthEastAndWest =

        "Possible directions: North, South, East, and West\n";

 

 

   

    public static String possibleDirections(Area area)

    {

        switch(area.paths)

        {

        case Constants.North: return North;

        case Constants.South: return South;

        case Constants.East: return East;

        case Constants.West: return West;

 

        case Constants.NorthAndSouth: return NorthAndSouth;

        case Constants.NorthAndEast: return NorthAndEast;

        case Constants.NorthAndWest: return NorthAndWest;

        case Constants.SouthAndEast: return SouthAndEast;

        case Constants.SouthAndWest: return SouthAndWest;

        case Constants.EastAndWest: return EastAndWest;

 

        case Constants.NorthSouthAndEast: return NorthSouthAndEast;

        case Constants.NorthSouthAndWest: return NorthSouthAndWest;

        case Constants.NorthEastAndWest: return NorthEastAndWest;

        case Constants.SouthEastAndWest: return SouthEastAndWest;

 

        case Constants.NorthSouthEastAndWest: return NorthSouthEastAndWest;

        }

 

 

        return "THERE IS NO ESCAPE!";

    }

   

   

    public static void printCompass(Area area)

    {

        switch(area.paths)

        {

        case Constants.North: printCompassN();break;

        case Constants.South: printCompassS();break;

        case Constants.East: printCompassE();break;

        case Constants.West: printCompassW();break;

 

        case Constants.NorthAndSouth: printCompassNS();break;

        case Constants.NorthAndEast: printCompassNE();break;

        case Constants.NorthAndWest: printCompassNW();break;

        case Constants.SouthAndEast: printCompassSE();break;

        case Constants.SouthAndWest: printCompassSW();break;

        case Constants.EastAndWest: printCompassEW();break;

 

        case Constants.NorthSouthAndEast: printCompassNSE();break;

        case Constants.NorthSouthAndWest: printCompassNSW();break;

        case Constants.NorthEastAndWest: printCompassNEW();break;

        case Constants.SouthEastAndWest: printCompassSEW();break;

 

        case Constants.NorthSouthEastAndWest: printCompassNSEW();break;

        }

 

    }

   

    public static void printCompassN()

    {

        System.out.println("                              N");

        System.out.println("                              |");

        System.out.println("                           ---*---");

        System.out.println("                              |");

        System.out.println("                               ");

    }

   

    public static void printCompassS()

    {

        System.out.println("                               ");

        System.out.println("                              |");

        System.out.println("                           ---*---");

        System.out.println("                              |");

        System.out.println("                              S");

    }

   

    public static void printCompassE()

    {

        System.out.println("                               ");

        System.out.println("                              |");

        System.out.println("                           ---*---E");

        System.out.println("                              |");

        System.out.println("                              ");

    }

   

    public static void printCompassW()

    {

        System.out.println("                               ");

        System.out.println("                              |");

        System.out.println("                          W---*---");

        System.out.println("                              |");

        System.out.println("                               ");

    }

   

    public static void printCompassNS()

    {

        System.out.println("                              N ");

        System.out.println("                              |");

        System.out.println("                           ---*---");

        System.out.println("                              |");

        System.out.println("                              S");

    }

   

    public static void printCompassNE()

    {

        System.out.println("                              N");

        System.out.println("                              |");

        System.out.println("                           ---*---E");

        System.out.println("                              |");

        System.out.println("                               ");

    }

   

    public static void printCompassNW()

    {

        System.out.println("                              N");

        System.out.println("                              |");

        System.out.println("                          W---*---");

        System.out.println("                              |");

        System.out.println("                               ");

    }

   

    public static void printCompassSE()

    {

        System.out.println("                               ");

        System.out.println("                              |");

        System.out.println("                           ---*---E");

        System.out.println("                              |");

        System.out.println("                              S ");

    }

   

    public static void printCompassSW()

    {

        System.out.println("                               ");

        System.out.println("                              |");

        System.out.println("                          W---*---");

        System.out.println("                              |");

        System.out.println("                              S ");

    }

   

    public static void printCompassEW()

    {

        System.out.println("                               ");

        System.out.println("                              |");

        System.out.println("                          W---*---E");

        System.out.println("                              |");

        System.out.println("                               ");

    }

   

    public static void printCompassNSE()

    {

        System.out.println("                              N ");

        System.out.println("                              |");

        System.out.println("                           ---*---E");

        System.out.println("                              |");

        System.out.println("                              S ");

    }

   

    public static void printCompassNSW()

    {

        System.out.println("                              N ");

        System.out.println("                              |");

        System.out.println("                          W---*---");

        System.out.println("                              |");

        System.out.println("                              S ");

    }

   

    public static void printCompassNEW()

    {

        System.out.println("                              N ");

        System.out.println("                              |");

        System.out.println("                          W---*---E");

        System.out.println("                              |");

        System.out.println("                               ");

    }

   

    public static void printCompassSEW()

    {

        System.out.println("                               ");

        System.out.println("                              |");

        System.out.println("                          W---*---E");

        System.out.println("                              |");

        System.out.println("                              S ");

    }

   

    public static void printCompassNSEW()

    {

        System.out.println("                              N ");

        System.out.println("                              |");

        System.out.println("                          W---*---E");

        System.out.println("                              |");

        System.out.println("                              S ");

    }

 

  

 

 

    public static void printInitialAreaText(Area area)

    {

        printAreaDescription(area);

        Enumeration<AI> vEnum = area.ai.elements();

        while (vEnum.hasMoreElements())

        {

            System.out.println(vEnum.nextElement().description);

        }

        printDirections(area);

    }

 

    public static void printAreaDescription(Area area)

    {

        System.out.println();

        System.out.println(area.description);

    }

 

    public static void printDirections(Area area)

    {

       

        System.out.println(possibleDirections(area));

        printCompass(area);

    }

    public static void printStats(Character character)
    {
        System.out.println();
        System.out.println("Possessed: " + character.possessed);
        System.out.println("Max HP: " + character.base_hp);
        System.out.println("Current HP: " + character.hp);
        System.out.println("Max SP: " + character.base_sp);
        System.out.println("Current SP: " + character.sp);
        System.out.println("Damage: " + character.base_damage_infliction);
        System.out.println("Attack Speed: " + character.attack_speed);
        System.out.println();


    }

    public static String getStats(Character character)
    {
        String stats =  "<html>Possessed: " + character.possessed + "<br>";
        stats = stats + "Max HP: " + character.base_hp + "<br>";
        stats = stats + "Current HP: " + character.hp + "<br>";
        stats = stats + "Max SP: " + character.base_sp + "<br>";
        stats = stats + "Current SP: " + character.sp + "<br>";
        stats = stats + "Damage: " + character.base_damage_infliction + "<br>";
        stats = stats + "Attack Speed: " + character.attack_speed + "<br>";
        stats = stats + "<br></html>";
        return stats;


    }

 

}
