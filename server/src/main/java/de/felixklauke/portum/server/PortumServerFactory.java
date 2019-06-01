package de.felixklauke.portum.server;

import de.d3adspace.theresa.core.Theresa;
import de.d3adspace.theresa.core.TheresaFactory;
import de.felixklauke.portum.server.module.PortumServerModule;

public class PortumServerFactory {

    public static PortumServer createServer() {

        Theresa theresa = TheresaFactory.create(new PortumServerModule());
        return theresa.getInstance(PortumServer.class);
    }
}
