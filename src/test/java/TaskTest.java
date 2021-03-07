import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TaskTest {
    static ArrayList<String> expectedAdresses;
    static HashMap<String,ArrayList<String>> expectedSortedAdresses;
    @BeforeClass
    public static void initializer () {
        expectedAdresses = new ArrayList<String>();
        expectedAdresses.add("DEVELOPER.@gmail.com");
        expectedAdresses.add("t+es+ter@GMAIL.COM");
        expectedAdresses.add("T@bmail.com");
        expectedAdresses.add("a@gmail.com.ru");
        expectedAdresses.add("D.eveloper@Gmail.Com");
        expectedAdresses.add("a+b@gmail.com.ru");
        expectedSortedAdresses = new HashMap<>();
        expectedSortedAdresses.put("t@bmail.com", new ArrayList<String>());
        expectedSortedAdresses.put("t@gmail.com", new ArrayList<String>());
        expectedSortedAdresses.put("a@gmail.com.ru", new ArrayList<String>());
        expectedSortedAdresses.put("a+b@gmail.com.ru", new ArrayList<String>());
        expectedSortedAdresses.put("developer@gmail.com", new ArrayList<String>());
        expectedSortedAdresses.get("t@bmail.com").add("T@bmail.com");
        expectedSortedAdresses.get("t@gmail.com").add("t+es+ter@GMAIL.COM");
        expectedSortedAdresses.get("a@gmail.com.ru").add("a@gmail.com.ru");
        expectedSortedAdresses.get("a+b@gmail.com.ru").add("a+b@gmail.com.ru");
        expectedSortedAdresses.get("developer@gmail.com").add("DEVELOPER.@gmail.com");
        expectedSortedAdresses.get("developer@gmail.com").add("D.eveloper@Gmail.Com");
    }
    @Test
    public void getAdressesTest () {
        Scanner scanner = new Scanner(
                "6\n" +
                "DEVELOPER.@gmail.com\n" +
                "t+es+ter@GMAIL.COM\n" +
                "T@bmail.com\n" +
                "a@gmail.com.ru\n" +
                "D.eveloper@Gmail.Com\n" +
                "a+b@gmail.com.ru");
        ArrayList<String> adresses = Task.getAdresses(scanner);
        Assert.assertEquals(expectedAdresses, adresses);
    }
    @Test
    public void sortTest () {
        HashMap<String,ArrayList<String>> sortedAdresses = Task.sort(expectedAdresses);
        Assert.assertEquals(expectedSortedAdresses,sortedAdresses);
    }
    @Test
    public void getResultStringTest () {
        String expectedString = "5\n" +
                "1 T@bmail.com \n" +
                "1 t+es+ter@GMAIL.COM \n" +
                "1 a@gmail.com.ru \n" +
                "1 a+b@gmail.com.ru \n" +
                "2 DEVELOPER.@gmail.com D.eveloper@Gmail.Com \n";
        String string = Task.getResultString(expectedSortedAdresses);
        Assert.assertEquals(expectedString, string);
    }
}
