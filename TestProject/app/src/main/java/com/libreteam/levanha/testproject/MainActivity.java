package com.libreteam.levanha.testproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MainActivity extends AppCompatActivity {
    private final static String RSA = "RSA";
    private final String PRIVATE_KEY = "privateKey";
    private final String PUBLIC_KEY = "publicKey";

    public static PublicKey publicKey;

    public static PrivateKey privateKey;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createGenerateKey();
        Log.e("private key ", privateKey.toString());
        saveRsaKey();
        try {
            getRsaKey();
            Log.e("private key get", privateKey.toString());
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    public String publicKeyTosring(final PublicKey pubKey) {
        return Base64.encodeToString(pubKey.getEncoded(), Base64.DEFAULT);
    }

    public String privateKeyTosring(final PrivateKey priKey) {
        return Base64.encodeToString(priKey.getEncoded(), Base64.DEFAULT);
    }

    public PublicKey stringToPublickey(final String strPublicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] publicKeyByte = Base64.decode(strPublicKey.getBytes(), Base64.DEFAULT);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKeyByte);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(spec);
    }

    public PrivateKey stringToPrivatekey(final String strPrivateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] privateKeyByte = Base64.decode(strPrivateKey.getBytes(), Base64.DEFAULT);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyByte);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        return fact.generatePrivate(keySpec);

    }

    public void createGenerateKey() {

        try {
            SecureRandom sr = new SecureRandom();
            //Thuật toán phát sinh khóa - Rivest Shamir Adleman (RSA)
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048, sr);

            //Phát sinh cặp khóa
            KeyPair kp = kpg.genKeyPair();
            //PublicKey
            publicKey = kp.getPublic();
            Log.e("RSA create pubKey", publicKey.toString());

            //PrivateKey
            privateKey = kp.getPrivate();


        } catch (Exception e) {
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT);
        }
    }

    public void saveRsaKey() {
        sharedPreferences = getSharedPreferences("rsaKey", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PUBLIC_KEY, publicKeyTosring(publicKey));
        editor.putString(PRIVATE_KEY, privateKeyTosring(privateKey));
        editor.apply();
    }

    public void getRsaKey() throws InvalidKeySpecException, NoSuchAlgorithmException {
        sharedPreferences = getSharedPreferences("rsaKey", MODE_PRIVATE);
        privateKey = stringToPrivatekey(sharedPreferences.getString(PRIVATE_KEY, null));
        publicKey = stringToPublickey(sharedPreferences.getString(PUBLIC_KEY, null));
    }

    public String RSAEncrypt(final String plain) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {


        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(plain.getBytes());
        System.out.println("EEncrypted?????" + Base64.encodeToString(encryptedBytes, Base64.DEFAULT));
        return Base64.encodeToString(encryptedBytes, Base64.DEFAULT);
    }

    public String RSADecrypt(final String encryptedText) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher1 = Cipher.getInstance("RSA");
        cipher1.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher1.doFinal(Base64.decode(encryptedText, Base64.DEFAULT));
        String decrypted = new String(decryptedBytes);
        System.out.println("DDecrypted?????" + decrypted);
        return decrypted;
    }

    public static String RSAsign(String plainText, PrivateKey privateKey) throws Exception {
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(privateKey);
        privateSignature.update(plainText.getBytes());

        byte[] signature = privateSignature.sign();

        return Base64.encodeToString(signature, Base64.DEFAULT);
    }

    public static boolean RSAverify(String plainText, String signature, PublicKey publicKey) throws Exception {
        Signature publicSignature = Signature.getInstance("SHA256withRSA");
        publicSignature.initVerify(publicKey);
        publicSignature.update(plainText.getBytes());

        byte[] signatureBytes = Base64.decode(signature, Base64.DEFAULT);

        return publicSignature.verify(signatureBytes);
    }
}
