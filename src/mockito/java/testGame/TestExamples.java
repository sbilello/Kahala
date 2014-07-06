package testGame;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.test.model.KalahaGame;

public class TestExamples {
	
	@Test
	public void boardNotCreated() {
		KalahaGame mocked = mock(KalahaGame.class);
		when(mocked.getBoard()).thenThrow(new NullPointerException());
	}	

}