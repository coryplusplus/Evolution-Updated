package ai;


import java.util.Timer;
import java.util.TimerTask;

import ui.UI;
import area.Area;
import character.Character;
public class AI

{

 

    public  Area currentArea;


    public String description;

    public int type;

    public int hp;
    
    public int sp;

    public int base_hp;

    public int base_sp;

    public int attack_speed;

    public int base_damage_infliction;

    public Character currentTarget;

    public Character character;

    public boolean dead;

    public Timer attackTimer;

    public boolean fighting;

   

    public void Greeting()

    {

     

    }

   

    public void moveToArea(Area targetArea)

    {

     if(currentArea != targetArea && !fighting &&!dead)

     {

            currentArea.ai.remove(this);

            currentArea.aiTypeMap.remove(type);

            if(currentArea.containsCharacter)

            {

            	UI.addToCombatLog(description + " has left the area");
             UI.addCharacters();

            }

            currentArea = targetArea;
            

            currentArea.ai.add(this);

            currentArea.aiTypeMap.put(type,this);
            

            if(targetArea.containsCharacter)

            {

            	UI.addToCombatLog(description + " has entered the area");

             Greeting();
             UI.addCharacters();

            }

     }

       

 

 

    }

 

    public AI(Area startingArea, Character main_character)

    {
   

        character = main_character;      
  
        currentArea = startingArea;

        currentArea.ai.add(this);

        dead = false;

        fighting = false;

        base_damage_infliction = 3;

        attack_speed = 2;

        hp = 50;
        
        sp = 15;

        base_hp = 50;

        base_sp = 15;

    }

    public AI()
    {
        dead = false;
    }

    public void Attack()
    {
            attackTimer = new Timer();
            attackTimer.schedule(new AttackTask(), attack_speed*1000);
    }

    class AttackTask extends TimerTask 
    {
        public void run()
        {
            if(dead || currentTarget.dead)
            {
            	currentTarget.attackTimer.cancel();
                attackTimer.cancel(); //Terminate the timer thread
                fighting = false;
            }
            else
            {
            	UI.flashRed();
                fighting = true;
                UI.addToCombatLog(description + " hits back doing damage!"); 
                currentTarget.hp = currentTarget.hp - base_damage_infliction;
                UI.addToCombatLog("HP " + currentTarget.hp + " Fighting: " + description + " HP " + hp);
                if(currentTarget.hp < 0)
                {
                    currentTarget.dead = true;
                    UI.addToCombatLog("You have been killed!!!");
                    System.exit(0);
                    fighting = false;
                }
                Attack();
            }
        }
    }

   
 

}