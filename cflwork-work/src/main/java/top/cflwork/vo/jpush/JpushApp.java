package top.cflwork.vo.jpush;

public enum JpushApp {
    HOTEL(0,"a91e3b75f6a5315817f79937","32188b0f1e431f614d1e14ad");
    private final int id;
    private final String key;
    private final String secret;
    JpushApp(int id,String key, String secret) {
        this.id=id;
        this.key=key;
        this.secret=secret;
    }

    public int getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getSecret() {
        return secret;
    }

    public static JpushApp getValueById(int id){
        final JpushApp[] values = JpushApp.values();
        for (JpushApp value : values) {
            if(value.id==id){
                return value;
            }
        }
        return null;
    }




}
