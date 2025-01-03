/*
import java.math.BigInteger;


class EncodeDecode {
    public static void main(String args[]){

    }

    public static String decryptJWEJWTString(String encryptedString, String identifier) {
        JWT jwtReader = null;
        try{
            jwtReader = JWTParser.parse(encryptedString);

            if (jwtReader instanceof PlainJWT) {
                JSONObject payload = new JSONObject(((PlainJWT) jwtReader).getPayload().toString());
                return payload.getString("id");
            } else if(jwtReader instanceof EncryptedJWT){
                JWEObject jweObject = JWEObject.parse(encryptedString);
                jweObject.decrypt(new KeyMakerJWEDecrypter());
                Payload plainData = jweObject.getPayload();
                if(ApplicationConstants.CARD.equalsIgnoreCase(identifier)){
                    return String.valueOf(new BigInteger(1, plainData.toBytes()));
                }
                return plainData.toString();
            }
        } catch(Exception e){
            logger.error("JWT/JWE Decryption failed. " + encryptedString);
            CalEventFactory.create("Decryption JWT/JWE String", "Decryption failed ", "1",
                    " encrypted String : " + encryptedString + " Exception : "+ e.getMessage()).completed();
        }
        return null;
    }
}*/
