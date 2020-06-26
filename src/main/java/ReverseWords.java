public class ReverseWords {

  public String reverse(String inputString) {
    char[] reversedArray = new char[inputString.length()];
    int reversedArrayIndex = 0;
    int start = 0, end = 0;
    for (int i = 0; i < inputString.length(); i++) {
      if (inputString.charAt(i) == ' ') {
        reversedArrayIndex =
            reverseWord(inputString, start, end, reversedArray, reversedArrayIndex);
        reversedArray[reversedArrayIndex++] = inputString.charAt(i);
        start = i + 1;
        end = i + 1;
      } else {
        end++;
      }
    }
    reverseWord(inputString, start, end, reversedArray, reversedArrayIndex);

    return String.valueOf(reversedArray);
  }

  private boolean isASpecialCharacter(String inputString, int i) {
    return inputString.charAt(i) < 'A'
        || (inputString.charAt(i) > 'Z' && inputString.charAt(i) < 'a')
        || inputString.charAt(i) > 'z';
  }

  private int reverseWord(
      String inputString,
      int startIndex,
      int endIndex,
      char[] reversedArray,
      int reversedArrayIndex) {
    boolean[] isCapitalArray = initializeCapitalArray(inputString, startIndex, endIndex);
    char[] charArray = intiliazeCharArray(inputString, startIndex, endIndex);

    for (int i = endIndex - startIndex - 1, j = 0; i >= 0 && j < endIndex - startIndex; i--) {
      char appendChar = inputString.charAt(startIndex + i);
      if (!isASpecialCharacter(inputString, startIndex + i)) {
        if (isCapitalArray[j++]) {
          appendChar = Character.toUpperCase(appendChar);
        } else {
          appendChar = Character.toLowerCase(appendChar);
        }
        charArray[getEmptyPosition(charArray)] = appendChar;
      }
    }
    for (char c : charArray) {
      reversedArray[reversedArrayIndex++] = c;
    }

    return reversedArrayIndex;
  }

  private boolean isCapitalLetter(String word, int i) {
    return word.charAt(i) >= 'A' && word.charAt(i) <= 'Z';
  }

  private int getEmptyPosition(char[] charArray) {
    int emptyPosition = 0;
    for (int i = 0; i < charArray.length; i++) {
      if (charArray[i] == ' ') {
        emptyPosition = i;
        break;
      }
    }
    return emptyPosition;
  }

  private boolean[] initializeCapitalArray(String word, int startIndex, int endIndex) {
    boolean[] isCapitalArray = new boolean[endIndex - startIndex];
    for (int i = 0, j = 0; i < isCapitalArray.length; i++) {
      if (isCapitalLetter(word, startIndex + i)) {
        isCapitalArray[j++] = true;
      } else if (!isASpecialCharacter(word, startIndex + i)) {
        j++;
      }
    }
    return isCapitalArray;
  }

  private char[] intiliazeCharArray(String word, int startIndex, int endIndex) {
    char[] charArray = new char[endIndex - startIndex];
    for (int i = 0; i < charArray.length; i++) {
      if (isASpecialCharacter(word, startIndex + i)) {
        charArray[i] = word.charAt(startIndex + i);
      } else {
        charArray[i] = ' ';
      }
    }
    return charArray;
  }
}
