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
                }else{
                    char toAdd = convertNumStringToChar(data.substring(0, i+1));
                    if(toAdd != 'n'){
                        numbers.add(toAdd);
                    }
                }

            }
            String numString = new StringBuilder().append(numbers.get(0)).append(numbers.get(numbers.size() - 1)).toString();
            sum += Integer.parseInt(numString);                   
        }
        reader.close();
        System.out.println(sum);
    }

    private static char convertNumStringToChar(String str){
        if(str.endsWith("one")){
            return '1';
        }else if(str.endsWith("two")){
            return '2';
        }else if(str.endsWith("three")){
            return '3';
        }else if(str.endsWith("four")){
            return '4';
        }else if(str.endsWith("five")){
            return '5';
        }else if(str.endsWith("six")){
            return '6';
        }else if(str.endsWith("seven")){
            return '7';
        }else if(str.endsWith("eight")){
            return '8';
        }else if(str.endsWith("nine")){
            return '9';
        }else{
            return 'n';
        }
    }
}
