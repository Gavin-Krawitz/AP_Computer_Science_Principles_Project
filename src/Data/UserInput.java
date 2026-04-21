package Data;
import java.util.*;
public class UserInput{
public Scanner userInput=new Scanner(System.in);
public String urlKey;
    public UserInput(){


    }
    public String getURLKey(){
        System.out.println("Please type in a 11 character sequence to see what Youtube Video you get");
        System.out.println("This 11 character sequence could be any combination of letters, numbers, hyphens, and underscores");
        urlKey=userInput.nextLine();
        while (urlKey.length()!=11) {
            System.out.println("Please type a sequence that is 11 characters long");
            urlKey=userInput.nextLine();
        }
        return urlKey;
    }
    public void printURLKey(String input){
        System.out.println("Your YouTube URL is https://www.youtube.com/watch?v="+input);
    }



}