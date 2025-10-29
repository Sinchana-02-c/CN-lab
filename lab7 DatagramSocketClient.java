package datagramsocketClient;
import java.net.*;
public class DatagramSocketClient {
    public static void main(String args [])throws Exception{
        String line="connected with Client";
        DatagramSocket ClientSocket=new DatagramSocket();
        InetAddress IPAddress=InetAddress.getByName("localhost");
        byte[] sendData=new byte[1024];
        byte[] receiveData=new byte[1024];
        sendData=line.getBytes();
        DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,9000);
        ClientSocket.send(sendPacket);
        System.out.println("****Client display terminal****");
        while(true){
            DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
            ClientSocket.receive(receivePacket);
            String messageReceived=new String (receivePacket.getData(),receivePacket.getOffset(),receivePacket.getLength());
            System.out.println("message typed at server side is:"+messageReceived);
        }
    }
}
    
