# Multitasking vs Multiprocessing vs Multithreading

Multitasking 
    - Performing multiple task at single time (switching)
    - Increase CPU performance
    - Multiprocessing and Multithreading
    
Multiprocessor
    - System connected to multiple processors in order to complete the task
    - System level or OS level

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