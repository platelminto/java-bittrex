import java.io.UnsupportedEncodingException;
import java.security.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.*;

public class EncryptionUtility {

	public static String calculateHash(String secret, String url, String encryption) {

		Mac shaHmac = null;

		try {

			shaHmac = Mac.getInstance(encryption);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}

		SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(), encryption);

		try {

			shaHmac.init(secretKey);

		} catch (InvalidKeyException e) {

			e.printStackTrace();
		}

		byte[] hash = shaHmac.doFinal(url.getBytes());
		String check = Hex.encodeHexString(hash);

		return check;
	}

	public static String generateNonce() {

		SecureRandom random = null;
		
		try {

			random = SecureRandom.getInstance("SHA1PRNG");

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}

		random.setSeed(System.currentTimeMillis()); 

		byte[] nonceBytes = new byte[16]; 
		random.nextBytes(nonceBytes); 

		String nonce = null;

		try {

			nonce = new String(Base64.encodeBase64(nonceBytes), "UTF-8");

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		return nonce;
	}
}
