
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
public class Playlist {
    public String[] playlist={"defaultValue"};
    public UserInput input;
    public String decision;
    public String video;
    public Desktop desktop;
    public Playlist(UserInput input, Desktop desktop){
        this.input=input;
        this.desktop=desktop;

    }

    public void addToPlaylist() throws IOException, URISyntaxException{
        System.out.println("Would you like to Search for a video or pull up a video URL");
        System.out.println("Type 'Search Query' to do a search or type 'URL' to paste in the video URL");
        decision=input.getInput();
        while (decision=="URL") {
            System.out.println("Please type 'Search Query' to do a search or type 'URL' to paste in the video URL");
            decision=input.getInput();   
        }
        if (decision=="URL"){
            video=input.getYoutubeVideoViaURL(input.getURLKey());
            desktop.browse(new URI(video));
        }else{
            video=input.getSearch(input.getSearchQuery());
            desktop.browse(new URI(video));
        }
        if (playlist.length==1){
            playlist[0]=video;
        }else{
            playlist=Arrays.copyOf(playlist, playlist.length+1);
            playlist[playlist.length-1]=video;
        }
        System.out.print(playlist[playlist.length-1]);
        
    }
    
}
