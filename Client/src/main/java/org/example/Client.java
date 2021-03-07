package org.example;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * gRPC client
 */
public class Client {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest.newBuilder()
                .setName("Nick")
                .build();
        GreetingServiceOuterClass.HelloResponse helloResponse = stub.greeting(request);
        System.out.println(helloResponse.getGreeting());
        channel.shutdownNow();
    }
}
