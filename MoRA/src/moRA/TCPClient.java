package moRA;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class TCPClient {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;

	public void clientRun(int port) {

		try {
			socket = new Socket("localhost", port);
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("ok");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public byte[] receivePacket(){
        byte[] recData = null;
        try {
        	if(!socket.isClosed()) {
        		recData = (byte[]) ois.readObject();
        	}
            
        } catch (IOException e) {
            e.printStackTrace();
            return recData;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return recData;
        }
        return recData;
    }


    public void sendPacket(byte[] sendData){
        if (oos == null) return;
        try {
            oos.writeObject(sendData);
        } catch (IOException e) {
            e.printStackTrace();
            clientStop();
        }
    }
	
	public void clientStop() {
		try {
			socket.close();
			ois.close();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
