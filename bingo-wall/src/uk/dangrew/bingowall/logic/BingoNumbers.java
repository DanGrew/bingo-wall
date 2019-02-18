package uk.dangrew.bingowall.logic;

import java.util.HashMap;
import java.util.Map;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class BingoNumbers {

   private final int totalBingoNumbers;
   private final Map< Integer, BooleanProperty > numbersState;
   
   public BingoNumbers( int totalBingoNumbers ) {
      this.totalBingoNumbers = totalBingoNumbers;
      this.numbersState = new HashMap<>();
      for ( int i = 1; i < totalBingoNumbers + 1; i++ ) {
         this.numbersState.put( i, new SimpleBooleanProperty( false ) );
      }
   }//End Constructor
   
   public int getBingoNumberCount(){
      return totalBingoNumbers;
   }//End Method
   
   public BooleanProperty numberStateFor( int number ) {
      return numbersState.get( number );
   }//End Method
   
}//End Class
