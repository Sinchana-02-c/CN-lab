package datagramsocketserver;
import java.net.*;
import java.util.*;
public class DatagramSocketServer {
    public static void main(String args [])throws Exception{
        Scanner in=new Scanner(System.in);
        DatagramSocket ServerSocket=new DatagramSocket(9000);
        byte[] receiveData=new byte[1024];
        byte[] sendData=new byte[1024];
        System.out.println("****Server side****");
        DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
        ServerSocket.receive(receivePacket);
        System.out.println(new String(receivePacket.getData()));
        InetAddress IPAddress=receivePacket.getAddress();
        int port=receivePacket.getPort();
        while(true){
            System.out.println("type some message to display at Client end");
            String message=in.nextLine();
            sendData=message.getBytes();
            System.out.println("message sent from server:"+new String(sendData));
            DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,port);
            ServerSocket.send(sendPacket);
        }
    }
        }
        
