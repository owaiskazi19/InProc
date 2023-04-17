import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessBuilderExtensions {

    public static void main(String[] args) throws IOException {
        // creating list of process
        List<String> list = new ArrayList<String>();
        list.add("ls");
        list.add("-l");

        // create the process
        //The ProcessBuilder.start() and Runtime.exec methods create a native process and return an instance of a subclass of
        // Process that can be used to control the process and obtain information about it.
        // The class Process provides methods for performing input from the process, performing output to the process,
        // waiting for the process to complete, checking the exit status of the process, and destroying (killing) the process.
        ProcessBuilder pb = new ProcessBuilder(list);

        //start the process
        Process process = pb.start();

        // ProcessBuilder supports the following methods:
        /*
        destroy() - Kills the subprocess
        exitValue() - Returns the exit value for the subprocess
        getErrorStream() - Gets the error stream of the subprocess.
        getInputStream() - Gets the input stream of the subprocess.
        getOutputStream() - Gets the output stream of the subprocess.
        waitFor() - causes the current thread to wait, if necessary, until the process represented by this Process object has terminated.
         */

        // To run a bash script
        //pb.command(new File("pathname").getCanonicalPath() + "/script.sh");

        BufferedReader stdInput
                = new BufferedReader(new InputStreamReader(
                process.getInputStream()));
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

    }
}
