import java.math.BigInteger;

public class Main {
    public static void main(String[] args){
        EllipticCurveUtils utl = new EllipticCurveUtils();
        BigInteger p = new BigInteger("4194287"); // 2^22 - 17
        BigInteger d = new BigInteger("314");
        BigInteger n = new BigInteger("1000");
        BigInteger[] a1 = {new BigInteger("4"), new BigInteger("85081")};
        BigInteger[] a2 = {new BigInteger("10"), new BigInteger("65081")};
    }
}
