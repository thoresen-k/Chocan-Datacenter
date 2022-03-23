package encryption;

public class Hash_Function {

    // User will utilize this function to store their password on DB
    public int create_hash(String to_hash){
        int hashCode = to_hash.hashCode();

        return hashCode;
    }

    // User enters in their password here
    public boolean decrypt_hash(String to_decrypt){
        int hashCode = to_decrypt.hashCode();

        System.out.println(hashCode);

        return true;
    }


}
