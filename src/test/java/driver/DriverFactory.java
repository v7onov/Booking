package driver;

public class DriverFactory {

    public DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case MOZILLA:
                driverManager = new MozillaDriverManger();
                break;
            case SAFARI:
                driverManager = new SafariDriverManager();
                break;
            case REMOTE:
                driverManager = new RemoteDriverManager();
                break;
            default:
                throw new IllegalStateException("Unexpected driver type: " + type);
        }
        return driverManager;
    }

}
