# Multitasking vs Multiprocessing vs Multithreading

Multitasking
    - Performing multiple task at single time (switching)
    - Increase CPU performance
    - Multiprocessing and Multithreading

Multiprocessor
    - System connected to multiple processors in order to complete the task
    - System level or OS level thing

Multi-Threading
    - Process: VLC -> (Video, Music, Timer, Progress Bar) -> Threads
    - Executing multiple threads (sub processes) at single time

Create threads (create thread -> runnable -> running (sleep or non-running) -> dead)
    - Thread class
        - class Test extends Thread
        - Override run()
        - Create object in main methods
        - object.start()
    - Runable interface
        - has only run()

## Multithreading

Programming languages are sequential in nature. Code execution happens line by line. In a single threaded program these instructions will be executed one by one. The time consuming section of the code can freeze the entire application.

Solution: Consider the time consuming tasks and decide if theu can be run separately in seperate threads.

Multithreading is the ability of CPU to perform different tasks concurrently.

    class Runner {
        public static void main(String[] args){
            init();
            download();
            processOnData();
            showTheResult();
        }
    }

    Here, if download() is taking too much time which freezes the entire program then, download() can be put into a seperate thread and rest of the methods are kept in the original thread and run both the threads concurrently. 

## Concurrency vs Parallelism and Process vs Threads

Concurrency: Fast switching
Parallelism: Having dedicated CPU/ Core. Not sharing resources.

Process: Instance of a program execution. Like RedGiant, Qusar and Solarflare project Java processes. OS assigns it's own Stack and Heap memory.

Thread: Lightweight processd. Unit of execution within a given program. Singel process can have multiple threads. Each thread in the process shares the memory and resources.

## Time Slicing Algo

Multiple threads which CPU has to ensure that all threads are given chance to execute.
Usage time for the CPU is shared among different threads.

## Pros and Cons of Multithreading

### Pros

- Nuild responsive application
- Better resource utilization
- Better application performance

### Cons

- Synchronication is trichy
- Diffucult to desing
- Thread context switch is expensive

## Thread Life Cycle

New State -> Active State (Runnable & Running) -> Blocked State -> Terminate

## Runnable vs Extended

If we extend the thread, we cannot extend any other class.
If we implement more than one interface, runnable appreach is better.
(Recall Inheritance concept and interfaces here).
