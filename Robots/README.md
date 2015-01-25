Robots is a quick example of using multiple thread in java

It relies on the ConcurrentLinkedQueue which allows for thread safety.

The program consists of a supplier who can add at most 10 items to a queue. The two consumer threads can only take from the head 
and are only interested in certain objects in the list. The supplier can prevent deadlocks by removed the head from the list
if no new items have been added within ~10 secs. The consumer thread, when it has its necessary components require 3 seconds to
complete the building.

The good parts

Factory pattern
I believe the factory pattern for create objects from the supplier is a good approach. By decoupling the creation of objects from the supplier, suppliers can now handle any new product family that is added. New products can be added by simply creating a factory for it.

Abstract Robot 
By creating the abstract robot we have defined what any new robots that are added to the system are required to do. This allows for new robots to be added with ease. For example if a hover robot is added, it inherits from the robot class and implements its DoWork method ( if the hover robot requires a part, then the part is added to the cleaning components factory)

ConcurrentLinkedQueue
Although using this queue is probably overkill for three threads, I think it provides a stable base for the project to grow from. The ConcurrentLinkedQueue has be proven to scale well. 

Limitations of the solution

Instance of checking in workers
Personally I don't think type checking is a good solution when looking at whether the worker should take the item or leave it where it is. A better solution would to either change it to use polymorphism by implementing multiple takeItem methods located in the base class and hooked up in the derived class for items that the current object is interested in but even that has its drawbacks. If there is a requirement for many different types, then an implementation of the visitor pattern would be better suited but for this scenario it would be very much overkill

