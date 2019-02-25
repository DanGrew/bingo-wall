package uk.dangrew.bingowall.ui;

import com.sun.javafx.application.PlatformImpl;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import uk.dangrew.bingowall.logic.BingoNumberGenerator;
import uk.dangrew.bingowall.model.BingoSettings;
import uk.dangrew.kode.javafx.style.JavaFxStyle;

public class UiCallDisplay extends BorderPane {

   private final BingoSettings settings;
   private final Label nextCall;
   private final Label speedLabel;
   
   public UiCallDisplay( BingoSettings settings, BingoNumberGenerator numberGenerator ) {
      this.settings = settings;
      
      this.nextCall = new Label( "??" );
      this.nextCall.setAlignment( Pos.CENTER );
      this.nextCall.setBackground( new JavaFxStyle().backgroundFor( Color.YELLOW ) );
      this.nextCall.setBorder( new JavaFxStyle().borderFor( Color.BLACK ) );
      this.nextCall.setMaxSize( Double.MAX_VALUE, Double.MAX_VALUE );
      this.nextCall.setFont( Font.font( 80 ) );
      numberGenerator.nextCall().addListener( ( s, o, n ) -> {
         PlatformImpl.runAndWait( () -> nextCall.setText( Integer.toString( n ) ) );  
      } );
      this.setCenter( nextCall );
      
      this.speedLabel = new JavaFxStyle().createBoldLabel( settings.callTime().get().displayName() );
      this.speedLabel.setTextAlignment( TextAlignment.CENTER );
      this.speedLabel.setAlignment( Pos.CENTER );
      this.speedLabel.setMaxWidth( Double.MAX_VALUE );
      this.setBottom( speedLabel );
      this.settings.callTime().addListener( ( s, o, n ) -> updateSpeed() );
   }//End Constructor
   
   private void updateSpeed(){
      this.speedLabel.setText( settings.callTime().get().displayName() );
   }//End Method
   
}//End Class
