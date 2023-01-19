public class UserAgent {

    final String typeOS;
    final String typeBrowser;
    String[] operatingSystems = {"Windows", "macOS", "Linux"};
    String[] browsers = {"Edge", "Firefox", "Chrome", "Opera"};

    UserAgent(String userAgent) {
        this.typeOS = parseOSFromUserAgent(userAgent);
        this.typeBrowser = parseBrowserFromUserAgent(userAgent);
    }

    public String getTypeOS() {
        return typeOS;
    }

    public String getTypeBrowser() {
        return typeBrowser;
    }

    public String parseOSFromUserAgent(String userAgent) {
        for(int i = 0; i < operatingSystems.length; i++) {
            if (userAgent.contains(operatingSystems[i]))
                return operatingSystems[i];
        }
            return "";
    }

    public String parseBrowserFromUserAgent(String userAgent) {
        for(int i = 0; i < browsers.length; i++) {
            if (userAgent.contains(browsers[i]))
                return browsers[i];
        }
        return "Another browser";
    }

}
