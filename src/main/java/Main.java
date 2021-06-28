class Main {

  public static int getValue(char c) {
    if (c == 'I')
      return 1;
    if (c == 'V')
      return 5;
    if (c == 'X')
      return 10;
    if (c == 'L')
      return 50;
    if (c == 'C')
      return 100;
    if (c == 'D')
      return 500;
    if (c == 'M')
      return 1000;
    return -1;
  }

  public static int BasicRomanNumerals(String str) {
    int result = 0;

    for (int i=0; i < str.length(); i++) {
      // Getting value of symbol s[i]
      int s1 = getValue (str.charAt(i));
      // Getting value of symbol s[i+1]
      if (i + 1 < str.length()) {
        int s2 = getValue(str.charAt(i+1));

        if (s1 >= s2) {
          result = result + s1;
        } else {
          result = result +s2 -s1;
          i++;
        }
      } else {
        result = result + s1;
      }
    }
    return result;
  }

  public static void main (String[] args) {
    // keep this function call here
//    Scanner s = new Scanner(System.in);

    System.out.println(BasicRomanNumerals("VI"));
  }

}