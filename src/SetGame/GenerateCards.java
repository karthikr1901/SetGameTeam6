/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetGame;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class GenerateCards {
	String[]shading ={"solid","striped","outline"};
	String[]symbols={"squiggle","diamond","oval"};
	String[]color={"red","purple","green"};
	String [] number={"1","2","3"};
	List<Card> l=new ArrayList<Card>();
	List<Card> table=new ArrayList<Card>();
	List<setItem> goodset=new ArrayList<setItem>();
	List<setItem> userSI= new ArrayList<setItem>();

//	Method to generate cards: total 81 cards
	public void generateCard(){
		for(int i=0;i<3;i++){
			String cShading=shading[i];
			for(int k=0;k<3;k++){
				String cSymbols=symbols[k];
				for(int n=0;n<3;n++){
					String cColor=color[n];
					for(int m=0;m<3;m++){
						String cNumber=number[m];
//                      This output is for testing
//                      System.out.println(z + ". "+cShading+cSymbols+cColor+cNumber); z++;
						//This one is for store the String info into l 
						//String s= cShading+cSymbols+cColor+cNumber;
						Card a =new Card(cShading,cSymbols,cColor,cNumber);
						l.add(a);                    
					}

				}                  
			}			
		}//		
	}

        public void shuffle()
        {
            //Shuffle the Deck of cards
		Collections.shuffle(l);
        }

//	Find the number of set present in the table
	public void verifyTable(){
		
		boolean color=false;
		boolean shading=false;
		boolean symbols=false;
		boolean number=false;
		boolean gameSet=false;
		for(int i=0;i<12;i++){
			for(int k=i+1;k<12;k++){
			    for(int m=k+1;m<12;m++){
			    	if(table.get(i).getColor()!=table.get(k).getColor() && 
			    	   table.get(k).getColor()!=table.get(m).getColor()	
			    	   &&table.get(m).getColor()!=table.get(i).getColor()
			    	  )
			    	{
			    		color=true;
			    		
		    		}
			        else if(table.get(i).getColor()==table.get(k).getColor() && 
					    	   table.get(k).getColor()==table.get(m).getColor()	
					    	   &&table.get(m).getColor()==table.get(i).getColor())
			        {
			        	color=true;
			        }
			    	
			    	 if(table.get(i).getShading()!=table.get(k).getShading() && 
					    	   table.get(k).getShading()!=table.get(m).getShading()	
					    	   &&table.get(m).getShading()!=table.get(i).getShading()){shading=true;}
			    	
			        else if(table.get(i).getShading()==table.get(k).getShading() && 
					    	   table.get(k).getShading()==table.get(m).getShading()	
					    	   &&table.get(m).getShading()==table.get(i).getShading()){shading=true;}
			    	
			        if(table.get(i).getSymbols()!=table.get(k).getSymbols() && 
					    	   table.get(k).getSymbols()!=table.get(m).getSymbols()	
					    	   &&table.get(m).getSymbols()!=table.get(i).getSymbols()){symbols=true;}
			    	
			        else if(table.get(i).getSymbols()==table.get(k).getSymbols() && 
					    	   table.get(k).getSymbols()==table.get(m).getSymbols()	
					    	   &&table.get(m).getSymbols()==table.get(i).getSymbols()){symbols=true;}
			       
			        if(table.get(i).getNumber()!=table.get(k).getNumber() && 
					    	   table.get(k).getNumber()!=table.get(m).getNumber()	
					    	   &&table.get(m).getNumber()!=table.get(i).getNumber()){number=true;}
			       
			        else if(table.get(i).getNumber()==table.get(k).getNumber() && 
					    	   table.get(k).getNumber()==table.get(m).getNumber()	
					    	   &&table.get(m).getNumber()==table.get(i).getNumber()){number=true;}
			    	
    	
			    	if(color== true && shading== true && symbols== true && number==true){
			    		
			    		setItem s=new setItem(table.get(i),table.get(k),table.get(m));
			    		goodset.add(s);
			    		System.out.println((i+1)+" "+table.get(i).toString()+"  "+(k+1)+"  "+table.get(k).toString()+"  "+(m+1)+"  "+table.get(m).toString());
			    		
			    	}
			    	color=false;shading=false;symbols=false;number=false;
			    }		
			}
		}
	}
	
//	Create a table with 12 cards (first of 12 shuffles)
	public void initialtable(){
//		Moving the cards from the deck to the table
		for(int i=0;i<12;i++){
			table.add(l.get(i));
//			Remove 12 cards from the Deck
			l.remove(i);
		}
	}
        
        public void initialtable2(int x,int y,int z){
//		Moving the cards from the deck to the table
		int i=0;
			table.add(x,l.get(i));
                        table.remove(x+1);
			l.remove(i);table.add(y,l.get(i+1));
                        table.remove(y+1);
			l.remove(i+1);table.add(z,l.get(i+2));
                        table.remove(z+1);
			l.remove(i+2);
		
	}

        public void display(){
//		Moving the cards from the deck to the table
		for(int i=0;i<12;i++){
			System.out.print((i+1)+" "+table.get(i)+"\t\t\t\t");
                        if((i+5)%4 == 0)
			System.out.print("\n");                            
		}
	}
	
        public void check()
        {
            shuffle();
            initialtable();    
            while(!(l.isEmpty()))
            {
            verifyTable();
            while(goodset.isEmpty())
            {
                add();
                shuffle();
                initialtable();
                verifyTable();
            }
            display(); 
            getdetails();
            goodset.clear();
            }
            System.out.println("Game over");
        }
        
        public void add()
        {
            for(int i=0;i<12;i++){
			l.add(table.get(0));
//			Remove 12 cards from the Deck
			table.remove(0);
            }
        }
        public void getdetails()
        {
            int[] i = new int[3];
            System.out.println("Enter Card numbers:");
            Scanner user_input = new Scanner( System.in );
            System.out.println("Enter 1st Card number:");
            i[0] = user_input.nextInt();
            System.out.println("Enter 2nd Card number:");
            i[1] = user_input.nextInt();
            System.out.println("Enter 3rd Card number:");
            i[2] = user_input.nextInt();
            Arrays.sort(i);
            setItem s=new setItem(table.get(i[0]-1),table.get(i[1]-1),table.get(i[2]-1));
            int value = verifyUserSelection(s);
            if(value == 1)
            {
                System.out.println("One set found");
                initialtable2((i[0]-1),(i[1]-1),(i[2]-1));    
            }
            else
                System.out.println("No sets found");
        }
        
//  To check the user selection with the set present in the 12 cards on table
	public int verifyUserSelection(setItem si){
		Iterator<setItem> it1 = goodset.iterator();
		while(it1.hasNext()){
			if( it1.next().compareTo(si)==1){
				userSI.add(si);
				return 1;
			}
		}
		return 0;
	}	
}

