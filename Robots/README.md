Robots is a quick example of using multiple thread in java

It relies on the ConcurrentLinkedQueue which allows for thread safety.

The program consists of a supplier who can add at most 10 items to a queue. The two consumer threads can only take from the head 
and are only interested in certain objects in the list. The supplier can prevent deadlocks by removed the head from the list
if no new items have been added within ~10 secs. The consumer thread, when it has its neccessary components require 3 seconds to
complete the building.

