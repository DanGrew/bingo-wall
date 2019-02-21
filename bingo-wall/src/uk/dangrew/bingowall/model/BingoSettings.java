package uk.dangrew.bingowall.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class BingoSettings {

   private final ObjectProperty< BingoSpeed > callTime;
   private final ObjectProperty< Boolean > paused;
   
   public BingoSettings() {
      this.callTime = new SimpleObjectProperty<>( BingoSpeed.FiveSeconds );
      this.paused = new SimpleObjectProperty<>( true );
   }//End Constructor
   
   public ObjectProperty< BingoSpeed > callTime() {
      return callTime;
   }//End Method
   
   public ObjectProperty< Boolean > paused() {
      return paused;
   }//End Method

}//End Class
