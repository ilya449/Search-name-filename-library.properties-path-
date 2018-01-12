import org.kohsuke.github.*;

public class Search {
    public static void main(String[] args) throws Exception {
        GitHub github = GitHub.connectUsingPassword("iluhachernyshov@ukr.net","63h0dUcONW121q");
        /*
        int i=1;
        for (GHContent cont : github.searchContent().q("name").filename("library.properties").path("/").list())
        {
            System.out.println(". "+cont.getHtmlUrl());
            i++;
            if (i==6) break;
        }
        */
        //System.out.println(github.searchContent().q("name").filename("library.properties").path("/").list().getTotalCount());
    }
}
