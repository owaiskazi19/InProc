import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeExecExtensions {
    public static void main(String[] args) throws IOException {
        // Executes the specified command and arguments in a separate process with the specified environment and working directory.
        // Returns a new Process object for managing the subprocess
        Process process = Runtime.getRuntime().exec("ls -l");

        BufferedReader stdInput
                = new BufferedReader(new InputStreamReader(
                process.getInputStream()));
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
    }
}
