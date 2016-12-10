package jadx.core.xmlgen.entry;

public class EntryConfig {
    private String language;
    private String country;
    private String density;
    private String screenSize;
    private String sdkVersion;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocale() {
        StringBuilder sb = new StringBuilder();
        if (density != null) {
            sb.append(density);
        } else if (screenSize != null) {
            sb.append(screenSize);
        }
        if (language != null) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            sb.append(language);
        }
        if (country != null) {
            sb.append("-r").append(country);
        }
        if (sdkVersion != null) {
            if (sb.length() != 0) {
                sb.append("-");
            }
            sb.append(sdkVersion);
        }
        return sb.toString();
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getLocale());
        if (sb.length() != 0) {
            sb.insert(0, " [");
            sb.append(']');
        }
        return sb.toString();
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }
}
