package OEMRA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            try {
				socket = server.accept();
				oos = new ObjectOutputStream(socket.getOutputStream());
	            ois = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}         // Ŭ���̾�Ʈ�� �����ϸ� ����� �� �ִ� ���� ��ȯ
            
            

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
