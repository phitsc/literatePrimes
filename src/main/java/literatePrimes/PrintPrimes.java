package literatePrimes;

public class PrintPrimes {
	private final GeneratePrimes generatePrimes;
	private static final int numberOfRowsOutputPerPage = 50;
	private static final int numberOfColumnsOutput = 4;
	private int[] primes;
	private int nofPrimes;

	public PrintPrimes() {
		generatePrimes = new GeneratePrimes();
	}

	public void invoke() {
		initialise();
		printPrimes();
	}

	private void initialise() {
		primes = generatePrimes.invoke();
		nofPrimes = primes.length - 1;
	}

	private void printPrimes() {
		for(int pageOffset = 1, pageNumber = 1; pageOffset <= nofPrimes;
			pageOffset += numberOfRowsOutputPerPage * numberOfColumnsOutput, pageNumber++) {
			pageHeader(pageNumber);
			pageBody(pageOffset);
			pageFooter();
		}
	}

	private void pageHeader(int pageNumber) {
		System.out.println("The First " + nofPrimes + " Prime Numbers --- Page " + pageNumber);
		System.out.println();
	}

	private void pageBody(int pageOffset) {
		for (int rowOffset = pageOffset; rowOffset < pageOffset + numberOfRowsOutputPerPage; rowOffset++) {
			for (int column = 0; column < numberOfColumnsOutput; column++)
				if (rowOffset + column * numberOfRowsOutputPerPage <= nofPrimes)
					System.out.format("%10d", primes[rowOffset + column * numberOfRowsOutputPerPage]);
			System.out.println();
		}
	}

	private void pageFooter() {
		System.out.println("\f");
	}
}