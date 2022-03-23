package interfaces;

public class Status
{
    private String name;
    private String membership_status;

    public Status()
    {
        this.name = new String();
        this.membership_status = new String();
    }

    public void initStatus(String name, String membership_status)
    {
        this.name = name;
        this.membership_status = membership_status;
    }

    public String getName()
    {
        return this.name;
    }

    public String getMembership_status()
    {
        return this.membership_status;
    }
}