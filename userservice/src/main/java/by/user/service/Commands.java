package by.user.service;

/**
 * Created by alka0317 on 8/2/2017.
 */
public enum Commands {

    COMMAND1("url1"),
    COMMAND2("url2"),
    COMMAND3("url3");

    private final String url;

    Commands(String url) {
        this.url = url;
    }

    public String sendCommandtoUrl(){
       System.out.println("Sending to url"+this.url);
       return "ok";
    }
}
