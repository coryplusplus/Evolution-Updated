package utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import constants.Constants;

import ai.AI;
import area.Area;

import ui.UI;
import character.Character;

public class IOUtils

{

 

 

    public static BufferedReader reader;

 

 

   

    public IOUtils()

    {

        reader = new BufferedReader(new InputStreamReader(System.in));

    }

 

    public String getCommand()

    {

    	UI.addToCombatLog("What would you like to do:");

        return getLine();

 

    }

 

    public static String getLine()

    {

        String line = new String();

        try

        {

            line = reader.readLine();

        }

        catch (IOException ioe)

        {

            //statement to execute if an input/output exception occurs

        	UI.addToCombatLog("An unexpected error occured.");

        }

        return line;

    }

 

 

    public boolean isNorth(String command)

    {

        if(command.equals("n") || command.equals("N") ||

            command.equals("North") || command .equals("north"))

            return true;

        else

            return false;

    }

 

    public boolean isSouth(String command)

    {

        if(command.equals("s") || command.equals("S") ||

            command.equals("South") || command.equals("south"))

            return true;

        else

            return false;

 

 

    }

 

    public boolean isEast(String command)

    {

 

        if(command.equals("e") || command.equals("E") ||

            command.equals("East") || command.equals("east"))

            return true;

        else

            return false;

 

    }

 

    public boolean isWest(String command)

    {

 

        if(command.equals("w") || command.equals("W") ||

            command.equals("West") || command.equals("west"))

            return true;

        else

            return false;

 

    }

 

    public boolean isDance(String command)

    {

        if(command.equals("dance") || command.equals("Dance") ||

                command.equals("DANCE"))

                return true;

            else

                return false;

    }

   

    public void HandleDance()

    {

    	UI.addToCombatLog("You dance like no one is watching");

    	UI.addToCombatLog("\n");

    }

   

    public boolean isSing(String command)

    {

        if(command.equals("sing") || command.equals("Sing") ||

                command.equals("SING"))

                return true;

            else

                return false;

    }

   

    public void HandleSing()

    {

    	UI.addToCombatLog("You sing with the voice of a thousand angels");

    	UI.addToCombatLog("\n");

    }

   

    public boolean isSit(String command)

    {

        if(command.equals("sit") || command.equals("Sit") ||

                command.equals("SIT"))

                return true;

            else

                return false;

    }

    public void HandleSit()

    {

    	UI.addToCombatLog("You sit that fine ass down");

    	UI.addToCombatLog("\n");

    }

    
    public boolean isKill(String command)

    {
 
        String subString = command.substring(0,4);


        if(subString.equals("kill") || subString.equals("Kill") ||

                subString.equals("KILL"))

                return true;

            else

                return false;

    }

   

    public static void HandleKill(Character character, String command)

    {

        String subString = command.substring(5);   
        AI ai = new AI();  

        if(character.currentArea.GetAI(subString, ai))
        {
        	UI.addToCombatLog("-------------------------FIGHT---------------------------");
            character.currentTarget = character.currentArea.GetAIObject(subString, ai);
            character.currentTarget.currentTarget = character;
            character.Attack();
            character.currentTarget.Attack();
             
        }
        else
        {
        	UI.addToCombatLog("This creature does not exist in this area!");
        }

    }

    public boolean isJump(String command)

    {

        if(command.equals("jump") || command.equals("Jump") ||

                command.equals("JUMP"))

                return true;

            else

                return false;

    }

   

    public static void HandleJump()

    {

    	UI.addToCombatLog("Hoppity hop hop");

    	UI.addToCombatLog("\n");

    }
    
    public boolean isHeal(String command)

    {

        if(command.equals("heal") || command.equals("Heal") ||

                command.equals("HEAL"))

                return true;

            else

                return false;

    }

   

    public static void HandleHeal(Character character)

    {

         if(character.sp < 3)
        	 UI.addToCombatLog("Not enough spell power");
         else
         {
             character.sp = character.sp - 3;
             if(character.hp + character.healIncrement > character.base_hp)
             {
            	 UI.addToCombatLog("You are at max health");
            	 character.hp = character.base_hp;
             }
             else
             {
             character.hp = character.hp + character.healIncrement;
             UI.addToCombatLog("Healing for " + character.healIncrement +" HP: " + character.hp);
             UI.updateStats();
             }
         }

    }

   

    public boolean isDirections(String command)

    {

        if(command.equals("directions") || command.equals("Directions") ||

                command.equals("DIRECTIONS"))

                return true;

            else

                return false;

    }

   

    public void HandleDirections(Area area)

    {

     DisplayUtils.printDirections(area);

    }

   

    public boolean isExit(String command)

    {

        if(command.equals("exit") || command.equals("Exit") ||

                command.equals("EXIT"))

                return true;

            else

                return false;

    }


   

    public void HandleExit()

