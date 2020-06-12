package literatePrimes;

public class GeneratePrimes {

	private static final int numberOfPrimesToCreate = 1000;
	private static final int maxOrder = 30;
	private final int[] multiples;
	private int order;
	private int squareNumber;
	private int[] primes;

	public GeneratePrimes() {
		multiples = new int[maxOrder + 1];
		order = 2;
		squareNumber = 9;
	}

	public int[] invoke() {
		initialise();
		for(int i = 3; i <= numberOfPrimesToCreate; i++) {
			primes[i] = generateNextPrimeNumber(primes[i - 1]);
		}
		return primes;
	}

	private void initialise() {
		primes = new int[numberOfPrimesToCreate + 1];
		primes[1] = 2;
		primes[2] = 3;
	}

	private int generateNextPrimeNumber(int lastPrimeFound) {
		int primeCandidate = lastPrimeFound;
		do {
			primeCandidate += 2;
			updateMultiples(primeCandidate);
		} while (!isCandidatePrime(primeCandidate));
		return primeCandidate;
	}

	private void updateMultiples(int primeCandidate) {
		if (primeCandidate == squareNumber) {
			order = order + 1;
			squareNumber = primes[order] * primes[order];
			multiples[order - 1] = primeCandidate;
		}
	}

	private boolean isCandidatePrime(int primeCandidate) {
		int N = 2;
		while (N < order) {
			while (multiples[N] < primeCandidate)
				multiples[N] = multiples[N] + primes[N] + primes[N];
			if (multiples[N] == primeCandidate)
				return false;
			N++;
		}
		return true;
	}
}