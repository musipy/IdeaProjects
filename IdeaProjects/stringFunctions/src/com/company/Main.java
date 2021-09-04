package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(reverse("hello"));
        //System.out.println("a"+"a");
    }

    public static int spaceCount(String s){
        int rV = 0;
        String letter = "";//stores the letter of the index, so assgined null string as initial value
        for (int i = 0; i<s.length(); i++){
            letter = s.substring(i,i+1);
            if(letter.compareTo(" ") == 0){
                rV += 1;//no difference add one to rV
            }
        }
        return rV;
    }

    public static int vowelCount(String s){
        int rV = 0;
        s = s.toLowerCase();
        String letter = "";//stores the letter of the index, so assgined null string as initial value
        for (int i = 0; i<s.length(); i++){
            letter = s.substring(i,i+1);
            if(letter.compareTo("a") == 0 || letter.compareTo("e") == 0 || letter.compareTo("i") == 0 ){
                rV += 1;//no difference add one to rV
            } else if (letter.compareTo("o") == 0 || letter.compareTo("u") == 0){
                rV += 1;
            }
        }
        return rV;
    }

    public static int letterCount(String s, String letter){
        int rV = 0;
        String currentLetter = "";//stores the letter of the index, so assgined null string as initial value
        for (int i = 0; i<s.length(); i++){
            currentLetter = s.substring(i,i+1);
            if(letter.compareTo(currentLetter) == 0){
                rV += 1;//if same as given value then add one
            }
        }
        return rV;
    }

    /*
    1. find current letter per index of phrase
    2. check if letter of phrase is equal to letter given
    3. gotta double that letter
    4. Add the beginning of the phrase with the letter (to double) and add to rest of the phrase (concatinate it all)
    i = "hello world"
    s[hello,world]
    loop strings
    <then existing logic>
     */
    public static String duplicate(String s, String letter){
        String rV = "";
        String [] words = s.split(" ");
        String orig = "";
        for (int i = 0; i<words.length; i++){
            String currentLetter = "";//stores the letter of the index, so assgined null string as initial value
            orig = words[i];//stores the original word
            for (int a = 0; a<words[i].length(); a++){
                currentLetter = words[i].substring(a,a+1);
                if(letter.compareTo(currentLetter.toLowerCase()) == 0){
                    orig = orig.substring(0,a+1) + letter + orig.substring(a+1);
                }//finds current letter assigns to s
            }//moving letter by letter within word
            if(words[0].compareTo(words[i]) == 0){
                rV += orig;
            }else{
                rV += " " + orig;
            }
        }//goes word by word
        return rV;
    }

    /*
    1. progress character by character through s
    2. compare if the character in s is equal to the first character in substr
    3. if it is, rV should equal the string from the beginning till the first character of the substr
    4. if substr has more than one character, then compare to see if next character also equals the following character
    of the string
    5. if so then rV should equal the string before the first character appears
    6. if the substr doesn't contain a character in the beginning str, then return entire string
     */
    public static String beforeString(String s, String substr){
        String rV = "";
        int subCount = 0;
        String originalString = "";//stores what is in the index of substr from the original string "word" -> "worl"
        substr = substr.toLowerCase();
        for(int i = 0; i < s.length()-1; i++) {
            if (s.substring(i,i+1).toLowerCase().compareTo(substr.substring(subCount,subCount+1)) == 0){
                originalString = s.substring(i-subCount,i+1);//storing what is in original string
                rV = s.substring(0,i-subCount);//storing the string from beginning to first substr letter w/o 1st char.
                if (subCount < substr.length()-1) {
                    subCount += 1;//until the sbstr length is reached -> otherwise it will run out of index
                }
                if (originalString.toLowerCase().compareTo(substr) != 0){
                    rV = s;//returns entire string
                }
            }
        }
        return rV;
    }

    /*
    1. transition character to character in original string
    2. find where the string matches
    3. return string from where it matches to the end of the string, excluding letter matched
    4. if more than one character in sbstr, return value after last letter in substr
    5. if no match then return entire string
     */
    public static String afterString(String s, String substr){
        String rV = s;
        int subCount = 0;
        String originalString = "";//stores what is in the index of substr from the original string "word" -> "worl"
        substr = substr.toLowerCase();
        for(int i = 0; i < s.length()-1; i++) {
            if (s.substring(i,i+1).toLowerCase().compareTo(substr.substring(subCount,subCount+1)) == 0){
                originalString = s.substring(i-subCount,i+1);//storing what is in original string
                rV = s.substring(i+1,s.length());//storing the string from end of substr to end of string
                if (subCount < substr.length()-1) {
                    subCount += 1;//until the sbstr length is reached -> otherwise it will run out of index
                }
                if (originalString.toLowerCase().compareTo(substr) != 0){
                    rV = s;//returns entire string
                }
            }
        }
        return rV;
    }

    /*
    1. proceed character by character within original string
    2. check if current character matches a vowel (CASE SENSITIVE)
    3. capitalize the vowel and concatinate with rest of the original string
     */
    public static String capVowel(String s){
        String rV = s;
        for(int i = 0; i<s.length(); i++){
            //go char by char and compare to vowel a
            if (s.substring(i,i+1).toLowerCase().compareTo("a") == 0){
                rV = rV.substring(0,i) + s.substring(i,i+1).toUpperCase() + rV.substring(i+1,s.length());
            }
            //go char by hcar and compare to vowel e
            if (s.substring(i,i+1).toLowerCase().compareTo("e") == 0){
                rV = rV.substring(0,i) + s.substring(i,i+1).toUpperCase() + rV.substring(i+1,s.length());
            }
            //go char by hcar and compare to vowel i
            if (s.substring(i,i+1).toLowerCase().compareTo("i") == 0){
                rV = rV.substring(0,i) + s.substring(i,i+1).toUpperCase() + rV.substring(i+1,s.length());
            }
            //go char by hcar and compare to vowel o
            if (s.substring(i,i+1).toLowerCase().compareTo("o") == 0){
                rV = rV.substring(0,i) + s.substring(i,i+1).toUpperCase() + rV.substring(i+1,s.length());
            }
            //go char by hcar and compare to vowel e
            if (s.substring(i,i+1).toLowerCase().compareTo("u") == 0){
                rV = rV.substring(0,i) + s.substring(i,i+1).toUpperCase() + rV.substring(i+1,s.length());
            }
        }
        return rV;
    }

    /*
    1. split into array
    2. go element by element
    3. within each element capitalize first character in element
    4. concatinate with rest of element after capitalizing the first letter, and add rest of element
     */
    public static String capFirstWord(String s){
        String rV = "";
        String [] sentences = s.split("\\. ");// split into array based on where ._ occurs
        for(int i = 0; i<sentences.length; i++){
            String currentSentence = sentences[i];//assign the first sentence into a seperate variable to get 1st elem.
            currentSentence = currentSentence.substring(0,1).toUpperCase()+currentSentence.substring(1);
            if(sentences[i].compareTo(sentences[0]) == 0){
                rV += currentSentence;//if first sentence don't add period
            } else {
                rV += ". " + currentSentence;//otherwise add period and space before sentence.
            }
        }
        return rV;
    }

    /*
    1. keep rV initially as false
    2. compare letter to each vowel
    3. if match then return as true
    4. else return as false
     */
    public static boolean isVowel(String s){
        boolean rV = false;//default return false
        s = s.toLowerCase();//set vowel to lower case since case sensitive
        //compare to vowels and if match then return true
        if(s.compareTo("a") == 0 || s.compareTo("e") == 0|| s.compareTo("i") == 0){
            rV = true;
        } else if(s.compareTo("o") == 0 || s.compareTo("u") == 0){
            rV = true;
        }
        return rV;
    }

    /*
    1. concat within substring
    2. assign beginning value to end value
    3. concatinate
    4. CANT CHANGE STRING VALUE ITSELF, BUT CONCAT AND REDIFINE AS YOU GO
     */
    public static String reverse(String s){
        String rV = "";
        for(int i = 0; i<s.length(); i++){
            rV += s.substring(s.length()-(i+1),s.length()-i);//concatinating last letter and one before etc.
        }
        return rV;
    }

}
