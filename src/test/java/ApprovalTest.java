import literatePrimes.PrintPrimes;
import org.approvaltests.Approvals;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ApprovalTest {

	private PrintPrimes printPrimes;

	@Before
	public void setUp() throws Exception {
		printPrimes = new PrintPrimes();
	}

	@Test
	public void approveOutPut_PrintPrimes() {
		String output = getOutput();
		Approvals.verify(output);
	}

	private String getOutput() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		PrintStream old = System.out;
		System.setOut(ps);

		printPrimes.main(new String[0]);

		System.out.flush();
		System.setOut(old);
		return baos.toString();
	}
}
