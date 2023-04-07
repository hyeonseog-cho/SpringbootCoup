import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Running {
    public static void main(String[] args) throws IOException {
        List<String> commands = new ArrayList<>();
        commands.add("git stash");
        commands.add("git pull");
        commands.add("mvn clean package");
        commands.add("docker build -t image_coup .");
        commands.add("docker run -p 5000:5000 -v /home/ec2-user/SpringbootCoup:/app image_coup");

        // 명령어를 실행하고 결과를 출력
        for (String command : commands) {
            if (runCommand(command)) {
                System.out.println(command + " success");
            } else {
                System.out.println(command + " failed");
            }
        }
    }

    // 명령어를 실행하는 메소드
    public static boolean runCommand(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        try {
            int exitCode = process.waitFor();
            return exitCode == 0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }
}
