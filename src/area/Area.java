package area;


import java.util.HashMap;
import java.util.Vector;

import constants.Constants;

import ai.AI;

public class Area {

	 

	 

    public int areaID;

 

    public int paths;

 

    public HashMap<Integer, Area>  areaMap;

 

    public String description;

   

    public Vector<AI> ai;

    public HashMap<Integer, AI> aiTypeMap;

   

    public boolean containsCharacter;

 

    public Area(String areaDescription, int id)

    {

 

        areaMap = new HashMap<Integer, Area>();

        aiTypeMap = new HashMap<Integer, AI>();

        description = areaDescription;

        areaID = id;

        ai = new Vector<AI>();

        containsCharacter = false;

 

    }


    public boolean GetAI(String name, AI ai)
    {
        /*/ uncomment if you wanna know what you can kill
        for (Map.Entry<Integer, AI> entry : aiTypeMap.entrySet())
        {
            Integer key = entry.getKey();
            AI value = entry.getValue();
            System.out.println("AI: " + key);
            System.out.println(value.description);
            //use key and value
        }/*/
        if(name.equals(Constants.FOX_STRING))
        {
            ai = aiTypeMap.get(Constants.FOX);
            if(ai !=  null)return true;
        }
        if(name.equals(Constants.RABBIT_STRING))
        {
            ai = aiTypeMap.get(Constants.RABBIT);
            if(ai !=  null)return true;
        }
        if(name.equals(Constants.UNICORN_STRING))
        {
            ai = aiTypeMap.get(Constants.UNICORN);
            if(ai !=  null)return true;
        }
        if(name.equals(Constants.HOUND_STRING))
        {
            ai = aiTypeMap.get(Constants.HOUND);
            if(ai !=  null)return true;
        }
        if(name.equals(Constants.PENGUIN_STRING))
        {
            ai = aiTypeMap.get(Constants.PENGUIN);
            if(ai !=  null)return true;
        }

        return false;


    }

    public AI GetAIObject(String name, AI ai)
    {
        /*/ uncomment if you wanna know what you can kill
        for (Map.Entry<Integer, AI> entry : aiTypeMap.entrySet())
        {
            Integer key = entry.getKey();
            AI value = entry.getValue();
            System.out.println("AI: " + key);
            System.out.println(value.description);
            //use key and value
        }/*/
        if(name.equals(Constants.FOX_STRING))
        {
            ai = aiTypeMap.get(Constants.FOX);
            if(ai !=  null)return ai;
        }
        if(name.equals(Constants.RABBIT_STRING))
        {
            ai = aiTypeMap.get(Constants.RABBIT);
            if(ai !=  null)return ai;
        }
        if(name.equals(Constants.UNICORN_STRING))
        {
            ai = aiTypeMap.get(Constants.UNICORN);
            if(ai !=  null)return ai;
        }
        if(name.equals(Constants.HOUND_STRING))
        {
            ai = aiTypeMap.get(Constants.HOUND);
            if(ai !=  null)return ai;
        }
        if(name.equals(Constants.PENGUIN_STRING))
        {
            ai = aiTypeMap.get(Constants.PENGUIN);
            if(ai !=  null)return ai;
        }

        return ai;


    }



}