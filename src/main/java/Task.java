import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> adresses = getAdresses(scanner);
        HashMap<String,ArrayList<String>> sortedAdresses = sort(adresses);
        String resultString = getResultString(sortedAdresses);
        System.out.println(resultString);
    }
    static ArrayList<String> getAdresses (Scanner scanner) {
        ArrayList<String> adresses = new ArrayList<String>();
        int lenght = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < lenght; i++) {
            adresses.add(scanner.nextLine());
        }
        return adresses;
    }
    static HashMap<String,ArrayList<String>> sort (ArrayList<String> adresses) {
        HashMap<String,ArrayList<String>> sortedAdresses = new HashMap<>();
        for (String adress : adresses) {
            String newAdress = adress.toLowerCase();
            String[] arrayAdress = newAdress.split("@");
            if (arrayAdress[1].equals("gmail.com")) {
                arrayAdress[0] = arrayAdress[0].replaceAll("\\.","");
                if (arrayAdress[0].contains("+")) {
                arrayAdress[0] = arrayAdress[0].substring(0, arrayAdress[0].indexOf("+"));
                }
                newAdress = arrayAdress[0] +"@" + arrayAdress[1];
            }
            if (sortedAdresses.containsKey(newAdress)) {
                sortedAdresses.get(newAdress).add(adress);
            } else {
                sortedAdresses.put(newAdress, new ArrayList<String>());
                sortedAdresses.get(newAdress).add(adress);
            }
        }
        return sortedAdresses;
    }
    static String getResultString (HashMap<String,ArrayList<String>> sortedAdresses) {
        String resultString = sortedAdresses.size() + "\n";
        for (Map.Entry<String,ArrayList<String>> entry : sortedAdresses.entrySet()) {
            resultString += entry.getValue().size() + " ";
            for (String str : entry.getValue()) {
                resultString += str + " ";
            }
            resultString += "\n";
        };
        return resultString;
    }
}
