package uk.dangrew.bingowall.resources.sounds.numbers;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import uk.dangrew.bingowall.ProjectReferencePoint;
public class Sounds {

   private static final String RESOURCE_LOCATION = "resources/sounds/numbers/";
   
   public void playSound( int number ) {
      try {
         AudioPlayer.player.start( new AudioStream( 
               ProjectReferencePoint.class.getResourceAsStream( 
                        RESOURCE_LOCATION + number + ".wav"
               ) 
         ) );
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
   
}
