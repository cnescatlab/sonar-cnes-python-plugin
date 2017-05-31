package fr.cnes.sonar.plugins.analysis.tasks;


import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Execute the analysis of a project
 * @author garconb
 */
public abstract class AbstractTask {

    /**
     * logger for all tasks
     */
    private static final Logger LOGGER = Loggers.get(AbstractTask.class);

    /**
     * contain all the task's logs
     */
    private StringBuilder logs = new StringBuilder();

    /**
     * Execute an environment command
     * @param command command to execute on the system
     * @return logs
     * @throws IOException when a stream use goes wrong
     * @throws InterruptedException when a command is not finished
     */
    String executeCommand(String command) throws IOException, InterruptedException {
        // log the command to execute
        LOGGER.info(command);

        // prepare a string builder for the output gathering
        StringBuilder output = new StringBuilder();

        // create a new process
        Process p;
        // execute the process on the runtime
        p = Runtime.getRuntime().exec(command);
        // wait for the end of the process
        p.waitFor();


        // collect input stream
        BufferedReader reader = null;
        // collect error stream
        BufferedReader reader2 = null;

        try {
            // instantiate the readers
            reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            reader2 = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // append input stream to output
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append('\n');
            }
            // append error stream to output
            while ((line = reader2.readLine()) != null) {
                output.append(line).append('\n');
            }
        } finally {
            // close the input reader
            if (reader != null) {
                reader.close();
            }
            // close the output reader
            if (reader2 != null) {
                reader2.close();
            }
        }

        // log output
        String result = output.toString();
        LOGGER.info(result);

        // return the output logs
        return result;
    }

    /**
     * Getter of logs
     * @return the string contained in the StringBuilder
     */
    String getLogs() {
        return logs.toString();
    }

    /**
     * Setter of logs
     * @param logs string to put in a new StringBuilder
     */
    public void setLogs(String logs) {
        this.logs = new StringBuilder().append(logs);
    }

    /**
     * Add logs
     * @param logs string to add
     */
    void log(String logs) {
        this.logs.append(logs);
    }
}
