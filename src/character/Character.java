package character;
import java.util.Timer;
import java.util.TimerTask;

import ui.UI;
import utils.DisplayUtils;
import ai.AI;
import area.Area;
import constants.Constants;

public class Character

{


    public  Area currentArea;


    public int level;

    public int hp;
    public int base_hp;
    
    public int base_sp;
    public int sp;

    public int attack_speed;

    public int base_damage_infliction;

    public AI currentTarget;

    public boolean dead;

    public boolean fighting;

    public Timer attackTimer;
    
    public Timer soulTimer;
    
    public Timer spellPowerTimer;
    
    public int  spRegenerationRate = 8;
    
    public int spRegenerationInc = 3;

    public String possessed;

    public boolean canPossess = false;
    
    public int healIncrement = 5;

    public void moveToArea(Area targetArea)

    {

 
        if(targetArea.areaID == 3)
        {
        	if(possessed.equals("A " + Constants.RABBIT_STRING))
            {
        		move(targetArea);
        	}
        	else
        	{
        		UI.addToCombatLog("You cannot take this path in your current form");
        	}
        }

        else
        {
        	move(targetArea);
        }
        UI.updateButtons();

 

    }
    
    public void move(Area targetArea)
    {
        currentArea.containsCharacter = false;

        currentArea = targetArea;

        DisplayUtils.printInitialAreaText(currentArea);

        currentArea.containsCharacter = true;
        

    }

 

    public Character(Area startingArea)

    {
      

        currentArea = startingArea;

        DisplayUtils.printInitialAreaText(startingArea);

        startingArea.containsCharacter = true;

        level = 1;

        hp = 100;
        
        base_hp = 100;
        
        sp = 20;
        
        base_sp = 20;

        attack_speed = 3;

        base_damage_infliction = 8;

        currentTarget = null;

        dead = false;

        fighting = false;

        possessed = "none";

        canPossess = false;
        
        soulTimer = new Timer();

        soulTimer.schedule(new SoulTimer(), 1000 * 5);
        
        spellPowerTimer = new Timer();

        spellPowerTimer.schedule(new SpellPowerTimer(), 1000 * spRegenerationRate);

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
                fighting = false;
            	currentTarget.attackTimer.cancel();
                attackTimer.cancel(); //Terminate the timer thread

            }
            else
            {
                fighting = true;
                UI.addToCombatLog("You attack " + currentTarget.description + " with fury!"); 
                UI.addToCombatLog("HP " + hp + " Fighting: " + currentTarget.description + " HP " + currentTarget.hp);
                currentTarget.hp = currentTarget.hp - base_damage_infliction;
                UI.updateStats();
                if(currentTarget.hp < 0)
                {
                    currentTarget.dead = true;
                    UI.addToCombatLog("You have killed " + currentTarget.description);
                    canPossess = true;
                    fighting = false;
                    currentArea.aiTypeMap.remove(currentTarget.type);
                    currentArea.ai.remove(currentTarget);
                    if(UI.possessDialog())
                    {
                    	Possess(currentTarget);
                    }
                    UI.updateStats();
                    UI.addCharacters();
                }
                Attack();
            }
        }
    }
    
    class SoulTimer extends TimerTask {

        public void run() {

         if(possessed == "none")
         {
        	 UI.addToCombatLog("Your soul is damaged");
        	 hp = hp - 3;
        	 if(hp < 0)
        	 {
        		 UI.addToCombatLog("You have dissipated into the void");
        		 soulTimer.cancel();
        		 System.exit(0);
        	 }
        	 else
        	 {
        		 UI.addToCombatLog("HP " + hp);
                     UI.updateStats();
        	     soulTimer.schedule(new SoulTimer(), 1000* 5);
        	 }
         }
         else
        	 soulTimer.cancel();

        }

    }
    
    class SpellPowerTimer extends TimerTask {

        public void run() {

        	 int count =0;
             if(sp < base_sp)
             {
            	 while(sp <= base_sp && count<spRegenerationInc )
            	 {
            		 sp = sp + 1;
            		 count++;
                         UI.updateStats();
            	 }
             }
        	 spellPowerTimer.schedule(new SpellPowerTimer(), 1000* spRegenerationRate);


        }

    }


    public void Possess(AI ai)
    {
    	possessed = ai.description;
    	UI.addToCombatLog("You are now attempting to possess " + ai.description);
    	UI.addToCombatLog("Everything becomes black as you force the weight of your soul onto the lifeless corpse");
    	UI.addToCombatLog("Your HP has gone from " + hp + "->" + ai.base_hp);
    	UI.addToCombatLog("Your Attack Speed has gone from " + attack_speed + "->" + ai.attack_speed);
    	UI.addToCombatLog("Your base damage output has gone from " + base_damage_infliction + "->" + ai.base_damage_infliction);
    	UI.addToCombatLog("Congrats, you are now a " + ai.description + ". Your soul will survive for a little longer.");
        possessed = ai.description;
        hp = ai.base_hp;
        attack_speed = ai.attack_speed;
        base_damage_infliction = ai.base_damage_infliction;
        base_hp = ai.base_hp;
        base_sp = ai.base_sp;
        sp = ai.sp;
        UI.updateStats();
        canPossess = false;

    }

 

 

 

}
