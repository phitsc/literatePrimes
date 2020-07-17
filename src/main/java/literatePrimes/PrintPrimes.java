package literatePrimes;

import java.util.ArrayList;
import java.util.List;

public class PrintPrimes {

	private static List<Integer> calculatePrimes(int numberOfPrimes, int ORDMAX) {
		var primes = new ArrayList<Integer>(List.of( -1, 2 ));

		boolean JPRIME;
		int MULT[] = new int[ORDMAX + 1];

		int J = 1;
		int ORD = 2;
		int SQUARE = 9;

		while (primes.size() <= numberOfPrimes) {
			do {
				J = J + 2;
				if (J == SQUARE) {
					ORD = ORD + 1;
					SQUARE = primes.get(ORD) * primes.get(ORD);
					MULT[ORD - 1] = J;
				}
				int N = 2;
				JPRIME = true;
				while (N < ORD && JPRIME) {
					while (MULT[N] < J)
						MULT[N] = MULT[N] + primes.get(N) + primes.get(N);
					if (MULT[N] == J)
						JPRIME = false;
					N = N + 1;
				}
			} while (!JPRIME);
			primes.add(J);
		}

		return primes;
	}

	private static void printPrimes(List<Integer> primes, int numberOfPrimes, int numberOfRows, int numberOfColumns) {
		int pageNumber = 1;
		int pageOffset = 1;

		while (pageOffset <= numberOfPrimes) {
			System.out.println("The First " + numberOfPrimes +
                                 " Prime Numbers --- Page " + pageNumber);
			System.out.println("");

			for (int rowOffset = pageOffset; rowOffset < pageOffset + numberOfRows; rowOffset++) {
				for (int C = 0; C < numberOfColumns; C++) {
					if (rowOffset + C * numberOfRows <= numberOfPrimes) {
						System.out.format("% 10d", primes.get(rowOffset + C * numberOfRows));
          }
        }

				System.out.println("");
			}

			System.out.println("\f");

			pageNumber = pageNumber + 1;
			pageOffset = pageOffset + numberOfRows * numberOfColumns;
		}

	}

	public static void main(String[] args) {
		final int NumberOfPrimes = 1000;
		final int NumberOfRows = 50;
		final int NumberOfColumns = 4;
		final int ORDMAX = 30;

		var primes = calculatePrimes(NumberOfPrimes, ORDMAX);
		printPrimes(primes, NumberOfPrimes, NumberOfRows, NumberOfColumns);
	}
}
