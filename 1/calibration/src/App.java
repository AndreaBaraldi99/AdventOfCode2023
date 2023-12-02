import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        File input = new File("1\\calibration\\src\\input.txt");
        Scanner reader = new Scanner(input);
        int sum = 0;
        while(reader.hasNextLine()) {
            List<Character> numbers = new ArrayList<Character>();
            String data = reader.nextLine();
            for(int i = 0; i < data.length(); i++) {
                int check = data.charAt(i) - '0';
                if(check >= 0 && check <= 9) {
                    numbers.add(data.charAt(i));
                }
                
            }
            String numString = new StringBuilder().append(numbers.get(0)).append(numbers.get(numbers.size() - 1)).toString();
            sum += Integer.parseInt(numString);                   
        }
        reader.close();
        System.out.println(sum);
    }
}
