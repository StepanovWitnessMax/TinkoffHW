package edu.hw2.Task3.Managers;

import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultConnectionManager implements ConnectionManager {

    private final static Logger LOGGER = LogManager.getLogger();

    static final double FAULTY_CONNECTION_PROBABILITY = 0.7;

    @Override
    public Connection getConnection() {

        boolean isFaultyConnection = new Random().nextDouble() <= FAULTY_CONNECTION_PROBABILITY;

        if (isFaultyConnection) {
            LOGGER.info("Faulty connection found");
            return new FaultyConnection();
        } else {
            LOGGER.info("Stable connection found");
            return new StableConnection();
        }

    }
}
