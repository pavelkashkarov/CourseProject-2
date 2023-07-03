package project.Server;

import project.Config;

public class MainServer {

    public static void main(String[] args) {
        Config config = Config.getInstance();
        Server server = new Server();
        server.listen(config.getPort());
    }
}
