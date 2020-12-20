package sikuli;

import org.sikuli.basics.Settings;
import org.sikuli.script.ImagePath;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Sikuli {
    public static void init() {
        // Set Sikuli static Settings
        Settings.MinSimilarity = 0.7f;
        Settings.MoveMouseDelay = 0.5f;
        Settings.ActionLogs = false;

        // Add resources to Sikuli image paths
        String projectRoot = System.getProperty("user.dir");
        Path mainResources = Paths.get(projectRoot, "src", "main", "resources");
        Path testResources = Paths.get(projectRoot, "src", "main", "resources");
        ImagePath.add(mainResources.toString());
        ImagePath.add(testResources.toString());
    }
}
