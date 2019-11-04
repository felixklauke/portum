package com.felixklauke.portum.server;

import com.felixklauke.portum.server.config.PortumServerConfig;
import com.felixklauke.portum.server.module.PortumServerModule;
import de.d3adspace.theresa.core.Theresa;
import de.d3adspace.theresa.core.TheresaFactory;
import java.util.Objects;

public class PortumServerFactory {

  public static PortumServer createServer(PortumServerConfig serverConfig) {
    Objects.requireNonNull(serverConfig, "Config cannot be null");

    Theresa theresa = TheresaFactory.create(new PortumServerModule(serverConfig));
    return theresa.getInstance(PortumServer.class);
  }
}
