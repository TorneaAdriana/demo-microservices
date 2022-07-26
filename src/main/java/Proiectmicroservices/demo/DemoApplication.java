package Proiectmicroservices.demo;

import Proiectmicroservices.demo.services.accounts.AccountsServer;
import Proiectmicroservices.demo.services.registration.RegistrationServer;
import Proiectmicroservices.demo.services.web.WebServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "registration-server");
        SpringApplication.run(RegistrationServer.class, args);

        //	SpringApplication.run(DemoApplication.class, args);
    }


//	public static final String NO_VALUE="NO-VALUE";
//
//	public static void main(String[] args){
//		String serverName=NO_VALUE;
//		String port=null;
//
//		System.setProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME,"localhost");
//
//		for(String arg:args){
//			if(arg.startsWith("--"))
//				continue;
//
//			if(serverName.equals(NO_VALUE))
//				serverName=arg;
//			else if(port==null)
//				port=arg;
//			else {
//				System.out.println("Unexpected argument: "+arg);
//				usage();
//				return ;
//			}
//		}
//
//		if(serverName==NO_VALUE)
//		{
//			usage();
//			return;
//		}
//
//		if(port!=null)
//			System.setProperty("server-port",port);
//
//		try{
//			InetAddress inetAddress=InetAddress.getLocalHost();
//			System.out.println("Running on IP: "+ inetAddress.getHostAddress());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//
//		if(serverName.equals("registration") || serverName.equals("reg")){
//			RegistrationServer.main(args);
//		}
//		else if(serverName.equals("accounts")){
//			AccountsServer.main(args);
//		}
//		else if(serverName.equals("web")){
//			WebServer.main(args);
//		}
//		else{
//			System.out.println("Unknown server type: "+ serverName);
//			usage();
//		}
//	}
//
//	protected static void usage() {
//		System.out.println();
//		System.out.println("Usage: java -jar ... <server-name> [server-port]");
//		System.out.println("     where");
//		System.out.println("       server-name is 'reg', 'registration', " + "'accounts' or 'web'");
//		System.out.println("       server-port > 1024");
//		System.out.println(
//				"     optionally specify --registration.server.hostname=<IP-address> if it is not running on localhost,");
//		System.out.println();
//	}
}
