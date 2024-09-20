# Details

## Class Description
You are going to implement something I call the `EvensAndOddsQueue`. Think of it as a type of queue, but it has some features (methods) added and some removed.

This will be built on top of an ArrayList (named `items`), and you must meaningfully find a way to store even and odd numbers inside this list while meeting the restrictions below.

Here's the new methods you'll need to worry about:

- dequeueEven()
- dequeueOdd()
- peekEven()
- peekOdd()

And here's the methods that are removed from the traditional queue:

- peek()
- dequeue()

So it is focused solely on support for even and odd numbers.

## Restrictions
### Implementation
The `ArrayList` that is provided must be specially grown once it reaches capacity. This is not a hard restriction; i.e. if you can find a way around this, bravo to you. I have a feeling you will find it a LOT easier though if you grow it in a manner that you understand.

You must implement this without using any other data structures that have been discussed in class besides the provided ArrayList.

i.e. you may not create:

- Additional ArrayLists
- You may not use a Set
- You may not use a Map
- etc.

However, you may create additional fields as you see fit to handle things like `size()` and to help you with how you format your data.

### Runtimes
Things get a little "hand-wavy" in this section, so pay close attention. There are also JavaDocs on each method to remind you of these in the file itself.

- `size()` must run in `O(1)` time.
- `isEmpty()` must run in `O(1)` time.
- `enqueue()` must run in amortized `O(1)` time.
- `peekEven()` and `peekOdd()` must run in `O(1)` time.
- `dequeueEven()` and `dequeueOdd()` must run in `O(1)`** time.
    - The code that YOU write must be `O(1)`. I am allowing you to use ArrayList's `delete()` method here, which is notably NOT `O(1)`. So you may NOT traverse the list, but it is OK to utilize `delete()`.

## Hints
An `ArrayList` is not a golden ticket for a few of these methods (actually, most of them).

Consider, for example, when adding a mix of even and odd numbers. How can you easily distinguish where one group begins and the other ends? i.e. How can you store your data to force this to be `O(1)` for dequeues (excluding `ArrayList`'s `remove()` operation)?

So for an example of this:

``` java
evensAndOddsQueue.enqueue(2);
evensAndOddsQueue.enqueue(4);
evensAndOddsQueue.enqueue(6);
evensAndOddsQueue.enqueue(7);
evensAndOddsQueue.enqueue(10);
```

Letting your queue simply look like:

| 2 | 4 | 6 | 7 | 10 |

Will not fly when someone calls:

``` java
evensAndOddsQueue.dequeueOdd();
```

Because they will have to traverse almost the entire list. Also, what happens if there are no odds or evens at all?

So it has to be that you have some way to cleverly store your data.

This is also part of the reason why I suggest writing your own method to grow the `ArrayList`, as you can maintain the way you store the data much more easily than relying on throwing items on the end.





