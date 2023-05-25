package main;

import java.util.ArrayList;

import entity.Entity;

public class Subject_Time {
	private ArrayList<Entity> observers ;
	private GamePanel gp;
	private boolean red = false;
		public Subject_Time(GamePanel gp) {
			this.gp = gp;
			this.observers= new ArrayList<Entity>();
		}
		   public boolean getState() {
		      return red;
		   }		  
		   public void setState(boolean state) {
		      this.red = state;
		      notifyAllObservers();
		   }
		   public void attach(Entity observer){
		      observers.add(observer);		
		      }		   
		   public void Detach(Entity observer) {
			   observers.remove(observer);
		   }
		   public void notifyAllObservers(){
		      for (Entity observer : observers ) {
		    	  if(observer.getalive() == true &&observer.getwin() == false) {
		    		  observer.update();	    		  
		    	  }
		        
		      }
		   } 	
		
}
