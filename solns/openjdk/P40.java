public final class P40 {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    String s = null;
    int result = 1;

    for (int i = 1; sb.length() < 1000000; i++) {
      sb.append(String.valueOf(i));
    }

    s = sb.toString();
    for (int i = 1; i <= 1000000; i *= 10) {
      char c = s.charAt(i - 1);
      int j = Integer.parseInt(Character.valueOf(c).toString());
      result *= j;
    }

    System.out.println(result);
    assert result == 210;
  }
}
