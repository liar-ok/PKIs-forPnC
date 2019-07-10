package kr.ac.hmcl.mju.V2G_2_RootCA;

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
import java.net.SocketException;

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

            System.out.println("-------wait to connect------");
            try {
				socket = server.accept();
				oos = new ObjectOutputStream(socket.getOutputStream());
	            ois = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}         // Ŭ���̾�Ʈ�� �����ϸ� ����� �� �ִ� ���� ��ȯ
            System.out.println("request from"+socket.getInetAddress());
            
            

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
            try {
				stopServer();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        
        return getData;
    }
	
	public void sendPacket(byte[] sendData) {
        if (oos == null) return;
        try {
            oos.writeObject(sendData);
            System.out.println("send packet ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
