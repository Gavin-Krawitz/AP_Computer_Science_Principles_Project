import org.htmlunit.BrowserVersion;
import org.htmlunit.FailingHttpStatusCodeException;
import org.htmlunit.WebClient;
import org.htmlunit.html.DomElement;
import org.htmlunit.html.HtmlPage;
import java.net.URLEncoder;
import java.util.*;

import javax.swing.text.html.HTML;

import java.net.URLEncoder;
import java.awt.Desktop;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
public class UserInput{
public Scanner userInput=new Scanner(System.in);
public WebClient webClient = new WebClient(BrowserVersion.CHROME);
public String urlKey;
public String searchString;
public String encodedSearch;
    public UserInput(){
        webClient.getOptions().setUseInsecureSSL(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setCssEnabled(false);

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
    public void printSearchQuery(String input){
        System.out.println("Your YouTube search query is https://www.youtube.com/results?search_query="+input);
    }

    public String getYoutubeVideoViaURL(String input){
        return "https://www.youtube.com/watch?v="+input;
    }

    public String getSearchQuery() throws UnsupportedEncodingException{
        System.out.println("Please type in a search query to look up the YouTube video you want");
        searchString=userInput.nextLine();
        String encodedSearch = URLEncoder.encode(searchString, "UTF-8");
        return encodedSearch;

    }
    public String getSearch(String input) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
        HtmlPage searchPage = webClient.getPage("https://www.youtube.com/results?search_query="+input);
        List<DomElement> links = searchPage.getByXPath("i.ytimg.com/vi");
        for(DomElement link:links){
            String urlName=link.asNormalizedText();
            System.out.println(urlName);
        }
        return "https://www.youtube.com/results?search_query="+input;
    }
    public String getInput(){
        return userInput.nextLine();
    }
    public int getIntInput(){
        return userInput.nextInt();
    }





}