import java.math.BigInteger;

public class EllipticCurveUtils {
    BigInteger[] mul(BigInteger[] a1, BigInteger[] a2, BigInteger d, BigInteger p) {
        BigInteger x1 = a1[0], y1 = a1[1], x2 = a2[0], y2 = a2[1];

        BigInteger x1y2 = x1.multiply(y2).mod(p);
        BigInteger y1x2 = y1.multiply(x2).mod(p);
        BigInteger x1x2 = x1.multiply(x2).mod(p);
        BigInteger y1y2 = y1.multiply(y2).mod(p);
        BigInteger x1x2y1y2 = x1x2.multiply(y1y2).mod(p);
        BigInteger dx1x2y1y2 = d.multiply(x1x2y1y2).mod(p);

        BigInteger num1 = x1y2.add(y1x2).mod(p);
        BigInteger den1 = BigInteger.ONE.add(dx1x2y1y2).mod(p);

        BigInteger num2 = y1y2.subtract(x1x2).mod(p);
        BigInteger den2 = BigInteger.ONE.subtract(dx1x2y1y2).mod(p);

        BigInteger x3 = num1.multiply(den1.modInverse(p)).mod(p);
        BigInteger y3 = num2.multiply(den2.modInverse(p)).mod(p);

        return new BigInteger[]{x3, y3};
    }

    BigInteger[] exp(BigInteger[] a, BigInteger m, BigInteger d, BigInteger p) {
        BigInteger[] b = new BigInteger[]{BigInteger.ZERO, BigInteger.ONE};

        for(int i = m.bitLength() -1; i >= 0; i--){
            b = mul(b, b, d, p);
            if(m.testBit(i)) {
                b = mul(b, a, d, p);
            }
        }
        return b;
    }

    BigInteger[] rho(BigInteger[] a, BigInteger[] b, BigInteger d, BigInteger p, BigInteger n) {
        return new BigInteger[2];
    }

    long check(BigInteger[] a, BigInteger d, BigInteger p, BigInteger n) {
        return -1;
    }
}