    {

        System.exit(0);

    }

    public boolean isPossess(String command)

    {

        if(command.equals("possess") || command.equals("Possess") ||

                command.equals("POSSESS"))
        {
                return true;
        }

            else

                return false;

    }

    public void HandlePossess(Character character)
    {
        if(character.canPossess)
        {
            character.Possess(character.currentTarget);
        }
        else
        {
        	UI.addToCombatLog("Cannot currently possess.");
        }
        character.canPossess = false;
    }

    public boolean isDontPossess(String command)
    {
        if(command.equals("don't possess") || command.equals("Don't Possess") ||

                command.equals("DON'T POSSESS"))
        {
                return true;
        }

            else

                return false;
        
    }

    public void HandleDontPossess(Character character)
    {
        character.currentArea.aiTypeMap.remove(character.currentTarget.type);
        character.currentArea.ai.remove(character.currentTarget);
        character.canPossess = false;
    }


    public boolean isStats(String command)

    {

        if(command.equals("stats") || command.equals("Stats") ||

                command.equals("STATS"))

                return true;

            else

                return false;

    }

    public void HandleStats(Character character)
    {
        DisplayUtils.printStats(character);
    }

   
   

    //Is this a possible path?

    public boolean isCommandValid(Character character, String command)

    {

     

        if(command.length() > 4 && isKill(command))
        {  
            HandleKill(character, command);
            return true;
        }
        if(isPossess(command))
        {
            HandlePossess(character);
            return true;
        }
        if(isDontPossess(command))
        {
            HandleDontPossess(character);
            return true;
        }
        if(isJump(command))

        {

         HandleJump();

         return true;

        }

        if(isSit(command))

        {

         HandleSit();

         return true;

        }

        if(isSing(command))

        {

         HandleSing();

         return true;

        }

        if(isDance(command))

        {

         HandleDance();

         return true;

        }

        if(isDirections(command))

        {

         HandleDirections(character.currentArea);

         return true;

        }

        if(isExit(command))

        {

         HandleExit();

         return true;

        }
        
        if(isHeal(command))

        {

         HandleHeal(character);

         return true;

        }

        if(isStats(command))

        {

         HandleStats(character);

         return true;

        }

       

        switch(character.currentArea.paths)

        {

        case Constants.North:

            if(isNorth(command))

                return true;

            else

                return false;

        case Constants.South:

            if(isSouth(command))

                return true;

            else

                return false;

        case Constants.East:

            if(isEast(command))

                return true;

            else

                return false;

        case Constants.West:

            if(isWest(command))

                return true;

            else

                return false;

 

        case Constants.NorthAndSouth:

            if(isNorth(command) || isSouth(command))

                return true;

            else

                return false;

        case Constants.NorthAndEast:

            if(isNorth(command) || isEast(command))

                return true;

            else

                return false;

        case Constants.NorthAndWest:

            if(isNorth(command) || isWest(command))

                return true;

            else

                return false;

        case Constants.SouthAndEast:

            if(isSouth(command) || isEast(command))

                return true;

            else

                return false;

        case Constants.SouthAndWest:

            if(isSouth(command) || isWest(command))

                return true;

            else

                return false;

        case Constants.EastAndWest:

            if(isEast(command) || isWest(command))

                return true;

            else

                return false;

 

        case Constants.NorthSouthAndEast:

            if(isNorth(command) || isSouth(command) || isEast(command))

                return true;

            else

                return false;

        case Constants.NorthSouthAndWest:

            if(isNorth(command) || isSouth(command) || isWest(command))

                return true;

            else

                return false;

        case Constants.NorthEastAndWest:

            if(isNorth(command) || isEast(command) || isWest(command))

                return true;

            else

                return false;

        case Constants.SouthEastAndWest:

            if(isSouth(command) || isEast(command) || isWest(command))

                return true;

            else

                return false;

 

        case Constants.NorthSouthEastAndWest:

            if(isNorth(command) || isSouth(command) || isWest(command) || isEast(command))

                return true;

            else

                return false;

         default:

         break;

         

        }

 
        character.canPossess = false;
        return false;

 

    }

 
    //area is the area we are currently in

    public Area enterCommand(Character character)

    {

        String command = getCommand();

 

        while(!isCommandValid(character,command))

        {

        	UI.addToCombatLog("Command not recognized");

            DisplayUtils.printDirections(character.currentArea);

            UI.addToCombatLog("\n");

            command = getCommand();

        }

       

      

 

 

        if(isNorth(command))

            return character.currentArea.areaMap.get(Constants.North);

 

        if(isSouth(command))

            return character.currentArea.areaMap.get(Constants.South);

 

        if(isEast(command))

            return character.currentArea.areaMap.get(Constants.East);

 

        if(isWest(command))

            return character.currentArea.areaMap.get(Constants.West);

 

        return character.currentArea;

    }

 

}