package librarian.kz.boilerplate.data.net;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class ServiceGenerator
{
    private static Service service;

    public static Service getService()
    {
        if(service ==null)
        {
            service = RetrofitHelper.getRetrofit().create(Service.class);
        }
        return service;
    }
}