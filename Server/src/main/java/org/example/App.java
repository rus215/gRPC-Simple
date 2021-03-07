package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * gRPC server runner
 */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080).addService(new GreetingServiceImpl())
                .build();

        server.start();
        server.awaitTermination();
    }
}
