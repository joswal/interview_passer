Take two words and check if a third one is the result of interleaving the first two. Take the following rules into consideration:
1. The number of letters in the third word should be equal to the sum of letters of both words.
2. The letters of the first and second words are not necessarily kept together in the third word, they can be distributed.
   K
3. The order of the letters in the first two words should not appear changed in the third word. For example, if we have abc as one of the first two words it cannot appear in the third word (interleaved or not) as acb or bac.
   
For example, the following are correctly interleaved words:
- `airway` which is composed of `air` plus `way`
- `package` which is composed of `pak` plus `cage`. Note that pak letters are not sequential but interleaved with cage letters

In contrast, the following, are not interleaved according to the rules described above:
- `car` and `rib` as `garib` since the ris shared between car and gib thus breaking rule 1.
- `abe` and `def` as `badgef` since the order of the letters on abc was not maintained, thus breaking rule 3.

Write a function:
```
class Solution { public boolean
solution (String S, String T, String U); }
```

that, given a string S with the first word, a string T with the second word and a string U with the mixed word, returns a boolean True if the words S and T are mixed according to the rules described above or False on the contrary.
You can assume that S, T and U are non-empty words.