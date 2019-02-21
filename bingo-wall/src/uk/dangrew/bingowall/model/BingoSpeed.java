package uk.dangrew.bingowall.model;

public enum BingoSpeed {

   OneSecond( "1 Sec", 1000 ),
   TwoSeconds( "2 Sec", 2000 ),
   ThreeSeconds( "3 Sec", 3000 ), 
   FourSeconds( "4 Sec", 4000 ),
   FiveSeconds( "5 Sec", 5000 );
   
   private final String displayName;
   private final int timePeriod;
   
   private BingoSpeed( String displayName, int timePeriod ) {
      this.displayName = displayName;
      this.timePeriod = timePeriod;
   }//End Constructor
   
   public String displayName(){
      return displayName;
   }//End Method
   
   public int timePeriod(){
      return timePeriod;
   }//End Method
   
   public BingoSpeed increase(){
      switch ( this ) {
         case FiveSeconds:
         case FourSeconds:
            return BingoSpeed.FiveSeconds;
         case ThreeSeconds:
            return BingoSpeed.FourSeconds;
         case TwoSeconds:
            return BingoSpeed.ThreeSeconds;
         case OneSecond:
            return BingoSpeed.TwoSeconds;
      }
      return this;
   }//End Method
   
   public BingoSpeed decrease(){
      switch ( this ) {
         case FiveSeconds:
            return BingoSpeed.FourSeconds;
         case FourSeconds:
            return BingoSpeed.ThreeSeconds;
         case ThreeSeconds:
            return BingoSpeed.TwoSeconds;
         case TwoSeconds:
         case OneSecond:
            return BingoSpeed.OneSecond;
      }
      return this;
   }//End Method
   
}//End Enum
