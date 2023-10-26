package edu.hw2.Task3;

import edu.hw2.Task3.Managers.DefaultConnectionManager;
import edu.hw2.Task3.Managers.FaultyConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private static final int MAX_ATTEMPTS = 3;

    private Main() {
    }

    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        LOGGER.info("Hello and welcome!");
        PopularCommandExecutor testDefault = new PopularCommandExecutor(new DefaultConnectionManager(), MAX_ATTEMPTS);
        PopularCommandExecutor testFaulty = new PopularCommandExecutor(new FaultyConnectionManager(), MAX_ATTEMPTS);
        testDefault.updatePackages();
        testFaulty.updatePackages();

    }
}
