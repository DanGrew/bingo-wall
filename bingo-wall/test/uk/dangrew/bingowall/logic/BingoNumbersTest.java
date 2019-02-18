package uk.dangrew.bingowall.logic;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import javafx.beans.property.BooleanProperty;
import uk.dangrew.kode.launch.TestApplication;

public class BingoNumbersTest {

   private BingoNumbers systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      systemUnderTest = new BingoNumbers( 5 );
   }//End Method

   @Test public void shouldContainEnoughNumbers() {
      assertThat( systemUnderTest.numberStateFor( 0 ), is( nullValue() ) );
      for ( int i = 1; i < 5; i++ ) {
         assertThat( systemUnderTest.numberStateFor( i ), is( instanceOf( BooleanProperty.class ) ) );   
      }
      assertThat( systemUnderTest.numberStateFor( 5 ), is( instanceOf( BooleanProperty.class ) ) );
      assertThat( systemUnderTest.numberStateFor( 6 ), is( nullValue() ) );
   }//End Method
   
   @Test public void shouldProvideSingleProperty(){
      for ( int i = 1; i <= 5; i++ ) {
         assertThat( systemUnderTest.numberStateFor( i ), is( systemUnderTest.numberStateFor( i ) ) );   
      }
   }//End Method
   
   @Test public void shouldProvideCount(){
      assertThat( systemUnderTest.getBingoNumberCount(), is( 5 ) );
   }//End Method

}//End Class
