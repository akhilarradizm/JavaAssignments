import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.util.*;

public class Ping{

    public static void main(String[] args) {
        String address;
        int port,reps;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter IP: ");
        address = scanner.next();

        System.out.println("Enter port number: ");
        port = scanner.nextInt();
        System.out.println("Enter number of reps");
        reps=scanner.nextInt();
        System.out.println("Median Ping time is :"+(String.valueOf(getMedian(address, port, reps))));
    }


    public static double getMedian(String ipAddress, int port, int reps)
    {
        ArrayList<Long> pingTimes = new ArrayList<>();
        pingTimes = getPingTimes(ipAddress, port, reps);
        Collections.sort(pingTimes);
        int length = pingTimes.size();

        if(length%2 == 1){
            return pingTimes.get(length/2+1);
        }
        else {
            Double val = (double) (pingTimes.get(length / 2) + pingTimes.get(length / 2 + 1)) / 2;
            return val;
        }
    }

    public static ArrayList<Long> getPingTimes(String ipAddress, int port, int reps)
    {
        ArrayList<Long> times = new ArrayList<>();

        for (int i = 0; i < reps; i++) {
            try {
                long responseTime = 0;

                InetAddress inetAddress = InetAddress.getByName(ipAddress);
                InetSocketAddress socketAddress = new InetSocketAddress(inetAddress, port);

                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(true);

                Date start = new Date();
                if(socketChannel.connect(socketAddress)) {
                    Date stop = new Date();
                    responseTime = (stop.getTime()) - start.getTime();
                    times.add(responseTime);
                }

                socketChannel.close();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return times;
    }
}