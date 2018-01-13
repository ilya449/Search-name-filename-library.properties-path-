import org.kohsuke.github.*;
import java.io.FileWriter;

/*
ownername, name, defbranch, starscount
*/
public class Search {
    public static void main(String[] args) throws Exception {
        FileWriter file = new FileWriter("D:\\test.txt");
        GitHub github = GitHub.connect();
        GHRepository repo = new GHRepository();
        String s;
        int i = 0;
        for(GHContent cont : github.searchContent().q("name").filename("library.properties").path("/").list())
        {
            //System.out.println(". " + cont.getHtmlUrl());
            s = cont.getHtmlUrl();
            s = s.substring(s.indexOf("github.com/") + 11, s.indexOf("/blob/"));
            repo = github.getRepository(s);
            s="".concat(repo.getOwnerName() + ", ").concat(repo.getName() + ", ").concat(repo.getDefaultBranch() + ", ").concat(String.valueOf(repo.getStargazersCount()));
            System.out.print(s+"\n");
            file.write(s);
            file.write(System.getProperty("line.separator"));
            Thread.sleep(2001);
            i++;
            if (i == 10) break;
        }
        file.close();
    }
}
