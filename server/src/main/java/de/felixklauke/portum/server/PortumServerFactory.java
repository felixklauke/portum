package de.felixklauke.portum.server;

import de.d3adspace.theresa.core.Theresa;
import de.d3adspace.theresa.core.TheresaFactory;
import de.felixklauke.portum.server.config.PortumServerConfig;
import de.felixklauke.portum.server.module.PortumServerModule;

public class PortumServerFactory {

    public static PortumServer createServer(PortumServerConfig serverConfig) {

        Theresa theresa = TheresaFactory.create(new PortumServerModule(serverConfig));
        return theresa.getInstance(PortumServer.class);
    }
}
