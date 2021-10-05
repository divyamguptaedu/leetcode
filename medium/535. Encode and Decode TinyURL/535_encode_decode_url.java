"
Performance:
Runtime: 4 ms, faster than 66.24% of Java online submissions for Encode and Decode TinyURL.
Memory Usage: 39.9 MB, less than 30.81% of Java online submissions for Encode and Decode TinyURL.
"
public class Codec {
    Integer count = 0;
    Map<String,String> map = new HashMap<>();
    
    public String encode(String longUrl) {
        String key = count.toString();
        count++;
        map.put(key, longUrl);
        return key;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));