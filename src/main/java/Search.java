import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class Search {
    public static void main(String[] args) throws Exception {
        GitHub github = GitHub.connectAnonymously();
        int i=1;
        for (GHRepository rep : github.searchRepositories().q("IoT").list())
        {
            System.out.println(i+". "+rep.getHtmlUrl());
            i++;
            if (i==11) break;
        }
    }
}
