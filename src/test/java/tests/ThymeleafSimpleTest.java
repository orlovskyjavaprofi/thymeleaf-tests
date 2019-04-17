package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.testing.templateengine.engine.TestExecutor;
import main.ApplicationStarter;

@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = ApplicationStarter.class)
public class ThymeleafSimpleTest {

	private TestExecutor executor;
	String file;
	String path;
	String pathcustom;
	
	@BeforeEach
	public void setUP() {
		executor = new TestExecutor() ;
		path =System.getProperty("user.dir");
		pathcustom = "\\src\\test\\resources\\firsttest\\";
		file = "onetest.thtest";
	}

	@AfterEach
	public void cleanUp() {
		executor.getReporter().reset();
	}

	@Test
	public void simpleTest() {
		//System.out.println("\n"+path+pathcustom+file+"\n");
		executor.execute("file:"+path+pathcustom+file);
		assertTrue(executor.getReporter().isAllOK());
	}

}
