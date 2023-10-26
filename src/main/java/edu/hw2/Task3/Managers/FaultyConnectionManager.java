package edu.hw2.Task3.Managers;

import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.FaultyConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnectionManager implements ConnectionManager {

    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public Connection getConnection() {

        LOGGER.info("Faulty connection found");
        return new FaultyConnection();

    }
}
