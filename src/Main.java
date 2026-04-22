
import java.awt.Desktop;
import java.net.URI;
public class Main {
    public static UserInput userInput = new UserInput();
        public static void main(String[] args) throws Exception {
            userInput.printSearchQuery(userInput.getSearch(userInput.getSearchQuery()));
            Desktop.getDesktop().browse(new URI(userInput.getSearch(userInput.getSearchQuery())));
        
        
    }
}
