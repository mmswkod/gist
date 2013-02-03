gist
====

The best  spelling 


+++++

Write a program that reads a large list of English words 
(e.g. /usr/share/dict/words on a unix system) into memory, 
and then reads words from stdin, and prints either the best 
spelling suggestion (based on the rules below), or "NO SUGGESTION" 
if no suggestion can be found. The program should print ">" 
as a prompt before reading each word, and should loop until killed.
 
This is what an interactive session with your code should look like:
 
> sandwich
sandwich
> sheeeeep
sheep
> peepple
people
> sheeple
NO SUGGESTION
>
Your code should correct the following three classes of 
spelling mistakes:
 
Case (upper/lower) errors: "inSIDE" => "inside"
Repeated letters: "jjoobbb" => "job"
Incorrect vowels: "weke" => "wake"
Any combination of the above types of error in a single word 
should be corrected (e.g. "CUNsperrICY" => "conspiracy" 
or "ffoaoaoaoaoaoaaoaoaoaoaoadd" => "food").
 
If the word is in the dictionary, your program should 
respond with that word.
 
If there are many possible corrections of an input word, 
your program can choose one in any way you like. It just 
has to be a word from the dictionary that is a spelling 
correction of the input by the above rules.
 
Extra credit: Write a second program that *generates* words 
with spelling mistakes of the above form, starting with 
correctly spelled English words. Pipe its output into the 
first program and verify that there are no occurrences 
of "NO SUGGESTION" in the output.
 
This problem should take two to four hours. If you're 
spending much more than that, it's fine to stop and send 
us what you have along with an outline of what's left.
