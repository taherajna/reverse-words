public class ReverseWords {
  public String reverse(String inputString) {
    StringBuilder word = new StringBuilder();
    StringBuilder reversedInput = new StringBuilder();
    for (int i = 0; i < inputString.length(); i++) {
      if (inputString.charAt(i) == ' ') {
        reversedInput.append(reverseWord(word.toString()));
        reversedInput.append(inputString.charAt(i));
        word = new StringBuilder();
      } else {
        word.append(inputString.charAt(i));
      }
    }
    reversedInput.append(reverseWord(word.toString()));

    return reversedInput.toString();
  }

  private boolean isASpecialCharacter(String inputString, int i) {
    return inputString.charAt(i) < 'A'
        || (inputString.charAt(i) > 'Z' && inputString.charAt(i) < 'a')
        || inputString.charAt(i) > 'z';
  }

  private boolean isANumber(String inputString, int i) {
    return inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9';
  }

  private String reverseWord(String word) {
    boolean[] isCapitalArray = initializeCapitalArray(word);
    char[] charArray = intiliazeCharArray(word);

    for (int i = word.length() - 1, j = 0; i >= 0 && j < word.length(); i--) {
      char appendChar = word.charAt(i);
      if (!(isANumber(word, i) || isASpecialCharacter(word, i))) {
        if (isCapitalArray[j++]) {
          appendChar = Character.toUpperCase(appendChar);
        } else {
          appendChar = Character.toLowerCase(appendChar);
        }
        charArray[getEmptyPosition(charArray)] = appendChar;
      }
    }
    return String.valueOf(charArray);
  }

  private boolean[] initializeCapitalArray(String word) {
    boolean[] isCapitalArray = new boolean[word.length()];
    for (int i = 0, j = 0; i < word.length(); i++) {
      if (isCapitalLetter(word, i)) {
        isCapitalArray[j++] = true;
      } else if (!isASpecialCharacter(word, i) && !isANumber(word, i)) {
        j++;
      }
    }
    return isCapitalArray;
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

  private char[] intiliazeCharArray(String word) {
    char[] charArray = new char[word.length()];
    for (int i = 0; i < word.length(); i++) {
      if (isANumber(word, i) || isASpecialCharacter(word, i)) {
        charArray[i] = word.charAt(i);
      } else {
        charArray[i] = ' ';
      }
    }
    return charArray;
  }
}
