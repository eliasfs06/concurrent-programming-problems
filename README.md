# Concurrent Programming Problems
This repository provides solutions for common concurrency programming challenges, such as the "producer-consumer problem" and the "printing queue problem," using different concurrency techniques. The repository is divided into four directories, each containing a distinct approach to solving the problem in question.

All solutions are implemented in Java.

## Barrier
In this section, we use a CyclicBarrier to implement a concurrent calculation of factorials. A CyclicBarrier is a synchronization aid that allows a set of threads to wait for each other to reach a common point (the barrier) before proceeding. This is useful in tasks where each thread performs part of a calculation independently and then needs to synchronize with others to continue the work.

## Lock
Here, we solve a simple producer-consumer problem using a Lock. A Lock in Java provides a more flexible way of managing synchronization than synchronized blocks, allowing more control over when and how threads can access shared resources. This implementation uses Lock to control access to shared data between producer and consumer threads, preventing race conditions and ensuring thread-safe operations.

## Semaphore
In this directory, we address both the "printing queue" problem and the "producer-consumer problem" using a Semaphore. A Semaphore is a synchronization aid that controls access to a resource by allowing only a set number of threads to access it at any given time. This is particularly useful for managing resource pools or limiting the number of threads in critical sections, as it can restrict access until a permit is available.

## Synchronized
In this section, we solve the "printing queue" problem using the synchronized keyword. synchronized ensures that only one thread can execute a particular section of code at a time, which prevents conflicts when multiple threads try to access shared resources simultaneously. This approach simplifies concurrent programming by automatically acquiring and releasing locks when entering and exiting synchronized blocks.

Feel free to comment, improve, or contribute additional solutions using these or similar approaches.
