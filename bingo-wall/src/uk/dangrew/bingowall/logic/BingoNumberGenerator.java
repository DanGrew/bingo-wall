package uk.dangrew.bingowall.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

public class BingoNumberGenerator {

   private final BingoNumbers numbers;
   private final ObjectProperty< Integer > nextCall;
   private final BooleanProperty paused;
   
   public BingoNumberGenerator( BingoNumbers numbers ) {
      this.nextCall = new SimpleObjectProperty<>();
      this.numbers = numbers;
      this.paused = new SimpleBooleanProperty( false );
   }//End Constructor
   
   public ObjectProperty< Integer > nextCall(){
      return nextCall;
   }//End Method
   
   public void togglePause() {
      paused.set( !paused.get() );
   }//End Method
   
   public BooleanProperty paused() {
      return paused;
   }//End Method
   
   public void start() {
      new Thread( () -> {
         Random random = new Random();
         while ( true ) {
            try {
               Thread.sleep( 5000 );
            } catch ( InterruptedException e ) {
               e.printStackTrace();
            }
            if ( paused.get() ) {
               continue;
            }
            
            boolean foundNew = false;
            while( !foundNew ) {
               int number = random.nextInt( 90 ) + 1;
               BooleanProperty state = numbers.numberStateFor( number );
               if ( !state.get() ) {
                  nextCall.set( number );
                  state.set( true );
                  foundNew = true;
               }
            }
         }
      } ).start();
   }//End Constructor

   
}//End Class
