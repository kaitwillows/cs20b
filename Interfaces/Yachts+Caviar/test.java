import java.text.DecimalFormat;

class test {
    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("###,###,###,###.00");
        System.out.println(formatter.format(6999));
    }
}
