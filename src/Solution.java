import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	public static int uniqueWolfs(List<Integer> arr) {
		//girdilerin 1,2,3,4 veya 5 olacagi garanti edildiginden try-catch kullanilmadi
		
		// wolfID'lerin kac defa dizide kac defa gectigini tutan array olusturma ve sayilarin tespiti
		int wolfIdNumbers[] = { 0, 0, 0, 0, 0 };
		
		for (int i : arr) {
			wolfIdNumbers[i - 1]++; // 1 den basladigi icin num-1 indexine ekliyoruz
		}
		
		// En fazla tekrar eden en kucuk sayiyi bulma
		int maxFrequency  = 0;
		int resultWolfID = 0;
		
		for(int i = 0; i < 5; i++) {
			if(wolfIdNumbers[i] > maxFrequency ) {//eger bir sonraki wolfid tekrar sayisi bir oncekine esitse id si kucuk olani tutar 
				maxFrequency  = wolfIdNumbers[i];
				resultWolfID = i + 1; 
			}
		}
		
		/*
		for(int i : wolfIdNumbers) {
			if(i > maxFrequency ) {//eger bir sonraki wolfid tekrar sayisi bir oncekine esitse id si kucuk olani tutar 
				maxFrequency  = i;
			}
		}
		
		for (int i = 0; i < wolfIdNumbers.length; i++) {
            if (wolfIdNumbers[i] == maxFrequency ) {
                return i + 1;  // girdiler 1'den başladığı için i+1 döndürüyoruz
            }
        }
		*/
		
		return resultWolfID;
		
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter("OUTPUT_PATH"));
		int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(""))
				.map(Integer::parseInt).collect(toList());
		int result = Result.uniqueWolfs(arr);
		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();
		bufferedReader.close();
		bufferedWriter.close();
	}
}