// 210
// 0.18user 0.04system 0:00.23elapsed 92%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+0outputs (0major+7010minor)pagefaults 0swaps

public class P40 {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    String s = null;
    int product = 1;

    for (int i = 1; sb.length() < 1000000; i++) {
      sb.append(String.valueOf(i));
    }

    s = sb.toString();
    for (int i = 1; i <= 1000000; i *= 10) {
      char c = s.charAt(i - 1);
      int j = Integer.parseInt(new Character(c).toString());
      product *= j;
    }

    System.out.println(product);
  }
}
