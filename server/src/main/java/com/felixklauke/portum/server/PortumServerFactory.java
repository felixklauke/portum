package com.felixklauke.portum.server;

import com.felixklauke.portum.server.config.PortumServerConfig;
import com.felixklauke.portum.server.module.PortumServerModule;
import com.google.common.base.Preconditions;
import de.d3adspace.theresa.core.Theresa;
import de.d3adspace.theresa.core.TheresaFactory;

public class PortumServerFactory {

  public static PortumServer createServer(PortumServerConfig serverConfig) {
    Preconditions.checkNotNull(serverConfig);

    Theresa theresa = TheresaFactory.create(new PortumServerModule(serverConfig));
    return theresa.getInstance(PortumServer.class);
  }
}
