package de.felixklauke.portum.server;

import com.google.common.util.concurrent.ListenableFuture;

public interface PortumServer {

    ListenableFuture<Void> start();

    ListenableFuture<Void> stop();
}
