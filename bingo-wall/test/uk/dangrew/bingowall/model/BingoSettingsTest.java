package uk.dangrew.bingowall.model;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.kode.launch.TestApplication;

public class BingoSettingsTest {

   private BingoSettings systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      systemUnderTest = new BingoSettings();
   }//End Method

   @Test public void shouldProvideDefaults() {
      assertThat( systemUnderTest.callTime().get(), is( BingoSpeed.FiveSeconds ) );
      assertThat( systemUnderTest.paused().get(), is( true ) );
   }//End Method

}//End Class