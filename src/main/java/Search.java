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
            //System.out.println(s);
            repo = github.getRepository(s);
            System.out.print(repo.getOwnerName() + ", ");
            System.out.print(repo.getName() + ", ");
            System.out.print(repo.getDefaultBranch() + ", ");
            System.out.print(repo.getStargazersCount()+"\n");
            file.write(repo.getOwnerName() + ", "+repo.getName() + ", "+repo.getDefaultBranch() + ", "+repo.getStargazersCount());
            file.write(System.getProperty("line.separator"));
            Thread.sleep(2001);
            i++;
            if (i == 10) break;
        }
        file.close();
    }
}
