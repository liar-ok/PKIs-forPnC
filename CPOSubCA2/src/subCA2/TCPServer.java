package subCA2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer{
	ServerSocket server = null;
    Socket socket = null;
	ObjectOutputStream oos;
    ObjectInputStream ois;
    
	public void serverRun(int port) {
		
        
        
        InputStreamReader isr = null;
        BufferedReader br = null;
        
        try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

            System.out.println("-------접속 대기중------");
            try {
				socket = server.accept();
				oos = new ObjectOutputStream(socket.getOutputStream());
	            ois = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}         // 클라이언트가 접속하면 통신할 수 있는 소켓 반환
            System.out.println(socket.getInetAddress() + "로 부터 연결요청이 들어옴");
            
            

	}
		
	public void stopServer() throws IOException {
        ois.close();
        oos.close();
        server.close();
        
    }
	
	public byte[] receivePacket() {
		byte[] getData = null;
        try {
            getData = (byte[]) ois.readObject();
            System.out.println("receive packet ok");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return getData;
    }
	
	public void sendPacket(byte[] sendData) {
        if (oos == null) return;
        try {
            oos.writeObject(sendData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
