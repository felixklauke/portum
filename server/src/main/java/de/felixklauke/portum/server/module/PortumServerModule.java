package de.felixklauke.portum.server.module;

import com.google.inject.AbstractModule;
import de.felixklauke.portum.server.PortumServer;
import de.felixklauke.portum.server.PortumServerImpl;

public class PortumServerModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(PortumServer.class).to(PortumServerImpl.class);
    }
}
