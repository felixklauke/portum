# portum
Modern and flexible implementation of the minecraft votifier protocol. Thought as embedded service or middleware.

Portum uses [theresa](https://github.com/FelixKlauke/theresa) for dependency injection and 
[constrictor](https://github.com/d3adspace/constrictor) for networking.

# Installation
**Maven Repositories**

```xml
<repositories>
    <!-- Klauke Enterprises Releases -->
    <repository>
        <id>klauke-enterprises-maven-releases</id>
        <name>Klauke Enterprises Maven Releases</name>
        <url>https://repository.klauke-enterprises.com/repository/maven-releases/</url>
    </repository>
	
    <!-- Klauke Enterprises Snapshots -->
    <repository>
        <id>klauke-enterprises-maven-snapshots</id>
        <name>Klauke Enterprises Maven Snapshots</name>
        <url>https://repository.klauke-enterprises.com/repository/maven-snapshots/</url>
    </repository>
</repositories>
```

**Maven dependency**
```xml
<dependency>
  <groupId>com.felixklauke.portum</groupId>
  <artifactId>portum-server</artifactId>
  <version>1.0.0</version>
</dependency>
```

# Usage
```java
public final class ServerExample {
  private final PortumServer server = PortumServerFactory.createServer(PortumServerConfig
      .createBuilder()
      .createPortumServerConfig());
}
```
