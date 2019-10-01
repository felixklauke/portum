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
</repositories>
```

**Maven dependency**
```xml
<dependencies>
  <dependency>
    <groupId>com.felixklauke.portum</groupId>
    <artifactId>portum-server</artifactId>
    <version>1.0.0</version>
  </dependency>
</dependencies>
```

**Gradle Repositories**

```groovy
repositories {
  maven {
    url = 'https://repository.klauke-enterprises.com/repository/maven-releases/'
  }
}
```

**Gradle dependency**

```groovy
dependencies {
  implementation group: 'com.felixklauke.portum', name: 'portum-server', version: '1.0.0';
}
```

# Usage

As soon as you have imported the server dependency the usage will be pretty much straight forward.   
Just create a portum server condig with the needed vote listeners and create and start a server
with this config. Have fun!

```java
public final class ServerExample {
  private final PortumServer server = PortumServerFactory.createServer(PortumServerConfig
      .createBuilder()
      .createPortumServerConfig());
  
  public ServerExample() {
    server.start();
  }
}
```
