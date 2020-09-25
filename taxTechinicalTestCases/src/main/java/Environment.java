import org.aeonbits.owner.Config;
import  org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:prod.properties" // mention the property file name
})
public interface Environment extends Config {

    String homepage();

    @Key("db.hostname")
    String getDBHostname();

    @Key("db.username")
    String getDBUsername();

    @Key("db.password")
    String getDBPassword();
}