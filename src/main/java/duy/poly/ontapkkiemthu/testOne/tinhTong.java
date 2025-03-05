package duy.poly.ontapkkiemthu.testOne;

public class tinhTong {

    public Integer tong(int[] arr) {
        if (arr == null) {
            throw new NullPointerException("Mảng không được là null");
        }
        long sum = 0;
        for (int num : arr) {
            sum += num;
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                throw new ArithmeticException("Kết quả bị tràn số nguyên kiểu int");
            }
        }

        return (int) sum;
    }

}
