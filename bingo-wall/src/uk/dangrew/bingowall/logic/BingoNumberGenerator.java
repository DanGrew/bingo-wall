package uk.dangrew.bingowall.logic;

import java.security.SecureRandom;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import uk.dangrew.bingowall.model.BingoSettings;
import uk.dangrew.bingowall.resources.sounds.numbers.Sounds;

public class BingoNumberGenerator {

   private final Sounds sounds;
   private final BingoNumbers numbers;
   private final BingoSettings settings;
   private final ObjectProperty< Integer > nextCall;
   
   public BingoNumberGenerator( BingoSettings settings, BingoNumbers numbers ) {
      this.settings = settings;
      this.nextCall = new SimpleObjectProperty<>();
      this.numbers = numbers;
      this.sounds = new Sounds();
   }//End Constructor
   
   public ObjectProperty< Integer > nextCall(){
      return nextCall;
   }//End Method
   
   public void start() {
      new Thread( () -> {
         SecureRandom random = new SecureRandom();
         while ( true ) {
            try {
               Thread.sleep( settings.callTime().get().timePeriod() );
            } catch ( InterruptedException e ) {
               e.printStackTrace();
            }
            if ( settings.paused().get() ) {
               continue;
            }
            
            boolean foundNew = false;
            while( !foundNew ) {
               int number = random.nextInt( numbers.getBingoNumberCount() ) + 1;
               BooleanProperty state = numbers.numberStateFor( number );
               if ( !state.get() ) {
                  nextCall.set( number );
                  sounds.playSound( number );
                  state.set( true );
                  foundNew = true;
               }
            }
         }
      } ).start();
   }//End Constructor

   
}//End Class
