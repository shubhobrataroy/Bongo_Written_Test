# Bongo Android Developer interview Problems 1 to 3
Solution of problem 1 to 3 for Bongo Android Developer code test

##Problem 1 : Anagram evaluator 

-Code Snippet : 
  ~~~kotlin
   //Implementation 
  
   fun checkIsAnagram(value1: String, value2: String): Boolean {

          if (value1.equals(value2)) return true
          else if (value1.length != value2.length) return false

          var value1TreeSet = TreeSet(value1.toList())
          var value2TreeSet = TreeSet(value2.toList())

          return value1TreeSet == value2TreeSet
      }

 
    //Unit Test
    
    @Test
    fun checkIsAnagramCase1() {
        val anagramsEvaluator = AnagramsEvaluator()
        val isAnagramCase1 = anagramsEvaluator.checkIsAnagram("bleat", "table")
        if (!isAnagramCase1) fail("Case 1 gave wrong result")
    }
    @Test
    fun checkIsAnagramCase2() {
        val anagramsEvaluator = AnagramsEvaluator()
        val isAnagramCase2 = anagramsEvaluator.checkIsAnagram("eat", "tar")
        if (isAnagramCase2) fail("Case 2 gave wrong result")
    }
   ~~~


